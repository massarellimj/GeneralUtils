/**
 * 
 */
package util;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;
import java.awt.GraphicsEnvironment;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class ScreenUtils {
    public static final String TAG = "ScreenUtils";
    
    
    public static Monitor getDefaultMonitor() {
	return new Monitor(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
    }
    
    public static int getNumberOfScreens() {
	return GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices().length;
    }
    
    public static Dimension getDefaultScreenDimension() {
	return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds().getSize();
    }
    
    public static Dimension getScreenDimension(int screen) {
	GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	GraphicsDevice gd = devices[screen];
	return gd.getDefaultConfiguration().getBounds().getSize();
    }
    
    public static boolean translucencySupportedByAll() {
	GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	for (GraphicsDevice d : devices) {
	    if (!d.isWindowTranslucencySupported(WindowTranslucency.TRANSLUCENT)) {
		return false;
	    }
	}
	return true;
    }
    
    public static Dimension getFullscreenDimension() {
	return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();
    }
    
    public static void main(String[] args) {
	
    }
    
    static class Monitor {
	private Dimension dims;
	private double refreshRate, bitDepth;
	private int number;
	private boolean defaultDevice;
	
	public Monitor(GraphicsDevice device) {
	    this.dims = device.getDefaultConfiguration().getBounds().getSize();
	    this.refreshRate = device.getDisplayMode().getRefreshRate();
	    this.bitDepth = device.getDisplayMode().getBitDepth();
	    this.defaultDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().equals(device);
	    if (defaultDevice) {
		number = 1;
	    } else {
		GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		int i = 1;
		for (GraphicsDevice d : devices) {
		    if (d.equals(device)) {
			this.number = i;
			i++;
		    }
		}
	    }
	}

	/**
	 * @return the dims
	 */
	public Dimension getDims() {
	    return dims;
	}

	/**
	 * @param dims the dims to set
	 */
	public void setDims(Dimension dims) {
	    this.dims = dims;
	}

	/**
	 * @return the refreshRate
	 */
	public double getRefreshRate() {
	    return refreshRate;
	}

	/**
	 * @param refreshRate the refreshRate to set
	 */
	public void setRefreshRate(double refreshRate) {
	    this.refreshRate = refreshRate;
	}

	/**
	 * @return the bitDepth
	 */
	public double getBitDepth() {
	    return bitDepth;
	}

	/**
	 * @param bitDepth the bitDepth to set
	 */
	public void setBitDepth(double bitDepth) {
	    this.bitDepth = bitDepth;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
	    return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
	    this.number = number;
	}

	/**
	 * @return the defaultDevice
	 */
	public boolean isDefaultDevice() {
	    return defaultDevice;
	}

	/**
	 * @param defaultDevice the defaultDevice to set
	 */
	public void setDefaultDevice(boolean defaultDevice) {
	    this.defaultDevice = defaultDevice;
	}
	
    }
}
