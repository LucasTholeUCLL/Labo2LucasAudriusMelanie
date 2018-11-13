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
		
		game.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
