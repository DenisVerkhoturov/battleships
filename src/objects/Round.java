package objects;

import objects.field.Pointer;
import objects.field.ship.Layout;
import objects.field.ship.Type;
import objects.player.Player;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Round implements Runnable // TODO сделать Serializable и сохранять в файл
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

    @Override
    public void run()
    {
        while (!this.isFinished()) {
            while(!player.isDefeated() || !opponent.isDefeated()) {
                Pointer target = player.shoot();
                opponent.attacked(target);
            }
        }
    }

    /**
     * Проверить, можно ли считать раунд завершенным.
     * @return - завершен ли раунд
     */
    public boolean isFinished()
    {
        return this.player.isDefeated() || this.opponent.isDefeated();
    }

}
