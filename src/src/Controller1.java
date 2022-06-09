/**
 * Controller class. e
 *
 * @author Kyle Hoefker
 */
public final class Controller1 implements Controller {

    /**
     * Model object.
     */
    private final Model model;

    /**
     * View object.
     */
    private final View view;

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(Model model,
            View view) {
        /*
         * Get model info
         */
        int top = model.top();
        int bottom = model.bottom();
        /*
         * Update view to reflect changes in model
         */
        view.updateTopDisplay(top);
        view.updateBottomDisplay(bottom);
        view.updateDivideAllowed(bottom != 0);
        view.updatePowerAllowed(bottom <= Integer.MAX_VALUE);
        view.updateRootAllowed(bottom >= 2 && bottom <= Integer.MAX_VALUE);
        view.updateSubtractAllowed(bottom <= top);

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public Controller1(Model model, View view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom = 0;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        int top = this.model.top();
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        int temp = top;
        top = bottom;
        bottom = temp;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        int top = this.model.top();
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top = bottom;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        int top = this.model.top();
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top += bottom;
        bottom = top;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSubtractEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        int top = this.model.top();
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top -= bottom;
        bottom = top;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processMultiplyEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        int top = this.model.top();
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top *= bottom;
        bottom = top;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processDivideEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        int top = this.model.top();
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        int temp = top % bottom;
        top /= bottom;
        bottom = top;
        top = temp;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processPowerEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        int top = this.model.top();
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        int temp = top;
        for (int i = 0; i < bottom; i++) {
        	top *= temp;
        }
        bottom = top;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processRootEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        int top = this.model.top();
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        int temp = top;
        for (int i = 0; i < bottom; i++) {
        	top /= temp;
        }
        bottom = top;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddNewDigitEvent(int digit) {
        /*
         * Get alias to bottom from model
         */
        int bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom = bottom * 10 + digit;
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

}
