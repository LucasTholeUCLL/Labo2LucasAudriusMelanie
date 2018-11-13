package view;

//import domain.Decoder;
import domain.DecoderFacade;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class DecoderMenu {
	private FlowPane root;
	private Button setEncodeButton;
	private Button setDecodeButton;
	
	public DecoderMenu(Stage primaryStage) {

		//Decoder decoder = new Decoder(null);
		DecoderFacade decoder = new DecoderFacade();
		
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
		Shift.setText("0");
		Shift.setMaxWidth(50);
		TextArea outputField = new TextArea();
		outputField.setMaxHeight(100);
		outputField.setMaxWidth(250);
		
		setEncodeButton = new Button("Encode");
		setDecodeButton = new Button("Decode");
		
		disableButtons(true);
		
		//ObservableList<String> choices = FXCollections.observableArrayList("Cezar", "Backcode", "Random");
		ObservableList<String> choices = FXCollections.observableArrayList(decoder.getDecoderList());
		
		ChoiceBox<String> cb = new ChoiceBox<String>(choices);
		
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (!inputField.getText().isEmpty()) {
					disableButtons(false);
				}
				decoder.setStrategy((int)newValue);
			}
		});
		
		Shift.textProperty().addListener((observable, oldValue, newValue) -> {
			if (decoder.strategyIsCezar()) {
				try {
					decoder.setShift(newValue);
					if (!inputField.getText().trim().isEmpty()) {
						disableButtons(false);
					}
				} catch (IllegalArgumentException e) {
					disableButtons(true);
				}
			}
		});
		
		inputField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if (!newValue.trim().isEmpty() && decoder.hasStrategy()) {
		    	if (decoder.strategyIsCezar()) {
					if (!Shift.getText().trim().isEmpty()) {
						disableButtons(false);
					}
				} else {
					disableButtons(false);
				}
		    } else {
		    	disableButtons(true);
		    }
		});
		
		setEncodeButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
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
	
	private void disableButtons(boolean b) {
		setDecodeButton.setDisable(b);
		setEncodeButton.setDisable(b);
	}
}
