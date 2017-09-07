/**
 * 
 */
package crypt;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import util.ByteFormatter;
import util.StringUtils;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class UUIDUtils {
    public static final String TAG = "UUIDUtils";
    
    public static long curr = 190090243;
    
    public static synchronized String generateUUID() {
	byte[] bytes = new byte[16];
	try {
	    SecureRandom.getInstanceStrong().nextBytes(bytes);
	    String res = ByteFormatter.encodeString(bytes).toLowerCase();
	    return StringUtils.formatUUID(res);
	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public static synchronized String generateShortUUID() {
	long l = (1 & 255) << 56 + (47227 << 24);
	long s = 858868736;
	return Long.toString(s - l);
    }
    
}
