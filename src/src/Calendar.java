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

    /**
     * Main program that sets up main application window and starts user
     * interaction.
     *
     * @param args
     *            command-line arguments; not used
     */
    public static void main(String[] args) {
        /*
         * Create instances of the model, view, and controller objects;
         * controller needs to know about model and view, and view needs to know
         * about controller
         */
        Model m = new Model1();
        View v = new View1();
        Controller c = new Controller1(m, v);

        v.registerObserver(c);
    }

}
