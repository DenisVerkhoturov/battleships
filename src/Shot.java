/**
 * Выстрел
 */
public class Shot
{
    private Sector sector;
    private boolean status;

    public Shot(Sector sector)
    {
        this.sector = sector;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public Sector getSector()
    {
        return this.sector;
    }
}
