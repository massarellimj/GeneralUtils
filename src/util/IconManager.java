/**
 * 
 */
package util;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class IconManager {
    public static final String TAG = "IconManager";
    
    private static volatile IconManager INSTANCE;
    
    public static IconManager instance() {
	if (INSTANCE == null) {
	    synchronized(IconManager.class) {
		if (INSTANCE == null) INSTANCE = new IconManager();
	    }
	}
	return INSTANCE;
    }
}
