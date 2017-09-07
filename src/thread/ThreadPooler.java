/**
 * 
 */
package thread;

import java.util.HashMap;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class ThreadPooler {
    public static final String TAG = "ThreadPooler";
    
    private static HashMap<String, Thread> pool;
    
    public ThreadPooler() {
	pool = new HashMap<String, Thread>();
	pool.put("default", Thread.currentThread());
    }
    
    public static int getPoolSize() {
	return pool.size();
    }
    
    public static int getAlivePoolSize() {
	int count = 0;
	for (Thread t : pool.values()) {
	    if (t.isAlive()) {
		count++;
	    }
	}
	return count;
    }
    
    public static void killThread(String key) {
	if (pool.get(key) != null && pool.get(key).isAlive()) {
	    pool.get(key).interrupt();
	}
    }
    
    
    
}
