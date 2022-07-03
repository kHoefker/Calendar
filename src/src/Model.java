import java.util.List;
import java.util.Map;

/**
 * Model interface.
 * 
 * There are two parts to this calender, a panel to show 
 *
 * @author Kyle Hoefker
 */
public interface Model {
	
	Map<Integer, List<String>> events();
	
	int selectedDay();
	
	void setSelectedDay(int day);
	
	int month();
	
	void setMonth(int month);
	
	int startDay();
	
	void setStartDay(int startDay);
	
	int numDays();
	
	void setNumDays(int numDays);
	
	int year();
	
	void setYear(int year);
	
	boolean leapYear();
	
}
