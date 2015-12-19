package models;

import models.field.ship.Layout;
import models.field.ship.Type;
import models.player.Player;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Round // TODO сделать Serializable и сохранять в файл
{
    private Player player;
    private Player opponent;

    public Round(Player player, Player opponent)
    {
        this.player = player;
        this.opponent = opponent;
    }

    public void placeShip()
    {
        Layout layout = new Layout(Type.SINGLE_DECK);

        this.player.placeShip();
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
        return player.isDefeated();
    }
}
