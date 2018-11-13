package domain.strategys;

import domain.DecoderStrategy;

public class testCode implements DecoderStrategy {
	@Override
	public String encrypt(String s) {
		return s+"tt";
	}

	@Override
	public String decrypt(String s) {
		return s.substring(0, s.length()-2);
	}
}
