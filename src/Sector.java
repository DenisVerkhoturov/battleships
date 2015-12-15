/**
 * Сектор
 */
public class Sector implements Comparable<Sector>
{
    private int x;
    private int y;
    private boolean isOccupied;

    public Sector(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.isOccupied = false;
    }

    public boolean occupy()
    {
        if (this.isOccupied)
            return false;

        this.isOccupied = true;

        return true;
    }

    public int compareTo(Sector sector)
    {
        if (this.x == sector.x && this.y == sector.y)
            return 1;
        else
            return 0;
    }
}
