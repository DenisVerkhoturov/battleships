package game;

/**
 * Игра
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
        this.round = new Round(settings);
    }
}
