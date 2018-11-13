package domain.model;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class ScoreDisplay implements Display, Observer {
	private int turn;
	private List<Player> players;
	
	private Stage stage = new Stage();
	private Scene scoreScene;
	private Label scoreLabel; 
	
	public ScoreDisplay(Observable observable) {
		observable.addObserver(this);
		
		scoreLabel = new Label();
		scoreLabel.setStyle("-fx-font-family: \"Courier new\"; -fx-font-size: 12; -fx-text-fill: darkred;");

		layoutComponents();
		stage.setScene(scoreScene);
		stage.setTitle("Overzicht scores");
		stage.setResizable(false);		
		stage.setX(100);
		stage.setY(400);
		stage.show();
	}
	
	public void update(Observable observable, Object arg) {
		if (!arg.toString().equals("roll")) {
			if (observable instanceof GameData) {
				GameData gameData = (GameData)observable;
				//update variables
				this.turn = gameData.getTurn();
				this.players = gameData.getPlayers();
				//
				display();
		}
		}
	}
	
	public void display() {
		String message = scoreLabel.getText();
		
		message+="Turn " + (turn-1) + ": ";
		
		for (Player p : players) {
			message+="p" + (players.indexOf(p)+1) + ": " + p.getScore() + " ";
		}
			
		if (turn == 5) {
			message+="\n \nGame over! The winner is: ";
			Player winner = null;
			for (Player p : players) {
				if (winner == null || winner.getScore() < p.getScore()) winner = p;
			}
			message+="\nPlayer " + (players.indexOf(winner)+1) +  " with a score of " + winner.getScore();
		} 
		
		message+="\n";
		
		//System.out.println(message);
		scoreLabel.setText(message);
	}
	
	private void layoutComponents() {
		VBox root = new VBox();
		scoreScene = new Scene(root,400,200);
		root.getChildren().add(scoreLabel);
	}
}
