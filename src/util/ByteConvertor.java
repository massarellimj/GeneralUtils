/**
 * 
 */
package util;


import static java.lang.Math.floor;

import java.io.File;
/**
 * 
 *
 * @author Michael Massarelli
 */
public class ByteConvertor {
    public static final String TAG = "ByteConvertor";
    
    public static int getGbs(long bytes) {
	bytes = bytes/1000000000;
	bytes = (long) floor(bytes * 0.93);
	return (int) bytes;
    }
    
    public static int getTbs(long bytes) {
	bytes = bytes/1000000000;
	bytes = bytes/1000;
	bytes = (long) floor(bytes * 0.93);
	return (int) bytes;
    }
    
    public static int getMbs(long bytes) {
	bytes = bytes/1000000;
	bytes = (long) floor(bytes * 0.93);
	return (int) bytes;
    }
    
    public static int getKbs(long bytes) {
	bytes = bytes/1000;
	bytes = (long) floor(bytes * 0.93);
	return (int) bytes;
    }
    
    public static void main(String[] args) {
	File f = new File("M:/");
	System.out.println(getMbs(f.getFreeSpace()));
    }
}
