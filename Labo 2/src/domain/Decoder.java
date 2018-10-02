package domain;

public class Decoder {
	private DecoderStrategy strategy;
	
	public Decoder(DecoderStrategy strategy) {
		setStrategy(strategy);
	}
	
	public void setStrategy(DecoderStrategy strategy) {
		if (strategy != null) this.strategy = strategy;
	}
	
	public String decode(String text) {
		return this.strategy.decode(text);
	}
	
	public String encode(String text) {
		return this.strategy.encode(text);
	}
}
