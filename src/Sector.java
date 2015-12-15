/**
 * Сектор
 */
public class Sector
{
    private int x;
    private int y;

    public Sector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @param sector - сектор, с которым необходимо произвести сравнени
     * @return - если координаты точки одинаковые, то считаем, что редь идет об одном и том же секторе
     */
    public boolean isSameAs(Sector sector)
    {
        return (this.x == sector.getX() && this.y == sector.getY());
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }
}
