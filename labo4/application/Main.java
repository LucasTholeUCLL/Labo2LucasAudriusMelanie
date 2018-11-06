package application;
	
import java.util.ArrayList;
import java.util.List;

import domain.model.GameData;
import domain.model.Player;
import domain.model.ScoreDisplay;
import domain.model.playerDisplay;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		List<Player> players = new ArrayList<>();
		players.add(new Player());
		players.add(new Player());
		players.add(new Player());
		GameData game = new GameData(players);
		ScoreDisplay sd = new ScoreDisplay(game);
		playerDisplay pd1 = new playerDisplay(game.getPlayers().get(0));
		playerDisplay pd2 = new playerDisplay(game.getPlayers().get(1));
		playerDisplay pd3 = new playerDisplay(game.getPlayers().get(2));
		
		
		
		//this code below was just for testing, you need to make it so
		//when the button in the javaFX menu is pressed, the player rolls
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				game.getPlayers().get(j).roll();
			}
			game.nextTurn();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
