import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * Controller class
 *
 * @author Kyle Hoefker
 */
public final class Controller1 implements Controller {

    private final Model model;

    private final View view;

    private static void updateViewToMatchModel(Model model,
            View view) {
        /*
         * Update view to reflect changes in model
         */
    	int key = model.month() * 1000000 + model.selectedDay() * 10000 + model.year();
    	
    	view.UpdateDayDisplay(key, model.events());
        
        view.UpdateMonthDisplay(model.month(), model.year());
        
        view.UpdateGridAllowed(model.startDay(), model.numDays());
        
        view.UpdateDeleteEventAllowed(key, model.events());

    }

    public Controller1(Model model, View view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }
    
    @Override
    public void processBack() {
    	switch (model.month()) {
    		case 0: {
    			model.setYear(model.year() - 1);
    			model.setMonth(11);
    			model.setNumDays(31);
    			model.setStartDay((model.startDay() - model.numDays() + 70) % 7);
    			break;
    		}
    		
    		case 1, 3, 5, 7, 8, 10: {
    			model.setMonth(model.month() - 1);
    			model.setNumDays(31);
    			model.setStartDay((model.startDay() - model.numDays() + 70) % 7);
    			break;
    		}
    		
    		case 2: {
    			model.setMonth(model.month() - 1);
    			model.setNumDays(model.leapYear() ? 29 : 28);
    			model.setStartDay((model.startDay() - model.numDays() + 70) % 7);
    			break;
    		}
    		
    		case 4, 6, 9, 11: {
    			model.setMonth(model.month() - 1);
    			model.setNumDays(30);
    			model.setStartDay((model.startDay() - model.numDays() + 70) % 7);
    			break;
    		}
    			
    		default: {
    			System.err.println("Error in proccessBack switch statement");
    		}
    	}
    	updateViewToMatchModel(model, view);
    }
	
    @Override
	public void processForward() {
    	switch (model.month()) {
			case 11: {
				model.setYear(model.year() + 1);
				model.setMonth(0);
				model.setStartDay((model.startDay() + model.numDays()) % 7);
				model.setNumDays(31);
				break;
			}
			
			case 0: {
				model.setMonth(model.month() + 1);
				model.setStartDay((model.startDay() + model.numDays()) % 7);
				model.setNumDays(model.leapYear() ? 29 : 28);
				break;
			}
			
			case 1, 3, 5, 6, 8, 10: {
				model.setMonth(model.month() + 1);
				model.setStartDay((model.startDay() + model.numDays()) % 7);
				model.setNumDays(31);
				break;
			}
			
			case 2, 4, 7, 9: {
				model.setMonth(model.month() + 1);
				model.setStartDay((model.startDay() + model.numDays()) % 7);
				model.setNumDays(30);
				break;
			}
				
			default: {
				System.err.println("Error in proccessForward switch statement");
			}
		}
		updateViewToMatchModel(model, view);
    	
    }
	
    @Override
	public void processAdd() {
    	Map<Integer, List<String>> events = model.events();
    	int key = model.month() * 1000000 + model.selectedDay() * 10000 + model.year();
    	
    	String newEvent = JOptionPane.showInputDialog("Add an event for " + (model.month() + 1) + "/" + (model.selectedDay() + 1) + "/" + model.year());
    	if (events.containsKey(key)) {
    		events.get(key).add(newEvent);
    	} else {
    		events.put(key, new ArrayList<String>());
    		events.get(key).add(newEvent);
    	}
    	
    	updateViewToMatchModel(model, view);
    }
	
    @Override
	public void processDelete() {
    	Map<Integer, List<String>> events = model.events();
    	int key = model.month() * 1000000 + model.selectedDay() * 10000 + model.year();
    	
    	List<String> strings = events.get(key);
    	
    	
    	List<Integer> options = new ArrayList<>();
    	
    	for (int i = 0; i < strings.size(); i++) {
    		options.add(i + 1);
    	}
    	
    	String toDelete = JOptionPane.showInputDialog("Enter the number next to the event you would like to delete");
    	
    	boolean valid = false;
    	int deleteNum = -1;
    	while (!valid) {
    		try {
    			deleteNum = Integer.parseInt(toDelete);
    			valid = true;
    		} catch (NumberFormatException nfe) {
    			toDelete = JOptionPane.showInputDialog("Please enter a valid number");
    		}
    		
    		if (deleteNum < 1 || deleteNum > strings.size()) {
    			valid = false;
    			toDelete = JOptionPane.showInputDialog("Please enter a valid number");
    		}
    	}
    	
    	strings.remove(deleteNum - 1);
    	
    	updateViewToMatchModel(model, view);
    }
    
    @Override
	public void processDaySelect(int gridSquare) {
    	model.setSelectedDay(gridSquare - model.startDay());
    	
    	updateViewToMatchModel(model, view);
    }

}
