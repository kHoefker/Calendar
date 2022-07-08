import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * View interface
 *
 * @author Kyle Hoefker
 */
public interface View extends ActionListener {
	
	/*
	 * Register argument as observer
	 */
    void registerObserver(Controller c);
    
    /*
     * Change events and date shown in bottom right if needed
     */
    void UpdateDayDisplay(int key, Map<Integer, List<String>> events);
    
    /*
     * Change current month being shown if needed
     */
    void UpdateMonthDisplay(int month, int year);
    
    /*
     * Disable buttons that aren't days of the month and change numbers on 
     * buttons
     */
    void UpdateGridAllowed(int startDay, int numDays);
    
    /*
     * Disable Delete button if no events exist to delete for selected day
     */
    void UpdateDeleteEventAllowed(int key, Map<Integer, List<String>> events);

}
