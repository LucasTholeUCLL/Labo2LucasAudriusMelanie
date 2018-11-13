package domain;

import java.util.List;

import domain.strategys.CezarCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DecoderFacade {
	private Decoder decoder;
	
	public DecoderFacade() {
		decoder = new Decoder(null);
	}
	
	public List<String> getDecoderList() {
		return decoder.getDecoderList();
	}
	
	public void setStrategy(int newStrategy) {
		ObservableList<String> choices = FXCollections.observableArrayList(decoder.getDecoderList());	
		
		DecoderStrategyType type = DecoderStrategyType.valueOf(choices.get(newStrategy).toUpperCase());
		DecoderStrategy strategy = DecoderStrategyFactory.createDecoderStrategy(type.getKlasseNaam());
		
		decoder.setStrategy(strategy);
	}
	
	public boolean strategyIsCezar() {
		return (decoder.getStrategy() instanceof CezarCode);
	}
	
	public void setShift(String shift) {
		try {
    		Integer.parseInt(shift);
    		CezarCode cezarC = (CezarCode) decoder.getStrategy();
			cezarC.setShift(Integer.parseInt(shift));
			decoder.setStrategy(cezarC);
    	} catch (Exception e) {
    		throw new IllegalArgumentException();
    	}
	}
	
	public boolean hasStrategy() {
		if (this.decoder.getStrategy() == null) return false;
		else return true;
	}
	
	public String encode(String s) {
		return decoder.encode(s);
	}
	
	public String decode(String s) {
		return decoder.decode(s);
	}
}
