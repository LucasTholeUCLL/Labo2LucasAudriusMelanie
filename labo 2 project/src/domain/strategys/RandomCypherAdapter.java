package domain.strategys;

import domain.DecoderStrategy;
import domain.RandomCypher;

public class RandomCypherAdapter implements DecoderStrategy {
	private RandomCypher strategy = new RandomCypher();
	
	public RandomCypherAdapter() {
		this.strategy = new RandomCypher();
	}
	
	public String encrypt(String s) {
		s=s.replaceAll("\\s+","");
		char[] c = strategy.encypher(s.toCharArray());
		String answer = "";
		for (int i = 0; i < c.length; i++) {
			answer+=c[i];
		}
		return answer;
	}
	
	public String decrypt(String s) {
		char[] c = strategy.decypher(s.toCharArray());
		String answer = "";
		for (int i = 0; i < c.length; i++) {
			answer+=c[i];
		}
		return answer;
	}

}
