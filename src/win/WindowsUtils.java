/**
 * 
 */
package win;

import java.io.IOException;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class WindowsUtils {
    public static final String TAG = "WindowsUtils";
    
    private static final String COMMON_DATA_DIR		= System.getenv("allusersprofile");
    private static final String COMMON_PROG_FILES	= System.getenv("commonprogramfiles");
    private static final String COMMON_X86PROG_FILES 	= System.getenv("commonprogramfiles(x86)");
    private static final String PROG_FILES 		= System.getenv("programfiles");
    private static final String X86PROG_FILES 		= System.getenv("programfiles(x86)");
    private static final String APP_DATA 		= System.getenv("appdata");
    private static final String HOME_DRIVE 		= System.getenv("homedrive");
    private static final String HOME_PATH 		= System.getenv("homepath");
    private static final String LOCAL_APP_DATA 		= System.getenv("localappdata");
    private static final String TEMP_PATH 		= System.getenv("temp");
    
    private static final String LOGON_SERVER 		= System.getenv("logonserver");
    private static final String USER_DOMAIN 		= System.getenv("userdomain");
    private static final String USER_NAME 		= System.getenv("username");
    private static final String USER_DIR 		= System.getenv("userprofile");
    private static final String COMP_NAME 		= System.getenv("computername");
    
    public static void main(String[] args) throws IOException {
	
	
    }
    
    
    /**
     * @return the commDataDir
     */
    public static String getCommDataDir() {
        return COMMON_DATA_DIR;
    }
    /**
     * @return the commProgFiles
     */
    public static String getCommProgFiles() {
        return COMMON_PROG_FILES;
    }
    /**
     * @return the commX86progFiles
     */
    public static String getCommX86progFiles() {
        return COMMON_X86PROG_FILES;
    }
    /**
     * @return the progFiles
     */
    public static String getProgFiles() {
        return PROG_FILES;
    }
    /**
     * @return the x86progFiles
     */
    public static String getX86progFiles() {
        return X86PROG_FILES;
    }
    /**
     * @return the compName
     */
    public static String getCompName() {
        return COMP_NAME;
    }
    /**
     * @return the appData
     */
    public static String getAppData() {
        return APP_DATA;
    }
    /**
     * @return the homeDrive
     */
    public static String getHomeDrive() {
        return HOME_DRIVE;
    }
    /**
     * @return the homePath
     */
    public static String getHomePath() {
        return HOME_PATH;
    }
    /**
     * @return the localAppData
     */
    public static String getLocalAppData() {
        return LOCAL_APP_DATA;
    }
    /**
     * @return the tempPath
     */
    public static String getTempPath() {
        return TEMP_PATH;
    }
    /**
     * @return the logonServer
     */
    public static String getLogonServer() {
        return LOGON_SERVER;
    }
    /**
     * @return the userDomain
     */
    public static String getUserDomain() {
        return USER_DOMAIN;
    }
    /**
     * @return the userName
     */
    public static String getUserName() {
        return USER_NAME;
    }
    /**
     * @return the userDir
     */
    public static String getUserDir() {
        return USER_DIR;
    }
    
}
