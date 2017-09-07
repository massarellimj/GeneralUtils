/**
 * 
 */
package window;

import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class WindowSize {
    public static final String TAG = "WindowSize";
    
    private static int width;
    private static int height;
    private static int x;
    private static int y;
    private static int monitor;
    
    public static void captureWindowSize(Container c) {
	width = c.getWidth();
	height = c.getHeight();
    }
    
    public static void captureWindowLocation(Container c) {
	x = c.getLocation().x;
	y = c.getLocation().y;
    }
    
    public static void captureMonitor(Container c) {
	GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	List<GraphicsDevice> list = new ArrayList<GraphicsDevice>();
	for (GraphicsDevice d : devices) {
	    list.add(d);
	}
	monitor = list.indexOf(c.getGraphicsConfiguration().getDevice());
    }
    
    public static void saveWindowSize() {
	
    }
    
    public static void saveWindowLocation() {
	
    }
    
    public static void saveMonitor() {
	
    }
    
    
}
