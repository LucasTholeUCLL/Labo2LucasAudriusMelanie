package domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Player extends Observable {
	private int score;
	private boolean turn;
	private List<Integer> rolled;
	
	public Player() {
		this.score = 0;
		this.rolled = new ArrayList<>();
		this.turn = false;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int score) {
		this.score+=score;
	}
	
	public List<Integer> getRolled() {
		return this.rolled;
	}
	
	public boolean getTurn() {
		return turn;
	}
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	protected void roll() {
		
		int roll1 = ((int) Math.floor(Math.random()*6)+1);
		int roll2 = ((int) Math.floor(Math.random()*6)+1);
		
		int score = roll1+roll2;
		if (roll1 == roll2) score=score*2;
		
		if (!this.rolled.isEmpty() && this.rolled.get(0)+this.rolled.get(1) == roll1+roll2) score+=5;
		
		this.rolled = new ArrayList<>();
		
		this.rolled.add(roll1);
		this.rolled.add(roll2);
		
		this.addScore(score);
	}
}
