/**
 * 
 */
package util;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class OSUtils {
    public static final String TAG = "OSUtils";
    
    private static final String OS_ARCH = System.getProperty("os.arch");
    private static final String OS_NAME = System.getProperty("os.name");
    private static final String OS_VER = System.getProperty("os.version");
    private static final String USER_DIR = System.getProperty("user.home");
    
    private static final int BITS = Integer.parseInt(System.getProperty("sun.arch.data.model"));
    
    static final String WIN_95 = "Windows 95";
    static final String WIN_98 = "Windows 98";
    static final String WIN_00 = "Windows 2000";
    static final String WIN_NT = "Windows NT";
    static final String WIN_XP = "Windows XP";
    static final String WIN_ME = "Windows ME";
    static final String WIN_VI = "Windows Vista";
    static final String WIN_7  = "Windows 7";
    static final String WIN_8  = "Windows 8";
    static final String WIN_10 = "Windows 10";
    
    static final String SOL_10 = "Solaris 10";
    static final String SOL_11 = "Solaris 11";
    
    static final String MAC_8  = "Mac OS 8";
    static final String MAC_9  = "Mac OS 9";
    static final String MACOSX = "Mac OS X";
    static final String OS_X   = "OS X";
    static final String MAC_OS = "macOS";
    
    private static boolean supportsTray;
    private static boolean supportsTransparency;
    private static boolean supportsTrash;
    
    private static long maxPathLength;
    
    
    
    /**
     * @return whether the os supports desktop tray
     */
    public static boolean supportsTray() {
        return supportsTray;
    }



    /**
     * @return whether the os supports transparent windows
     */
    public static boolean supportsTransparency() {
        return supportsTransparency;
    }


    /**
     * @return the os architecture
     */
    public static String getOsArch() {
        return OS_ARCH;
    }



    /**
     * @return the os name
     */
    public static String getOsName() {
        return OS_NAME;
    }



    /**
     * @return the os version
     */
    public static String getOsVer() {
        return OS_VER;
    }



    /**
     * @return the user directory
     */
    public static String getUserDir() {
        return USER_DIR;
    }



    /**
     * @return the bits
     */
    public static int getBits() {
        return BITS;
    }



    /**
     * @return whether the os supports trash
     */
    public static boolean supportsTrash() {
	return supportsTrash;
    }



    /**
     * @return the maxPathLength
     */
    public static long getMaxPathLength() {
	if (isWindows()) {
            maxPathLength = Short.MAX_VALUE;
        }
        else if (isLinux()) {
            maxPathLength = 4096 - 1;
        }
        else {
            maxPathLength = 1024 - 1;
        }
	return maxPathLength;
    }



    /**
     * @return
     */
    private static boolean isLinux() {
	return false;
    }



    /**
     * @return
     */
    private static boolean isWindows() {
	return false;
    }
    



    public static void main(String[] args) {
	System.out.println(System.getenv("userdomain"));
    }
}
