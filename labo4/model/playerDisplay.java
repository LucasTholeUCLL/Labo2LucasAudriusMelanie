package domain.model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class playerDisplay implements Display, Observer {
	private int score;
	private List<Integer> rolled;
	public playerDisplay(Observable observable) {
		observable.addObserver(this);
	}
	
	public void update(Observable observable, Object arg) {
		if (observable instanceof Player) {
			Player player = (Player)observable;
			//update variables
			this.score = player.getScore();
			this.rolled = player.getRolled();
			//
			display();
		}
	}
	
	public String display() {
		String message = "";
		//TODO
		System.out.println(message);
		return message;
	}
}
