package domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Player extends Observable {
	private int score;
	private List<Integer> rolled;
	
	public Player() {
		this.score = 0;
		this.rolled = new ArrayList<>();
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int score) {
		this.score+=score;
		scoreChanged();
	}
	
	public List<Integer> getRolled() {
		return this.rolled;
	}
	
	public int roll() {
		this.rolled = new ArrayList<>();
		
		int roll1 = ((int) Math.floor(Math.random()*6)+1);
		int roll2 = ((int) Math.floor(Math.random()*6)+1);
		
		int score = roll1+roll2;
		if (roll1 == roll2) score=score*2;
		
		this.rolled.add(roll1);
		this.rolled.add(roll2);
		
		this.addScore(score);
		return score;
	}
	
	public void scoreChanged() {
		setChanged();
		notifyObservers();
	}
}
