package ui;

import java.lang.reflect.Array;

import javax.swing.JOptionPane;

import domain.Decoder;

public class DecoderUi {
	private Decoder decoder;
	
	public DecoderUi() {
		decoder = null;
	}
	
	public void start() {
		Array[] choices = new Array[0];
		JOptionPane.showInputDialog(null, "Choose decoding strategy", "Decoder", choices);
	}
}
