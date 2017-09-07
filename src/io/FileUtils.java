/**
 * 
 */
package io;

import static java.lang.Math.ceil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class FileUtils {
    public static final String TAG = "FileUtils";
    
    public static String getExtension(File file) {
	return file.getName().substring(file.getName().lastIndexOf('.') + 1);
    }
    
    public static String getFileSize(File file) {
	try {
	    long size = (long) Files.getAttribute(file.toPath(), "dos:size", LinkOption.NOFOLLOW_LINKS);
	    if (size / 1024 < 1) {
		return size + " B";
	    } else if (size / 1024 >= 1 && size / 1024000 < 1) {
		return (long)ceil(size/1024) + " KB";
	    } else if (size / 1024000 >= 1 && size / 1024000000 < 1){
		return Double.toString((double)size/1000000).substring(0, Double.toString((double)size/1000000).lastIndexOf('.') + 2) + " MB";
	    } else {
		return Double.toString((double)size/1000000000).substring(0, Double.toString((double)size/1000000000).lastIndexOf('.') + 2) + " GB";
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public static String getCreationTime(File file) {
	try {
	    BasicFileAttributeView b = Files.getFileAttributeView(file.toPath(), BasicFileAttributeView.class);
	    BasicFileAttributes ba = b.readAttributes();
	    return ba.creationTime().toString();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public static String getModifiedTime(File file) {
	try {
	    BasicFileAttributeView b = Files.getFileAttributeView(file.toPath(), BasicFileAttributeView.class);
	    BasicFileAttributes ba = b.readAttributes();
	    return ba.lastModifiedTime().toString();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    
    
    public static void main(String[] args) {
	File file = new File("h:/it/program files");
	int longest = 0;
	for (File f : file.listFiles()) {
	    if (f.getName().length() > longest) {
		longest = f.getName().length();
	    }
	}
	for (File f : file.listFiles()) {
	    StringBuilder sb = new StringBuilder();
	    if (f.isFile() && getExtension(f) != "url") {
		sb.append(f.getName());
		for (int i = f.getName().length(); i < longest + 5; i++) {
		    sb.append(' ');
		}
		sb.append(": " + getFileSize(f));
		System.out.println(sb.toString());		
	    }
	}
    }
}
