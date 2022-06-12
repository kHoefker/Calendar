import src.CalendarDay;

/**
 * Controller class. e
 *
 * @author Kyle Hoefker
 */
public final class Controller1 implements Controller {

    private final Model model;

    private final View view;

    private static void updateViewToMatchModel(Model model,
            View view) {
        /*
         * Get model info
         */
    	CalendarDay day = model.selectedDay();
    	
    	int month = model.month();
    	
    	int startDay = model.startDay();
    	
    	int numDays = model.numDays();
    	
    	int year = model.year();
    	
        /*
         * Update view to reflect changes in model
         */
    	view.UpdateDayDisplay(day);
        
        view.UpdateMonthDisplay(month, year);
        
        view.UpdatePrevMonthAllowed(true);
        
        view.UpdateNextMonthAllowed(true);
        
        view.UpdateGridAllowed(startDay, numDays);
        
        view.UpdateDeleteEventAllowed(false);

    }

    public Controller1(Model model, View view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }
    
    @Override
    public void processBack() {
    	
    }
	
    @Override
	public void processForward() {
    	
    }
	
    @Override
	public void processAdd() {
    	
    }
	
    @Override
	public void processDelete() {
    	
    }
    
    @Override
	public void processDaySelect(int gridSquare) {
    	
    }

//    @Override
//    public void processClearEvent() {
//        /*
//         * Get alias to bottom from model
//         */
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        bottom = 0;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }
//
//    @Override
//    public void processSwapEvent() {
//        /*
//         * Get aliases to top and bottom from model
//         */
//        int top = this.model.top();
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        int temp = top;
//        top = bottom;
//        bottom = temp;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }
//
//    @Override
//    public void processEnterEvent() {
//        /*
//         * Get aliases to top and bottom from model
//         */
//        int top = this.model.top();
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        top = bottom;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }
//
//    @Override
//    public void processAddEvent() {
//        /*
//         * Get aliases to top and bottom from model
//         */
//        int top = this.model.top();
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        top += bottom;
//        bottom = top;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }
//
//    @Override
//    public void processSubtractEvent() {
//        /*
//         * Get aliases to top and bottom from model
//         */
//        int top = this.model.top();
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        top -= bottom;
//        bottom = top;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }
//
//    @Override
//    public void processMultiplyEvent() {
//        /*
//         * Get aliases to top and bottom from model
//         */
//        int top = this.model.top();
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        top *= bottom;
//        bottom = top;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }
//
//    @Override
//    public void processDivideEvent() {
//        /*
//         * Get aliases to top and bottom from model
//         */
//        int top = this.model.top();
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        int temp = top % bottom;
//        top /= bottom;
//        bottom = top;
//        top = temp;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }
//
//    @Override
//    public void processPowerEvent() {
//        /*
//         * Get aliases to top and bottom from model
//         */
//        int top = this.model.top();
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        int temp = top;
//        for (int i = 0; i < bottom; i++) {
//        	top *= temp;
//        }
//        bottom = top;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }
//
//    @Override
//    public void processRootEvent() {
//        /*
//         * Get aliases to top and bottom from model
//         */
//        int top = this.model.top();
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        int temp = top;
//        for (int i = 0; i < bottom; i++) {
//        	top /= temp;
//        }
//        bottom = top;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }
//
//    @Override
//    public void processAddNewDigitEvent(int digit) {
//        /*
//         * Get alias to bottom from model
//         */
//        int bottom = this.model.bottom();
//        /*
//         * Update model in response to this event
//         */
//        bottom = bottom * 10 + digit;
//        /*
//         * Update view to reflect changes in model
//         */
//        updateViewToMatchModel(this.model, this.view);
//    }

}
