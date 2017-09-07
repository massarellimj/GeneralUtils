/**
 * 
 */
package io;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.filechooser.FileSystemView;

import util.ByteConvertor;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class DriveUtils {
    public static final String TAG = "DriveUtils";
    
    public static Map<String, Integer> drives = new HashMap<String, Integer>();
    
    public static void getLocalDrives() {
	File[] paths;
	FileSystemView fsv = FileSystemView.getFileSystemView();
	// returns pathnames for files and directory
	paths = File.listRoots();
	// for each pathname in pathname array
	for(File path : paths) {
	    if (fsv.getSystemTypeDescription(path).toLowerCase().contains("local")) {
		drives.put(path.getPath(), ByteConvertor.getGbs(path.getFreeSpace()));
		System.out.println("Drive Name: "+drives.keySet().toArray()[0]);
		System.out.println("Description: "+drives.entrySet().toArray()[0]);
	    }
	}
    }
    
    
    
    
    public static void main(String[] args) {
	File f = new File("C:/");
	System.out.println(f.getFreeSpace()/1000000000*0.93);
    }
}
