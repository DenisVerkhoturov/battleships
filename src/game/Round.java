package game;

import game.field.ship.Layout;
import game.field.ship.Type;

/**
 * Раунд игры
 */
public class Round // TODO сделать Serializable и сохранять в файл
{
    private Settings settings;
    private game.field.Player playerField;
    private game.field.Opponent opponentField;

    public Round(Settings settings)
    {
        this.settings = settings;
        this.playerField = new game.field.Player(settings.getFieldWidth(), settings.getFieldHeight());
        this.opponentField = new game.field.Opponent(settings.getFieldWidth(), settings.getFieldHeight());
    }

    public game.field.Player getPlayerField()
    {
        return this.playerField;
    }

    public game.field.Opponent opponentField()
    {
        return this.opponentField;
    }

    public void placeShip()
    {
        Layout layout = new Layout(Type.SINGLE_DECK, this.playerField.getPossibleSectors());

        this.playerField.placeShip(layout);
    }

    public Type chooseShip()
    {
        // TODO
        return Type.SINGLE_DECK;
    }

    /**
     * Проверить, можно ли считать раунд завершенным.
     * @return - завершен ли раунд
     */
    public boolean isFinished()
    {
        return playerField.isDefeated();
    }
}
