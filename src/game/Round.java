package game;

import field.Field;
import player.Player;

/**
 * Раунд игры
 */
public class Round
{
    private final Player player;
    private final Player opponent;
    private Settings settings;
    private Field playerField;
    private Field opponentField;

    public Round(Player player, Player opponent, Settings settings)
    {
        this.player = player;
        this.opponent = opponent;
        this.settings = settings;
    }
}
