package domain;

import java.util.ArrayList;
import java.util.List;

public class Decoder {
	private DecoderStrategy strategy;
	
	public Decoder(DecoderStrategy strategy) {
		setStrategy(strategy);
	}
	
	public void setStrategy(DecoderStrategy strategy) {
		if (strategy != null) this.strategy = strategy;
	}
	
	public DecoderStrategy getStrategy() {
		return this.strategy;
	}
	
	public String decode(String text) {
		return this.strategy.decrypt(text);
	}
	
	public String encode(String text) {
		return this.strategy.encrypt(text);
	}
	
	public List<String> getDecoderList() {
		List<String> list = new ArrayList<>();
		for (DecoderStrategyType s : DecoderStrategyType.values()) {
			list.add(s.toString());
		}
		return list;
	}
}
