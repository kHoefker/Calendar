import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * View class
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
     * Buttons.
     */
    private JButton bBack, bForward, bAdd, bDelete, bS, bM, bT, bW, bTh, bF, bSa;
    private JButton[] bGrid;

    /**
     * Default constructor.
     */
    public View1() {
        // Create the JFrame being extended
        super("Calendar");
        
        final JFrame inputFrame = new JFrame();
        inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set up the GUI widgets --------------------------------------------

        /*
         * Create widgets
         */
        this.tMonth = new JTextArea("January 2022", 5, 20);
        this.tDay = new JTextArea("", 5, 20);
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

        this.tMonth.setEditable(false);
        this.tMonth.setLineWrap(true);
        this.tMonth.setWrapStyleWord(true);
        this.tDay.setEditable(false);
        this.tDay.setLineWrap(true);
        this.tDay.setWrapStyleWord(true);
        
        /*
         * Create day selection grid
         */
        JPanel grid = new JPanel(new GridLayout(7, 7));

        /*
         * Add Weekdays
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
        
        /*
         * Create month panel
         */
        JPanel backForward = new JPanel(new GridLayout(1, 3));
        backForward.add(bBack);
        backForward.add(tMonth);
        backForward.add(bForward);
        
        /*
         * Create a panel to add and delete events
         */
        JPanel addDelete = new JPanel(new GridLayout(1, 3));
        addDelete.add(bDelete);
        addDelete.add(tDay);
        addDelete.add(bAdd);

        /*
         * Organize main window
         */
        this.setLayout(new GridLayout(2, 2));
        this.add(backForward);
        this.getContentPane().add(addDelete);
        this.add(grid);
        this.add(tDay);

        // Set up the observers ----------------------------------------------

        this.bBack.addActionListener(this);
        this.bForward.addActionListener(this);
        for (int i = 0; i < 42; i++) {
            this.bGrid[i].addActionListener(this);
        }
        this.bAdd.addActionListener(this);
        this.bDelete.addActionListener(this);

        // Set up the main application window --------------------------------
        
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
    	
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        /*
         * Determine which event has occurred
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
        
        this.setCursor(Cursor.getDefaultCursor());
    }

}
