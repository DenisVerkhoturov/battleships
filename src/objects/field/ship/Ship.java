package objects.field.ship;

import objects.field.sector.Occupied;

import java.util.ArrayList;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Ship
{
    private final ArrayList <Occupied> decks;

    public Ship(Layout layout)
    {
        this.decks = new ArrayList <Occupied>();

        for (Occupied sector : layout.getSectors())
            decks.add(sector);
    }

    /**
     * Проверить, на плаву ли еще корабль.
     * @return - если хотя бы одна из палуб осталась нетронутой вернет true
     */
    public boolean isAfloat()
    {
        for (Occupied deck : decks)
            if (deck.isIntact())
                return true;

        return false;
    }
}
