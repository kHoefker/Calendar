import src.CalendarDay;

/**
 * Model interface.
 * 
 * There are two parts to this calender, a panel to show 
 *
 * @author Kyle Hoefker
 */
public interface Model {
	
	CalendarDay selectedDay();
	
	int month();
	
	int startDay();
	
	int numDays();
	
	int year();
	
}
