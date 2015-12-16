import java.util.ArrayList;
import java.util.List;

/**
 * Корабль
 */
public class Ship
{
    private Type type;
    private State state;
    private List<Deck> decks;

    public Ship(Type type)
    {
        this.type = type;
        this.state = State.WHOLE;
    }

    public List <Deck> getDecks()
    {
        return this.decks;
    }

    public State getState()
    {
        return this.state;
    }

    public Type getType()
    {
        return this.type;
    }

    public void setDeckTo(Deck deck)
    {
        decks.add(deck);
    }

    /**
     * Получить территорию занимаемую кораблем и соседствующею с ней.
     * @return - массив секторов входяхив в эту территорию
     */
    public List <Sector> getOccupationZone()
    {
        List <Sector> occupationZone = new ArrayList<Sector>();
        // TODO найти более элегантное решение задачи
        for (Deck deck : decks) {
            Sector deckSector = deck.getSector();
            occupationZone.add(deckSector);

            if (deckSector.getX() != 0) occupationZone.add(new Sector(deckSector.getX() - 1, deckSector.getY()));
            if (deckSector.getX() != 9) occupationZone.add(new Sector(deckSector.getX() + 1, deckSector.getY()));

            if (deckSector.getY() != 0) occupationZone.add(new Sector(deckSector.getX(), deckSector.getY() - 1));
            if (deckSector.getY() != 9) occupationZone.add(new Sector(deckSector.getX(), deckSector.getY() + 1));

            if (deckSector.getX() != 0 && deckSector.getY() != 0) occupationZone.add(new Sector(deckSector.getX() - 1, deckSector.getY() - 1));
            if (deckSector.getX() != 0 && deckSector.getY() != 0) occupationZone.add(new Sector(deckSector.getX() - 1, deckSector.getY() - 1));
            if (deckSector.getX() != 9 && deckSector.getY() != 9) occupationZone.add(new Sector(deckSector.getX() + 1, deckSector.getY() + 1));
            if (deckSector.getX() != 9 && deckSector.getY() != 9) occupationZone.add(new Sector(deckSector.getX() + 1, deckSector.getY() + 1));
        }
        return occupationZone;
    }

    /**
     * @return - соответствует ли количество палуб типу корабля
     */
    public boolean isReady()
    {
        return this.decks.size() == this.type.length;
    }

    /**
     * Состояние коробля
     *
     * WHOLE - корабль цел
     * WOUNDED - корабль ранен
     * FLOODED - корабль потоплен
     */
    enum State
    {
        WHOLE, WOUNDED, FLOODED
    }

    /**
     * Тип коробля
     */
    enum Type
    {
        SINGLE_DECK(1), DOUBLE_DECKER(2), THREE_DECKER(3), FOUR_DECKER(4);

        private int length;

        Type(int length)
        {
            this.length = length;
        }
    }
}
