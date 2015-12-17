package field.ship;

/**
 * Палуба
 */
public class Deck extends Occupied
{
    private boolean intact = true;

    public Deck() {
        super();
    }

    /**
     * @return - является ли палуба целой
     */
    public boolean isIntact()
    {
        return this.intact;
    }

    public boolean attacked()
    {
        super.attacked();
        this.intact = false;
        return true;
    }
}
