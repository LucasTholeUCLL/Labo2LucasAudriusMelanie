package app;


import javafx.application.Application;
import javafx.stage.Stage;
import view.DecoderMenu;

public class DecoderApp extends Application {	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		new DecoderMenu(primaryStage);
	}
}
