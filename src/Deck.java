/**
 * Палуба
 */
public class Deck
{
    private Sector sector;
    private State state;

    public Deck(Sector sector)
    {
        this.sector = sector;
        this.state = State.WHOLE;
    }

    public State getState()
    {
        return this.state;
    }

    public Sector getSector()
    {
        return this.sector;
    }

    public void getHit()
    {
        this.state = State.BROKEN;
    }

    /**
     * Состояние палубы
     *
     * WHOLE - палуба цела
     * BROKEN - палуба разрушена
     */
    enum State
    {
        WHOLE, BROKEN
    }
}
