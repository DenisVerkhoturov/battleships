package game.field.sector;

/**
 * Оккупированный сектор - палуба
 */
public class Occupied extends Sector
{
    private boolean intact = true;

    public Occupied() {
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
