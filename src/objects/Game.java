package objects;

import objects.field.ship.Type;
import objects.player.Player;

import java.util.ArrayList;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Game
{
    private Settings settings;
    private Round round;

    public Game()
    {
        this.settings = new Settings();
    }

    public void newRound()
    {
        this.round = new Round(new Player(new ArrayList<Type>()), new Player(new ArrayList<Type>()));
    }
}
