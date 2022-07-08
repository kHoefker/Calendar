/**
 * Controller interface
 *
 * @author Kyle Hoefker
 */
public interface Controller {
	/*
	 * Go to previous month
	 */
	void processBack();
	
	/*
	 * Go to next month
	 */
	void processForward();
	
	/*
	 * Display events of selected day
	 */
	void processDaySelect(int gridSquare);
	
	/*
	 * Add an event to selected day
	 */
	void processAdd();
	
	/*
	 * Delete an event from selected day
	 */
	void processDelete();
}
