package domain.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

public class playerDisplay implements Display, Observer {
	private int playerNr, score;
	private List<Player> players; 
	private List<Integer> rolled;
	private Player player;
	private GameData game;
	private boolean scoreChanged = false;
	
	private Stage stage = new Stage();
	private Scene playerScene;
	private Label diceLabel; 
	private Button playButton; 
	private Label messageLabel; 
	
	public playerDisplay(Observable observable, int player) {
		observable.addObserver(this);
		this.game = (GameData) observable;
		this.playerNr = player;
		
		diceLabel = new Label("turn 1: ");
		playButton = new Button("Throw dice");
		playButton.setDisable(true);
		messageLabel = new Label("Game has not started");
		layoutComponents();
		stage.setScene(playerScene);
		stage.setTitle("Speler "+player);
		stage.setResizable(false);		
		stage.setX(100+(player-1) * 350);
		stage.setY(200);
		stage.show();
		
		playButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        game.roll(player);
		        playButton.setDisable(true);
		    }
		});
	}
	
	public void changeButton(boolean bool) {
		playButton.setDisable(bool);
	}
	
	public void update(Observable observable, Object arg) {
		if (arg.toString().equals("roll")) {
			if (observable instanceof GameData) {
				GameData game = (GameData)observable;
				//update variables
					this.game = game;
					this.players = game.getPlayers();
					this.player = players.get(playerNr-1);
					if (score !=  player.getScore()) scoreChanged = true;
					else scoreChanged = false;
					this.score = player.getScore();
					this.rolled = player.getRolled();
					if (player.getTurn()) changeButton(false);
					display();
				//
				}
		} else {
			diceLabel.setText("turn" + arg.toString() + ": ");
		}
	}
	
	public void display() {
		if (scoreChanged) this.diceLabel.setText(diceLabel.getText() + rolled.get(0) + " and " + rolled.get(1) + " - score: " + score);
		Player player = null;
		for (Player p : players) {
			if (p.getTurn()) {
				player=p;
			}
		}
		this.messageLabel.setText("Player " + (players.indexOf(player)+1) + " rolled " + player.getRolled().get(0) + " and " + player.getRolled().get(1) + " - score: " + player.getScore());
	}
	
	private void layoutComponents() {
		VBox root = new VBox(10);
		playerScene = new Scene(root,250,100);
		root.getChildren().add(playButton);
		root.getChildren().add(diceLabel);
		root.getChildren().add(messageLabel);			
	}
}
