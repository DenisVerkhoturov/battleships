package ship;

import field.Sector;

/**
 * Палуба
 */
public class Deck
{
    private final Sector occupiedSector;
    private boolean intact;

    public Deck(Sector sectorToOccupy)
    {
        this.occupiedSector = sectorToOccupy;
        this.occupiedSector.occupy();
        this.intact = true;
    }

    public Sector getOccupiedSector()
    {
        return this.occupiedSector;
    }

    /**
     * @return - является ли палуба целой
     */
    public boolean isIntact()
    {
        return this.intact;
    }

    public boolean attacked()
    {
        this.intact = false;
        return true;
    }
}
