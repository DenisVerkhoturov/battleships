package objects;

import objects.field.ship.Type;

import java.util.Arrays;
import java.util.List;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Settings // TODO сделать Serializable и сохранять в файл
{
    private final int fieldWidth;
    private final int fieldHeight;
    private final List<Type> ships;

    /**
     * Настройки игры по умолчанию
     */
    public Settings()
    {
        this.fieldWidth = 10;
        this.fieldHeight = 10;
        this.ships = Arrays.asList(
                Type.SINGLE_DECK,
                Type.SINGLE_DECK,
                Type.SINGLE_DECK,
                Type.SINGLE_DECK,
                Type.DOUBLE_DECKER,
                Type.DOUBLE_DECKER,
                Type.DOUBLE_DECKER,
                Type.THREE_DECKER,
                Type.THREE_DECKER,
                Type.FOUR_DECKER
        );
    }

    public Settings(int fieldWidth, int fieldHeight, List <Type> ships)
    {
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        this.ships = ships;
    }

    public int getFieldWidth()
    {
        return this.fieldWidth;
    }

    public int getFieldHeight()
    {
        return this.fieldHeight;
    }

    public List <Type> getAvailableShips()
    {
        return this.ships;
    }
}
