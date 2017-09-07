/**
 * 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class SQLiteDb {
    public static final String TAG = "SQLiteDb";
    
    private static final String FILENAME = "anelace_local.db";
    private static String driver = "";
    private static String url = "jdbc:sqlite:";
    private static int timeout = 30;
    private static Connection con = null;
    private static Statement s = null;
    
    private static final Logger logger = Logger.getLogger(SQLiteDb.class.getName());
    
    public SQLiteDb() {
	
    }
    
    public SQLiteDb(String driver, String url) throws SQLException {
	init(driver, url);
    }

    /**
     * @return the filename
     */
    public static String getFilename() {
	return FILENAME;
    }

    /**
     * @param driver2
     * @param url2
     */
    public final void init(String driver, String url) throws SQLException {
	this.driver = driver;
	this.url = url;
	try {
	    Class.forName(driver);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	con = DriverManager.getConnection(url);
	this.s = con.createStatement();
	this.s.setQueryTimeout(timeout);
    }
    
    
    
    public void closeConnection() {
	try {
	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
