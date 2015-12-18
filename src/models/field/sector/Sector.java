package models.field.sector;

/**
 * Сектор
 */
public abstract class Sector
{
    protected boolean shoot;

    public Sector()
    {
        this.shoot = false;
    }

    public boolean isShoot()
    {
        return this.shoot;
    }

    public abstract Sector attacked();
}
