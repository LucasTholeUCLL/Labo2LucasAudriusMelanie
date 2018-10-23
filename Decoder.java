package domain;

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
}
