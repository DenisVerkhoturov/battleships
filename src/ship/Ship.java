package ship;

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
            decks.add(new Deck(sector));
    }

    /**
     * Проверить, на плаву ли еще корабль.
     * @return - если хотя бы одна из палуб осталась не тронутой вернет true
     */
    public boolean isAfloat()
    {
        for (Deck deck : decks)
            if (deck.isIntact())
                return true;

        return false;
    }

    /**
     * @return - соответствует ли количество палуб типу корабля
     */
    public boolean isReady()
    {
        return this.decks.size() == this.type.getNumberOfDecks();
    }

    /**
     * @param targetSector - сектор, по которому был произведен выстрел
     * @return - результат попадания
     */
    public boolean attacked(field.Sector targetSector)
    {
        for (Deck deck : decks)
            if (targetSector.isSameAs(deck.getOccupiedSector()))
                return deck.attacked();

        return false;
    }
}
