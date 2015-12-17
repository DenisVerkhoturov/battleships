package game;

import field.Field;

/**
 * Раунд игры
 */
public class Round // TODO сделать Serializable и сохранять в файл
{
    private Settings settings;
    private Field playerField;
    private Field opponentField;

    public Round(Settings settings)
    {
        this.settings = settings;
        this.playerField = new Field(settings.getFieldWidth(), settings.getFieldHeight());
        this.opponentField = new Field(settings.getFieldWidth(), settings.getFieldHeight());
    }

    public Field getPlayerField()
    {
        return this.playerField;
    }

    public Field opponentField()
    {
        return this.opponentField;
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
