package field;

/**
 * Сектор
 */
public class Sector
{
    private final int x;
    private final int y;
    private boolean empty;
    private boolean occupied;
    private boolean shoot;

    public Sector(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.empty = true;
        this.occupied = false;
        this.shoot = false;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void markAsShoot()
    {
        this.shoot = true;
    }

    public void occupy()
    {
        if (this.empty) {
            this.empty = false;
            this.occupied = true;
        }
    }

    public boolean hasDeck()
    {
        return this.empty;
    }

    protected boolean isOccupied()
    {
        return this.occupied;
    }

    protected boolean isShoot()
    {
        return this.shoot;
    }

    /**
     * @param sector - сектор, с которым необходимо произвести сравнени
     * @return - если координаты точки одинаковые, то считаем, что редь идет об одном и том же секторе
     */
    public boolean isSameAs(Sector sector)
    {
        return (this.x == sector.getX() && this.y == sector.getY());
    }
}
