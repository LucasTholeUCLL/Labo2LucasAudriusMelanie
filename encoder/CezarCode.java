
package encoder;


 class CezarCode implements Encoder, Decoder {
     
	 public  String encrypt(String text, int s) 
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
                char ch = (char)(((int)text.charAt(i) + s));
                     while(ch > 90) 
                       {
                           ch -=26;
                       }              
                result = result + ch; 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) +  s )); 
                       while(ch > 122) 
                       {
                           ch -=26;
                       }
                result = result+ ch; 
            } 
        } 
        return result; 
    } 
     public String decrypt(String text, int s) 
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
                char ch = (char)(((int)text.charAt(i) - s));
                     while(ch < 65) 
                       {
                           ch +=26;
                       }              
                result = result + ch; 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) -  s )); 
                       while(ch < 97) 
                       {
                           ch +=26;
                       }
                result = result+ ch; 
            } 
        } 
        return result; 
    }
	@Override
	public String reverse(String text) {
		// TODO Auto-generated method stub
		return null;
	} 
     
  
}
