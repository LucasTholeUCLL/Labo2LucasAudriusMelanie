package domain.model;

import java.util.List;
import java.util.Observable;

public class GameData extends Observable {
	private int turn;
	private List<Player> players;
	
	public GameData(List<Player> players) {
		turn = 1;
		setPlayers(players);
	}
	
	public void setPlayers(List<Player> players) {
		if (players.size() < 1) throw new DomainException("Players list can't be empty!");
		this.players = players;
		this.turn = 1;
		scoresChanged();
	}
	
	public void nextTurn() {
		this.turn++;
		scoresChanged();
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public int getTurn() {
		return this.turn;
	}
	
	public void scoresChanged() {
		setChanged();
		notifyObservers();
	}
}
