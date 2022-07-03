/**
 * Simple Calendar application
 * 
 * add description
 *
 * @author Kyle Hoefker
 *
 */
public final class Calendar {

    /**
     * Private constructor so this utility class cannot be instantiated.
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
