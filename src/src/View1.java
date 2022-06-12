import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import src.CalendarDay;

/**
 * View class.
 *
 * @author Kyle Hoefker
 */
public final class View1 extends JFrame implements View {

    /**
     * Controller object registered with this view to observe user-interaction
     * events.
     */
    private Controller controller;

    /**
     * State of user interaction: last event "seen".
     */
    private enum State {
        /**
         * Last event was clear, enter, another operator, or digit entry, resp.
         */
        SAW_BACK, SAW_FORWARD, SAW_DAY_SELECT, SAW_ADD, SAW_DELETE
    }

    /**
     * State variable to keep track of which event happened last; needed to
     * prepare for digit to be added to bottom operand.
     */
    private State currentState;

    /**
     * Text areas.
     */
    private final JTextArea tMonth, tDay;

    /**
     * Operator and related buttons.
     */
    private JButton bBack, bForward, bAdd, bDelete, bS, bM, bT, bW, bTh, bF, bSa;

    /**
     * Digit entry buttons.
     */
    private JButton[] bGrid;

    /**
     * Useful constants.
     */
    private static final int TEXT_AREA_HEIGHT = 5, TEXT_AREA_WIDTH = 20,
            DIGIT_BUTTONS = 10, MAIN_BUTTON_PANEL_GRID_ROWS = 4,
            MAIN_BUTTON_PANEL_GRID_COLUMNS = 4, SIDE_BUTTON_PANEL_GRID_ROWS = 3,
            SIDE_BUTTON_PANEL_GRID_COLUMNS = 1, CALC_GRID_ROWS = 3,
            CALC_GRID_COLUMNS = 1;

    /**
     * Default constructor.
     */
    public View1() {
        // Create the JFrame being extended

        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */
        super("Calendar");

        // Set up the GUI widgets --------------------------------------------

        /*
         * Set up initial state of GUI to behave like last event was "Clear";
         * currentState is not a GUI widget per se, but is needed to process
         * digit button events appropriately
         */
        this.currentState = State.SAW_DAY_SELECT;

        /*
         * Create widgets
         */
        this.tMonth = new JTextArea("January 2022", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.tDay = new JTextArea("1/1/2022\n\nList of events:\n", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.bBack = new JButton("December");
        this.bForward = new JButton("February");
        this.bAdd = new JButton("Add event");
        this.bDelete = new JButton("Delete event");
        this.bS = new JButton("S");
        this.bS.setEnabled(false);
        this.bM = new JButton("M");
        this.bM.setEnabled(false);
        this.bT = new JButton("T");
        this.bT.setEnabled(false);
        this.bW = new JButton("W");
        this.bW.setEnabled(false);
        this.bTh = new JButton("T");
        this.bTh.setEnabled(false);
        this.bF = new JButton("F");
        this.bF.setEnabled(false);
        this.bSa = new JButton("S");
        this.bSa.setEnabled(false);
        this.bGrid = new JButton[42];
        int j = 1;
        for (int i = 0; i < 42; i++) {
        	if (i < 6) {
        		this.bGrid[i] = new JButton("");
        		this.bGrid[i].setEnabled(false);
        	} else if (j > 31) {
        		this.bGrid[i] = new JButton("");
        		this.bGrid[i].setEnabled(false);
        	} else {
        		this.bGrid[i] = new JButton(Integer.toString(j));
        		j++;
        	}
        }

        // Set up the GUI widgets --------------------------------------------

        /*
         * Text areas should wrap lines, and should be read-only; they cannot be
         * edited because allowing keyboard entry would require checking whether
         * entries are digits, which we don't want to have to do
         */
        this.tMonth.setEditable(false);
        this.tMonth.setLineWrap(true);
        this.tMonth.setWrapStyleWord(true);
        this.tMonth.setEditable(false);
        this.tMonth.setLineWrap(true);
        this.tMonth.setWrapStyleWord(true);

//        /*
//         * Create scroll panes for the text areas in case number is long enough
//         * to require scrolling
//         */
//        JScrollPane tTopScrollPane = new JScrollPane(this.tMonth);
//        JScrollPane tBottomScrollPane = new JScrollPane(this.tDay);

        /*
         * Create main button panel
         */
        JPanel grid = new JPanel(new GridLayout(7, 7));

        /*
         * Add the buttons to the main button panel, from left to right and top
         * to bottom
         */
        grid.add(bS);
        grid.add(bM);
        grid.add(bT);
        grid.add(bW);
        grid.add(bTh);
        grid.add(bF);
        grid.add(bSa);
        for (int i = 0; i < 42; i++) {
            grid.add(this.bGrid[i]);
        }
        
        JPanel backForward = new JPanel(new GridLayout(1, 3));
        backForward.add(bBack);
        backForward.add(tMonth);
        backForward.add(bForward);
        
        JPanel addDelete = new JPanel(new GridLayout(1, 3));
        addDelete.add(bDelete);
        addDelete.add(tDay);
        addDelete.add(bAdd);
        
//        /*
//         * Create side button panel
//         */
//        JPanel sideButtonPanel = new JPanel(new GridLayout(
//                SIDE_BUTTON_PANEL_GRID_ROWS, SIDE_BUTTON_PANEL_GRID_COLUMNS));
//
//        /*
//         * Add the buttons to the side button panel, from left to right and top
//         * to bottom
//         */
//        sideButtonPanel.add(this.bClear);
//        sideButtonPanel.add(this.bSwap);
//        sideButtonPanel.add(this.bEnter);
//        sideButtonPanel.add
//
//        /*
//         * Create combined button panel organized using flow layout, which is
//         * simple and does the right thing: sizes of nested panels are natural,
//         * not necessarily equal as with grid layout
//         */
//        JPanel combinedButtonPanel = new JPanel(new FlowLayout());
//
//        /*
//         * Add the other two button panels to the combined button panel
//         */
//        combinedButtonPanel.add(mainButtonPanel);
//        combinedButtonPanel.add(sideButtonPanel);

        /*
         * Organize main window
         */
        this.setLayout(new GridLayout(2, 2));

        /*
         * Add scroll panes and button panel to main window, from left to right
         * and top to bottom
         */
        this.add(backForward);
        this.add(addDelete);
        this.add(grid);
        this.add(tDay);

        // Set up the observers ----------------------------------------------

        /*
         * Register this object as the observer for all GUI events
         */
        this.bBack.addActionListener(this);
        this.bForward.addActionListener(this);
        for (int i = 0; i < 42; i++) {
            this.bGrid[i].addActionListener(this);
        }

        // Set up the main application window --------------------------------

        /*
         * Make sure the main window is appropriately sized, exits this program
         * on close, and becomes visible to the user
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void registerObserver(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void UpdateDayDisplay(CalendarDay day) {
    	
    }
    
    @Override
    public void UpdateMonthDisplay(int month, int year) {
    	switch (month) {
    		case 0: {
    			this.tMonth.setText("January " + year);
    			break;
    		}
    		
    		case 1: {
    			this.tMonth.setText("February " + year);
    			break;
    		}
    		
    		case 2: {
    			this.tMonth.setText("March " + year);
    			break;
    		}
    		
    		case 3: {
    			this.tMonth.setText("April " + year);
    			break;
    		}
    		
    		case 4: {
    			this.tMonth.setText("May " + year);
    			break;
    		}
    		
    		case 5: {
    			this.tMonth.setText("June " + year);
    			break;
    		}
    		
    		case 6: {
    			this.tMonth.setText("July " + year);
    			break;
    		}
    		
    		case 7: {
    			this.tMonth.setText("August " + year);
    			break;
    		}
    		
    		case 8: {
    			this.tMonth.setText("September " + year);
    			break;
    		}
    		
    		case 9: {
    			this.tMonth.setText("October " + year);
    			break;
    		}
    		
    		case 10: {
    			this.tMonth.setText("November " + year);
    			break;
    		}
    		
    		case 11: {
    			this.tMonth.setText("December " + year);
    			break;
    		}
    		
    		default: {
    			this.tMonth.setText("Error");
    		}
    	}
    }
    
    @Override
    public void UpdatePrevMonthAllowed(boolean allowed) {
    	
    }
    
    @Override
    public void UpdateNextMonthAllowed(boolean allowed) {
    	
    }
    
    @Override
    public void UpdateGridAllowed(int startDay, int numDays) {
    	this.bGrid = new JButton[42];
        int j = 1;
        for (int i = 0; i < 42; i++) {
        	if (i < startDay) {
        		this.bGrid[i] = new JButton("");
        		this.bGrid[i].setEnabled(false);
        	} else if (j > numDays) {
        		this.bGrid[i] = new JButton("");
        		this.bGrid[i].setEnabled(false);
        	} else {
        		this.bGrid[i] = new JButton(Integer.toString(j));
        		j++;
        	}
        }
    }
    
    @Override
    public void UpdateDeleteEventAllowed(boolean allowed) {
    	
    }
    
//    @Override
//    public void updateTopDisplay(int n) {
//        this.tTop.setText(n.toString());
//    }
//
//    @Override
//    public void updateBottomDisplay(int n) {
//        this.tBottom.setText(n.toString());
//    }
//
//    @Override
//    public void updateSubtractAllowed(boolean allowed) {
//        this.bSubtract.setEnabled(allowed);
//    }
//
//    @Override
//    public void updateDivideAllowed(boolean allowed) {
//        this.bDivide.setEnabled(allowed);
//    }
//
//    @Override
//    public void updatePowerAllowed(boolean allowed) {
//        this.bPower.setEnabled(allowed);
//    }
//
//    @Override
//    public void updateRootAllowed(boolean allowed) {
//        this.bRoot.setEnabled(allowed);
//    }

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = event.getSource();
        if (source == this.bBack) {
            this.controller.processBack();
            this.currentState = State.SAW_BACK;
        } else if (source == this.bForward) {
            this.controller.processForward();
            this.currentState = State.SAW_FORWARD;
        } else if (source == this.bAdd) {
            this.controller.processAdd();
            this.currentState = State.SAW_ADD;
        } else if (source == this.bDelete) {
            this.controller.processDelete();
            this.currentState = State.SAW_DELETE;
        } else {
            for (int i = 0; i < 42; i++) {
                if (source == this.bGrid[i]) {
                    this.controller.processDaySelect(i);
                }
            }
        }
        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

}
