package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Utility class containing date/time functionality
 */
public final class DateUtils {
	
	/**
	 * Private Constructor.
	 */
	private DateUtils() {
		assert false;
	}

	/**
	 * Regular format string for dates.
	 */
	public static final String DATE_FORMAT = "MM/dd/yyyy";
	
	/**
	 * Short format string for dates.
	 */
	public static final String SHORT_DATE_FORMAT = "MM/dd/yy";
	
	/**
	 * Format string for date/time.
	 */
	public static final String DATE_TIME_FORMAT = "MM/dd/yyyy hh:mm a";
	
	/**
	 * Format string for timestamp.
	 */
	public static final String DATE_TIME_STAMP_FORMAT = "MMddyyyyhhmmss";
	
	private static SimpleDateFormat dateFormatter;
	private static SimpleDateFormat shortDateFormatter;
	private static SimpleDateFormat dateTimeFormatter;
	private static SimpleDateFormat dateTimeStampFormatter;
	
	static {
		dateFormatter = new SimpleDateFormat(DATE_FORMAT);
		shortDateFormatter = new SimpleDateFormat(SHORT_DATE_FORMAT);
		dateTimeFormatter = new SimpleDateFormat(DATE_TIME_FORMAT);
		dateTimeStampFormatter = new SimpleDateFormat(DATE_TIME_STAMP_FORMAT);
	}
	
	/**
	 * Formats a Date object as a string of the form "MM/dd/yyyy".
	 * 
	 * @param d Date to be formatted.
	 * 
	 * {@pre d != null}
	 * 
	 * {@post Returns a date string of the form "MM/dd/yyyy".}
	 */
	public static String formatDate(Date d) {
		return dateFormatter.format(d);
	}
	
	/**
	 * Formats a Date object as a string of the form "MM/dd/yy"
	 * 
	 * @param d Date to be formatted.
	 * 
	 * {@pre d != null}
	 * 
	 * {@post Returns a date string of the form "MM/dd/yy".}
	 */
	public static String formatShortDate(Date d) {
		return shortDateFormatter.format(d);
	}
	
	/**
	 * Formats a Date object as a string of the form "MMddyyyyhhmmss" for a timestamp
	 * 
	 * @param d Date to be formatted.
	 * 
	 * {@pre d != null}
	 * 
	 * {@post Returns a date string of the form "MMddyyyyhhmmss".}
	 */
	public static String formatTimeStamp(Date d) {
		return dateTimeStampFormatter.format(d);
	}
	
	/**
	 * Parses a date string of the form "MM/dd/yyyy" and converts it to a Date object
	 * 
	 * @param text String to be parsed.
	 * 
	 * @throws ParseException if text is not of the form "MM/dd/yyyy".
	 * 
	 * {@pre text contains a string of the form "MM/dd/yyyy"}
	 * 
	 * {@post Returns a Date object containing the parsed date.}
	 */
	public static Date parseDate(String text) throws ParseException {
		Date result = dateFormatter.parse(text);
		String resultText = formatDate(result);
		if (!resultText.equals(text)) {
			throw new ParseException("Invalid date", 0);
		}
		return result;
	}

	/**
	 * Formats a Date object as a string of the form "MM/dd/yyyy hh:mm a"
	 * 
	 * @param d Date object to be formatted.
	 * 
	 * {@pre d != null}
	 * 
	 * {@post Returns a string of the form "MM/dd/yyyy hh:mm a".}
	 */
	public static String formatDateTime(Date d) {
		return dateTimeFormatter.format(d);
	}
	
	/**
	 * Parses a string of the form "MM/dd/yyyy hh:mm a" and converts it to a Date object.
	 * 
	 * @param text String to be parsed.
	 * 
	 * @throws ParseException if text is not of the form "MM/dd/yyyy hh:mm a"
	 * 
	 * {@pre text contains a string of the form "MM/dd/yyyy hh:mm a"}
	 * 
	 * {@post Returns a Date object containing the parsed date/time.}
	 */
	public static Date parseDateTime(String text) throws ParseException {
		Date result = dateTimeFormatter.parse(text);
		String resultText = formatDateTime(result);
		if (!resultText.equals(text)) {
			throw new ParseException("Invalid date/time", 0);
		}
		return result;
	}
	
	/**
	 * Normalizes the time portion of a Date object to midnight.
	 * 
	 * @param date The Date object to be normalized.
	 * 
	 * {@pre date != null}
	 * 
	 * {@post The time portion of date has been set to midnight.}
	 */
	public static Date removeTimeFromDate(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		
		calendar.setTime(date);
		
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTime();
	}

	/**
	 * Returns a Date object for the current date with the time portion
	 * set to 12AM.
	 * 
	 * {@pre None}
	 * 
	 * {@post Returns a Date object for the current date with the time portion
	 * set to 12AM.}
	 */
	public static Date currentDate() {
		return removeTimeFromDate(new DateTime().toDate());
//		return new DateMidnight().toDate(); // TODO: Is this correct? - Paul
	}

	/**
	 * Returns the earliest date supported by the product.
	 * 
	 * {@pre None}
	 * 
	 * {@post Returns the earliest date supported by the product.}
	 */
	public static Date earliestDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.YEAR, 2000);		
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTime();
	}
	
	/**
	 * Returns the date that came latest out of the two dates passed
	 * 
	 * @param date1 a Date object
	 * @param date2 the other Date object
	 * 
	 * {@pre None}
	 * 
	 * {@post Returns the later date of the two passed in}
	 */
	public static Date laterDate(Date date1, Date date2){
		return date1.before(date2) ?  date2 : date1;
	}

	/**
	 * Returns the number of days since the date given
	 * @param date
	 * @return the number of days since the date given
	 */
	public static int daysSince(Date date) {
		return DateUtils.daysBetween(date, DateUtils.currentDate());
	}

	/**
	 * Returns the days between the two dates
	 * @param before
	 * @param after
	 * @return	days between
	 */
	public static int daysBetween(Date before, Date after) {
		if(after == null)
			return DateUtils.daysSince(before);
		return Days.daysBetween(new DateTime(before), new DateTime(after)).getDays();
	}

	public static Date earlierDate(Date date1, Date date2) {
		return date1.before(date2) ? date1 : date2;
	}
	
	public static long timeSinceEpoch(Date date){
		return (new DateTime(date)).toInstant().getMillis();
	}
}

