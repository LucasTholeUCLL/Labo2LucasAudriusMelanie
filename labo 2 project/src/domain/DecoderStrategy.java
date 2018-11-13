package domain;

public interface DecoderStrategy {
	String encrypt(String s);
	String decrypt(String s);
}
