package objects;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Sector
{
    private boolean shoot = false;
    private boolean available = true;

    public boolean isShoot()
    {
        return this.shoot;
    }

    public boolean Occupy()
    {
        if (this.available) {
            this.available = false;
            return true;
        }

        return false;
    }

    public boolean isAvailable()
    {
        return this.available;
    }

    public boolean attacked()
    {
        this.shoot = true;
        return true;
    }
}
