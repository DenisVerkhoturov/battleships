package ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Корабль
 */
public class Ship
{
    private final Type type;
    private final boolean afloat;
    private final List <Deck> decks;

    public Ship(Type type)
    {
        this.type = type;
        this.afloat = true;
        this.decks = new ArrayList <Deck>();
    }

    public Type getType()
    {
        return this.type;
    }

    public List <Deck> getDecks()
    {
        return this.decks;
    }

    public void setDeckTo(field.Sector sector)
    {
        Deck deck = new Deck(sector);
        decks.add(deck);
    }

    public boolean isAfloat()
    {
        return this.afloat;
    }

    /**
     * @return - соответствует ли количество палуб типу корабля
     */
    public boolean isReady()
    {
        return this.decks.size() == this.type.getNumberOfDecks();
    }
}
