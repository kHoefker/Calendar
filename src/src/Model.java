import java.util.List;
import java.util.Map;

/**
 * Model interface
 * 
 * Getter and setter methods for all information concerning a calendar and map
 * to store events of each day
 *
 * @author Kyle Hoefker
 */
public interface Model {
	
	/*
	 * Maps a date to a list of events
	 */
	Map<Integer, List<String>> events();
	
	/*
	 * Returns the day last selected by the user
	 */
	int selectedDay();
	
	/*
	 * setter
	 */
	void setSelectedDay(int day);
	
	/*
	 * Returns current month
	 */
	int month();
	
	/*
	 * setter
	 */
	void setMonth(int month);
	
	/*
	 * Returns an index 0 - 6 representing which day of the week the month 
	 * starts on
	 */
	int startDay();
	
	/*
	 * setter
	 */
	void setStartDay(int startDay);
	
	/*
	 * Returns the number of days in the month
	 */
	int numDays();
	
	/*
	 * setter
	 */
	void setNumDays(int numDays);
	
	/*
	 * Returns current year
	 */
	int year();
	
	/*
	 * setter
	 */
	void setYear(int year);
	
	/*
	 * Returns true if current year is a leap year
	 */
	boolean leapYear();
	
}
