package encoder;
import encoder.CezarCode;


public class DecoderMain {

    public static void main(String[] args) {
        String string= new String();
        string = "this is very secret THIS IS VERY SECRET";
        
        String newString = new String();
        int shift = 18;
        
        String string1= new String();
        String string2= new String();
        
        CezarCode cez = new CezarCode();
       BackCode bac= new BackCode();
        newString = cez.encrypt(string,shift);
        System.out.println("String : "+ string);
        System.out.println("Shift : "+ shift);
        System.out.println(" encoded string : "+ newString);
        string1= cez.decrypt(newString,shift);
        System.out.println(" decoded string : "+ string1);
        
        string2= bac.reverse(string);
        
         System.out.println("  reversed string : "+ string2);
         
    }
    
}
