
package domain.strategys;
import java.lang.StringBuilder;

import domain.DecoderStrategy; 

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
