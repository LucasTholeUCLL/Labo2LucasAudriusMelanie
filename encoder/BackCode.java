package encoder;
import java.lang.StringBuilder; 

class BackCode implements Encoder,Decoder {
	@Override
	public String reverse(String text)
    {   
        
    StringBuilder result = new StringBuilder(text).reverse();
    
    
        return result.toString();
    }

	@Override
	public String decrypt(String text, int s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encrypt(String text, int s) {
		// TODO Auto-generated method stub
		return null;
	}
}
