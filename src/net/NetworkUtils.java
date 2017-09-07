/**
 * 
 */
package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class NetworkUtils {
    public static final String TAG = "NetworkUtils";
    
    private static String computerName;
    private static String subDomain;
    private static String domain;
    private static String fullDomain;
    private static String ipAddress;
    private static String ipv4;
    private static String logonServer;
    
    public static void getNetworkInfo() {
	computerName = System.getenv("computername");
	subDomain = System.getenv("userdomain").toLowerCase();
	try {
	    ipAddress = InetAddress.getLocalHost().getHostAddress();
	    ipv4 = ipAddress.substring(ipAddress.lastIndexOf('.') + 1);
	    domain = InetAddress.getLocalHost().getCanonicalHostName();
	    domain = domain.substring(domain.indexOf('.', domain.indexOf(subDomain)) + 1);
	    fullDomain = InetAddress.getLocalHost().getCanonicalHostName();
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	    ipAddress = "";
	    fullDomain = computerName + "." + subDomain + ".";
	}
	logonServer = System.getenv("logonserver");
    }
    
    /**
     * @return the computerName
     */
    public static String getComputerName() {
        return computerName;
    }

    /**
     * @return the subDomain
     */
    public static String getSubDomain() {
        return subDomain;
    }

    /**
     * @return the domain
     */
    public static String getDomain() {
        return domain;
    }

    /**
     * @return the fullDomain
     */
    public static String getFullDomain() {
        return fullDomain;
    }

    /**
     * @return the ipAddress
     */
    public static String getIpAddress() {
        return ipAddress;
    }

    /**
     * @return the ipv4
     */
    public static String getIpv4() {
        return ipv4;
    }

    /**
     * @return the logonServer
     */
    public static String getLogonServer() {
        return logonServer;
    }

   /* public static void main(String[] args) {
	getNetworkInfo();
	System.out.println(computerName);
	System.out.println(subDomain);
	System.out.println(domain);
	System.out.println(ipAddress);
	System.out.println(ipv4);
	System.out.println(logonServer);
	System.out.println(fullDomain);
    }*/
}
