package models;

import models.player.Player;

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
        this.round = new Round(new Player(), new Player());
    }
}
