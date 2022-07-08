/**
 * Simple Calendar application
 * 
 * The Calendar can go back to the year 0 AD and forward as much as the user 
 * would wish to go. A day of the month can be selected, and events can be
 * added to and removed from each day in the Calendar
 *
 * @author Kyle Hoefker
 *
 */
public final class Calendar {

    /**
     * Private constructor so this utility class cannot be instantiated
     */
    private Calendar() {
    }
    
    public static void main(String[] args) {
    	
        Model m = new Model1();
        View v = new View1();
        Controller c = new Controller1(m, v);

        v.registerObserver(c);
    }

}
