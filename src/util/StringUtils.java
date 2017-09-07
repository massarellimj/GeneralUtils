/**
 * 
 */
package util;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class StringUtils {
    public static final String TAG = "StringUtils";
    
    
    public static String formatUUID(String res) {
	return (res.substring(0, 8) + "-" + res.substring(8, 12) + 
		"-" + res.substring(12, 16) + "-" + res.substring(16, 20) + 
		"-" + res.substring(20));
    }
    
    public static String removeSpecials(String string) {
	StringBuilder sb = new StringBuilder();
	for (char c : string.toCharArray()) {
	    if (Character.isAlphabetic(c) || Character.isDigit(c)) {
		sb.append(c);
	    }
	}
	return sb.toString();
    }
    
    
    public static void main(String[] args) {
	System.out.println(removeSpecials("hi-my_name!is0"));
    }
}
