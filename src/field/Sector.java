package field;

/**
 * Сектор
 */
public class Sector
{
    private final int x;
    private final int y;
    private boolean available;
    private boolean shoot;

    public Sector(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.available = true;
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

    public boolean isAvailable()
    {
        return this.available;
    }

    public boolean isShoot()
    {
        return this.shoot;
    }

    public void markAsShoot()
    {
        this.shoot = true;
    }

    public boolean occupy()
    {
        if (this.isAvailable()) {
            this.available = true;

            return true;
        }

        return false;
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
