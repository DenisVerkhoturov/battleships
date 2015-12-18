package game.field.sector;

/**
 * Сектор
 */
public abstract class Sector
{
    private boolean shoot;

    public Sector()
    {
        this.shoot = false;
    }

    public boolean attacked()
    {
        this.shoot = true;
        return false;
    }

    protected boolean isShoot()
    {
        return this.shoot;
    }
}
