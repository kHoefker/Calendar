/**
 * Controller interface.
 *
 * @author Kyle Hoefker
 */
public interface Controller {
	void processBack();
	
	void processForward();
	
	void processDaySelect(int gridSquare);
	
	void processAdd();
	
	void processDelete();
}
