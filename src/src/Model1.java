/**
 * Model class.
 *
 * @author Kyle Hoefker
 */
public final class Model1 implements Model {

    /**
     * Model variables.
     */
    private final int top, bottom;

    /**
     * Default constructor.
     */
    public Model1() {
        this.top = 0;
        this.bottom = 0;
    }

    @Override
    public int top() {
        return this.top;
    }

    @Override
    public int bottom() {
        return this.bottom;
    }

}
