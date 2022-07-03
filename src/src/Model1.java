import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model class.
 *
 * @author Kyle Hoefker
 */
public final class Model1 implements Model {

	int day, month, startDay, numDays, year;
	Map<Integer, List<String>> events;
	
	
    public Model1() {
    	this.day = 0;
    	this.month = 0;
    	this.startDay = 6;
    	this.numDays = 31;
    	this.year = 2022;
    	events = new HashMap<>();
    }
    
    @Override
    public Map<Integer, List<String>> events() {
    	return this.events;
    }
    
    @Override
    public int selectedDay() {
    	return this.day;
    }
	
    @Override
	public int month() {
		return this.month;
	}
	
    @Override
	public int startDay() {
		return this.startDay;
	}
	
    @Override
	public int numDays() {
		return this.numDays;
	}
	
    @Override
	public int year() {
		return this.year;
	}
    
    @Override
    public boolean leapYear() {
    	return this.year % 4 == 0;
    }
    
    @Override
    public void setSelectedDay(int day) {
    	this.day = day;
    }
	
    @Override
	public void setMonth(int month) {
		this.month = month;
	}
	
    @Override
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	
    @Override
	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}
	
    @Override
	public void setYear(int year) {
		this.year = year;
	}
    
}
