package game.player;

import game.field.sector.Sector;

/**
 * Выстрел
 */
public class Shot
{
    private Sector target;
    private boolean status;

    public Shot(Sector target)
    {
        this.target = target;
    }

    /**
     * @return - сектор, по которому был произведен выстрел
     */
    public Sector getTarget()
    {
        return this.target;
    }

    /**
     * @return - результат попадания
     */
    public boolean getStatus()
    {
        return this.status;
    }

    /**
     * @param status - результат попадания
     */
    public void setStatus(Boolean status)
    {
        this.status = status;
    }
}
