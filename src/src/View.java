import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * View interface.
 *
 * @author Kyle Hoefker
 */
public interface View extends ActionListener {
	
    void registerObserver(Controller c);
    
    void UpdateDayDisplay(int key, Map<Integer, List<String>> events);
    
    void UpdateMonthDisplay(int month, int year);
    
    void UpdateGridAllowed(int startDay, int numDays);
    
    void UpdateDeleteEventAllowed(int key, Map<Integer, List<String>> events);

}
