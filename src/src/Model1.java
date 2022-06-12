import src.CalendarDay;

/**
 * Model class.
 *
 * @author Kyle Hoefker
 */
public final class Model1 implements Model {

	CalendarDay day;
	int month, startDay, numDays, year;
	
    public Model1() {
    	this.day = new CalendarDay();
    	this.month = 0;
    	this.startDay = 6;
    	this.numDays = 31;
    	this.year = 2022;
    }
    
    @Override
    public CalendarDay selectedDay() {
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
}
