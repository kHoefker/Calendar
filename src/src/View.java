import java.awt.event.ActionListener;

import src.CalendarDay;

/**
 * View interface.
 *
 * @author Kyle Hoefker
 */
public interface View extends ActionListener {
	
    void registerObserver(Controller c);
    
    void UpdateDayDisplay(CalendarDay day);
    
    void UpdateMonthDisplay(int month, int year);
    
    void UpdatePrevMonthAllowed(boolean allowed);
    
    void UpdateNextMonthAllowed(boolean allowed);
    
    void UpdateGridAllowed(int startDay, int numDays);
    
    void UpdateDeleteEventAllowed(boolean allowed);

}
