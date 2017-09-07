/**
 * 
 */
package crypt;

import static java.lang.Math.ceil;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class HexUtils {
    public static final String TAG = "HexUtils";    
    
    
    public static String hex(String string) {
	StringBuilder sb = new StringBuilder();
	char[] array = string.toCharArray();
	for (char c : array) {
	    //System.out.println(String.format("%04x", (int) c));
	    sb.append(String.format("%02x", (int) c));
	}
	return sb.toString();
    }
    
    public static String unhex(String string) {
	StringBuilder b = new StringBuilder();
	int length = string.length();
	for (int i = 0; i < length - 1; i+=2) {
	    String out = string.substring(i, (i + 2));
	    b.append((char) Integer.parseInt(out, 16));
	}
	return b.toString();
    }
    
    public static String unhex(int number) {
	int length = String.valueOf(number).length();
	boolean zeroFill = length % 2 != 0;
	
	int sets = (int) ceil(length / 2);
	
	
	return "EVEN";
    }
    
    public static void main(String[] args) {
	System.out.println(hex("massarelli"));
    }
}
