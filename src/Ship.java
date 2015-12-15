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

    /**
     * @return - соответствует ли количество палуб типу корабля
     */
    public boolean isReady()
    {
        switch (this.type) {
            case FOUR_DECKER:
                return decks.size() == 4;
            case THREE_DECKER:
                return decks.size() == 3;
            case DOUBLE_DECKER:
                return decks.size() == 2;
            case SINGLE_DECK:
                return decks.size() == 1;
            default:
                return false;
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
        // TODO заполнение массива секторами, на которых корабль расположен, и с которыми он граничит
        return occupationZone;
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
