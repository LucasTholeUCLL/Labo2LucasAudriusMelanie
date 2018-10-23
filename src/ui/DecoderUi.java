package ui;

import javax.swing.JOptionPane;

import domain.Decoder;

public class DecoderUi {
	private Decoder decoder;
	
	public DecoderUi() {
		this.decoder = null;
	}
	
	public void start() {
		String[] choices = new String[] {"Caesar", "Mirroring"};
		JOptionPane.showInputDialog(null, "Choose decoding strategy", "Decoder", JOptionPane.QUESTION_MESSAGE, null, choices, "Choose strategy");
	}
}
