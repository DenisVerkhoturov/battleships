package game.field.ship;

/**
 * Тип коробля
 */
public enum Type
{
    SINGLE_DECK(1), DOUBLE_DECKER(2), THREE_DECKER(3), FOUR_DECKER(4);

    private final int numberOfDecks;

    Type(int numberOfDecks)
    {
        this.numberOfDecks = numberOfDecks;
    }

    public int getNumberOfDecks() {
        return numberOfDecks;
    }
}
