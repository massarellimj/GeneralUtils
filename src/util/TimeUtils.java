/**
 * 
 */
package util;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class TimeUtils {
    public static final String TAG = "TimeUtils";
    
    public static long getTime() {
	return System.currentTimeMillis();
    }
    
    public static long getSteppedMonotonousTime() {
	return System.nanoTime();
    }
    
    public static String getTime(boolean seconds, boolean zone) {
	StringBuilder sb = new StringBuilder();
	Calendar c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR);
	if (hour == 0) hour = 12;
	sb.append(hour + ":");
	int minute = c.get(Calendar.MINUTE);
	sb.append(minute);
	if (seconds) {
	    sb.append(':');
	    String second = (String.valueOf(c.get(Calendar.SECOND)).length() == 2 ? String.valueOf(c.get(Calendar.SECOND)) : "0" + String.valueOf(c.get(Calendar.SECOND)));
	    sb.append(second);
	}
	String day = (c.get(Calendar.AM_PM) == 0) ? " AM" : " PM";
	sb.append(day);
	if (zone) {
	    sb.append(" " + c.getTimeZone().getDisplayName(false, TimeZone.SHORT));
	}
	return sb.toString();
    }
    

    public static String getFormattedTime(long seconds) {
	long days = (long) Math.floor(seconds / 60 / 60 / 24);
	long hours = (long)Math.floor(seconds / 60 / 60) - days*24;
	long minutes = (long) Math.floor(seconds / 60) - hours * 60;
	
	return days + ":" + hours + ":" + minutes;
    }
    
    
    public static void main(String[] args) {
	System.out.println(60 & 13);
    }
}
