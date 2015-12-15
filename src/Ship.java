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

        switch (type) {
            case FOUR_DECKER:
                decks.add(new Deck());
            case THREE_DECKER:
                decks.add(new Deck());
            case DOUBLE_DECKER:
                decks.add(new Deck());
            case SINGLE_DECK:
                decks.add(new Deck());
        }
    }

    public List <Deck> getDecks()
    {
        return this.decks;
    }

    public State getState()
    {
        return this.state;
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
     *
     * SINGLE_DECK - однопалубный
     * DOUBLE_DECKER - двухпалубный
     * THREE_DECKER - трехпалубный
     * FOUR_DECKER - четырехпалубный
     */
    enum Type
    {
        SINGLE_DECK, DOUBLE_DECKER, THREE_DECKER, FOUR_DECKER
    }
}
