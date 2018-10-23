package app;

import domain.BackCode;
import domain.CezarCode;
import domain.Decoder;
import domain.DecoderStrategy;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DecoderApp extends Application {
	private FlowPane root;
	
	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		Decoder decoder = new Decoder(null);
		
		DecoderStrategy cezar = new CezarCode();
		DecoderStrategy back = new BackCode();
		
		this.root = new FlowPane();
		root.setAlignment(Pos.BASELINE_CENTER);
		root.setVgap(10);
		root.setHgap(30);
		primaryStage.setTitle("Decoder");
		Scene mainScene = new Scene(root, 300, 350);
		primaryStage.setScene(mainScene);
		Label label1 = new Label("Input:");
		Label labelShift = new Label("Shift: ");
		Label label2 = new Label("Output: ");
		TextArea inputField = new TextArea();
		inputField.setMaxHeight(100);
		inputField.setMaxWidth(250);
		TextField Shift = new TextField();
		Shift.setMaxWidth(50);
		TextArea outputField = new TextArea();
		outputField.setMaxHeight(100);
		outputField.setMaxWidth(250);
	
		
		@SuppressWarnings("rawtypes")
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
			    "Cezar", "Backcode")
			);
		
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() == 1) decoder.setStrategy(back);
				else {
					CezarCode cezarC = (CezarCode) cezar;
					cezarC.setShift(Integer.parseInt(Shift.getText()));
					decoder.setStrategy(cezar);
				}
			}
		});
		
		Button setEncodeButton = new Button("Encode");
		Button setDecodeButton = new Button("Decode");
		setEncodeButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	if (decoder.getStrategy() instanceof CezarCode) {
		    		CezarCode cezarC = (CezarCode) cezar;
					cezarC.setShift(Integer.parseInt(Shift.getText()));
					decoder.setStrategy(cezar);
		    	}
		        outputField.setText(decoder.encode(inputField.getText()));
		    }
		});
		
		setDecodeButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        outputField.setText(decoder.decode(inputField.getText()));
		    }
		});
		
		
		root.getChildren().add(label1);
		root.getChildren().add(inputField);
		root.getChildren().add(label2);
		root.getChildren().add(outputField);
		root.getChildren().add(labelShift);
		root.getChildren().add(Shift);
		root.getChildren().add(cb);
		root.getChildren().add(setEncodeButton);
		root.getChildren().add(setDecodeButton);
		primaryStage.show();
	}
}
