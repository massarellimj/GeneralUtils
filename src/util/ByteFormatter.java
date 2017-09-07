/**
 * 
 */
package util;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class ByteFormatter {
    public static final String TAG = "ByteFormatter";
    
    static final char[] HEX_DIGITS = {
	    			'0', '1', '2', '3',
	    			'4', '5', '6', '7',
	    			'8', '9', 'A', 'B',
	    			'C', 'D', 'E', 'F' };
    
    public static String encodeString(byte[] bytes) {
	return nicePrint(bytes, true);
    }
    
    public static String nicePrint(byte[] data, boolean tight) {
	return nicePrint(data, tight, 1024);
    }
    
    public static String nicePrint(byte[] data, boolean tight, int maxLength) {
	if (data == null) return "";
	
	int dataLength = data.length;
	if (dataLength > maxLength) dataLength = maxLength;
	
	int size = dataLength * 2;
	if (!tight) size += (dataLength - 1) / 4;
	
	char[] out = new char[size];
	
	try {
	    int pos = 0;
	    for (int i = 0; i < dataLength; i++) {
		if ((!tight) && (i % 4 == 0) && i > 0) {
		    out[pos++] = ' ';
		}
		out[pos++] = HEX_DIGITS[(byte) ((data[i] >> 4) & 0xF)];
		out[pos++] = HEX_DIGITS[(byte) (data[i] & 0xF)];
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	try {
	    return new String(out) + (data.length > maxLength ? "...":"");
	} catch (Exception e) {
	    
	}
	return "";
    }
}
