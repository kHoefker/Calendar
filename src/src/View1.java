import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
    private static final int TEXT_AREA_HEIGHT = 5, TEXT_AREA_WIDTH = 20;

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
        
        final JFrame inputFrame = new JFrame();
        inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set up the GUI widgets --------------------------------------------

        /*
         * Create widgets
         */
        this.tMonth = new JTextArea("January 2022", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.tDay = new JTextArea("", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.bBack = new JButton("Last Month");
        this.bForward = new JButton("Next Month");
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
        this.tDay.setEditable(false);
        this.tDay.setLineWrap(true);
        this.tDay.setWrapStyleWord(true);
        

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

        /*
         * Organize main window
         */
        this.setLayout(new GridLayout(2, 2));

        /*
         * Add scroll panes and button panel to main window, from left to right
         * and top to bottom
         */
        this.add(backForward);
        this.getContentPane().add(addDelete);
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
        this.bAdd.addActionListener(this);
        this.bDelete.addActionListener(this);

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
    public void UpdateDayDisplay(int key, Map<Integer, List<String>> events) {
    	StringBuilder contents = new StringBuilder("" + ((key / 1000000) + 1) + " / " + (((key / 10000) % 100) + 1) + " / " + (key % 10000) + "\n\n");
    	
    	if (events.containsKey(key)) {
    		List<String> strings = events.get(key);
    		for (int i = 0; i < strings.size(); i++) {
    			contents.append("" + (i + 1) + ".  " + strings.get(i) + "\n");
    		}
    	}
    	
    	this.tDay.setText(contents.toString());
    }
    
    @Override
    public void UpdateMonthDisplay(int month, int year) {
    	switch (month) {
    		case 0: {
    			this.tMonth.setText("\n\n\n\n\n\n                    January " + year);
    			break;
    		}
    		
    		case 1: {
    			this.tMonth.setText("\n\n\n\n\n\n                   February " + year);
    			break;
    		}
    		
    		case 2: {
    			this.tMonth.setText("\n\n\n\n\n\n                      March " + year);
    			break;
    		}
    		
    		case 3: {
    			this.tMonth.setText("\n\n\n\n\n\n                      April " + year);
    			break;
    		}
    		
    		case 4: {
    			this.tMonth.setText("\n\n\n\n\n\n                        May " + year);
    			break;
    		}
    		
    		case 5: {
    			this.tMonth.setText("\n\n\n\n\n\n                       June " + year);
    			break;
    		}
    		
    		case 6: {
    			this.tMonth.setText("\n\n\n\n\n\n                       July " + year);
    			break;
    		}
    		
    		case 7: {
    			this.tMonth.setText("\n\n\n\n\n\n                     August " + year);
    			break;
    		}
    		
    		case 8: {
    			this.tMonth.setText("\n\n\n\n\n\n                  September " + year);
    			break;
    		}
    		
    		case 9: {
    			this.tMonth.setText("\n\n\n\n\n\n                    October " + year);
    			break;
    		}
    		
    		case 10: {
    			this.tMonth.setText("\n\n\n\n\n\n                    November " + year);
    			break;
    		}
    		
    		case 11: {
    			this.tMonth.setText("\n\n\n\n\n\n                    December " + year);
    			break;
    		}
    		
    		default: {
    			this.tMonth.setText("Error");
    		}
    	}
    }
    
    @Override
    public void UpdateGridAllowed(int startDay, int numDays) {
        int j = 1;
        for (int i = 0; i < 42; i++) {
        	if (i < startDay) {
        		this.bGrid[i].setText("");
        		this.bGrid[i].setEnabled(false);
        	} else if (j > numDays) {
        		this.bGrid[i].setText("");
        		this.bGrid[i].setEnabled(false);
        	} else {
        		this.bGrid[i].setText(Integer.toString(j));
        		this.bGrid[i].setEnabled(true);
        		j++;
        	}
        }
    }
    
    @Override
    public void UpdateDeleteEventAllowed(int key, Map<Integer, List<String>> events) {
    	if (events.containsKey(key)) {
    		if (events.get(key).isEmpty()) {
    			this.bDelete.setEnabled(false);
    		} else {
    			this.bDelete.setEnabled(true);
    		}
    	} else {
    		this.bDelete.setEnabled(false);
    	}
    }

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
        } else if (source == this.bForward) {
            this.controller.processForward();
        } else if (source == this.bAdd) {
            this.controller.processAdd();
        } else if (source == this.bDelete) {
            this.controller.processDelete();
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
