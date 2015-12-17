package field.ship;

import java.util.ArrayList;

/**
 * Корабль
 */
public class Ship
{
    private final Type type;
    private final ArrayList <Deck> decks;

    public Ship(Layout layout)
    {
        this.type = layout.getTypeOfShip();
        this.decks = new ArrayList<Deck>();

        for (field.Sector sector : layout.getSectors())
            decks.add((Deck) sector);
    }

    /**
     * Проверить, на плаву ли еще корабль.
     * @return - если хотя бы одна из палуб осталась нетронутой вернет true
     */
    public boolean isAfloat()
    {
        for (Deck deck : decks)
            if (deck.isIntact())
                return true;

        return false;
    }
}
