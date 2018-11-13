
package domain.strategys;

import domain.DecoderStrategy;

public class CezarCode implements DecoderStrategy{
	private int shift = 0;
	public CezarCode() {
		
	}
	
	public void setShift(int shift) {this.shift = shift;} 
	public int getShift() {return this.shift;}
	
    public String encrypt(String text) 
    { 
        String result= new String(); 
        result = "";
        for (int i=0; i<text.length(); i++) 
        {   if (text.charAt(i)==32)
            {   char ch = 32;
                result = result+ ch;
            }
        else if (Character.isUpperCase(text.charAt(i))) 
            { 
                char ch = (char)(((int)text.charAt(i) + shift));
                     while(ch > 90) 
                       {
                           ch -=26;
                       }              
                result = result + ch; 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) +  shift )); 
                       while(ch > 122) 
                       {
                           ch -=26;
                       }
                result = result+ ch; 
            } 
        } 
        return result; 
    } 
     public String decrypt(String text) 
    { 
        String result= new String(); 
        result = "";
        for (int i=0; i<text.length(); i++) 
        {   if (text.charAt(i)==32)
            {   char ch = 32;
                result = result+ ch;
            }
        else if (Character.isUpperCase(text.charAt(i))) 
            { 
                char ch = (char)(((int)text.charAt(i) - shift));
                     while(ch < 65) 
                       {
                           ch +=26;
                       }              
                result = result + ch; 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) -  shift)); 
                       while(ch < 97) 
                       {
                           ch +=26;
                       }
                result = result+ ch; 
            } 
        } 
        return result; 
    } 
     
  
}
