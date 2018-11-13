package domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class GameData extends Observable {
	private int turn;
	private List<Player> players;
	private ArrayList<playerDisplay> displays = new ArrayList<>();
	
	public GameData(List<Player> players) {
		turn = 1;
		setPlayers(players);
		ScoreDisplay sd = new ScoreDisplay(this);
	}
	
	public void setPlayers(List<Player> players) {
		if (players.size() < 1) throw new DomainException("Players list can't be empty!");
		this.players = players;
		this.turn = 1;
		scoresChanged("");
	}
	
	public void start() {
		for (Player p : players) {
			this.displays.add(new playerDisplay(this, players.indexOf(p)+1));
		}
		players.get(0).setTurn(true);
		displays.get(0).changeButton(false);
	}
	
	private void nextTurn() {
		if (turn < 4) {
			this.turn++;
			this.getPlayers().get(0).setTurn(true);
			displays.get(0).changeButton(false);
			scoresChanged(turn+"");
		} else {
			this.turn++;
			scoresChanged(turn+"");
		}
	}
	
	public void roll(int player) {
		if (!this.getPlayers().get(player-1).getTurn()) throw new DomainException("It is not this players turn!");
		this.players.get(player-1).roll();
		scoresChanged("roll");
		this.players.get(player-1).setTurn(false);
		if (player == this.players.size()) this.nextTurn();
		else {
			this.getPlayers().get(player).setTurn(true);
			displays.get(player).changeButton(false);
		}
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public int getTurn() {
		return this.turn;
	}
	
	public void scoresChanged(String arg) {
		setChanged();
		notifyObservers(arg);
	}
}
