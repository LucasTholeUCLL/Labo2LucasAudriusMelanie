package domain.model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ScoreDisplay implements Display, Observer {
	private int turn;
	private List<Player> players;
	private String message;
	
	public ScoreDisplay(Observable observable) {
		observable.addObserver(this);
		this.message  = "";
	}
	
	public void update(Observable observable, Object arg) {
		if (observable instanceof GameData) {
			GameData gameData = (GameData)observable;
			//update variables
			this.turn = gameData.getTurn();
			this.players = gameData.getPlayers();
			//
			display();
		}
	}
	
	public String display() {
		String message = this.message;
		
		message+="Turn " + (turn-1) + ": ";
		
		for (Player p : players) {
			message+="p" + (players.indexOf(p)+1) + ": " + p.getScore() + " ";
		}
		
		message+="\n";
		this.message=message;
		System.out.println(message);
		return message;
	}
}
