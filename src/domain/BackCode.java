
package domain;
import java.lang.StringBuilder; 

public class BackCode implements DecoderStrategy {
    public String encrypt(String text)
    {   
        
    StringBuilder result = new StringBuilder(text).reverse();
    
    
        return result.toString();
    }
    
    public String decrypt(String text) {
    	return encrypt(text);
    }
}
