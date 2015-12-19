package models.player;

import models.field.sector.Sector;
import models.field.Pointer;
import models.field.Opponent;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Player
{
    private models.field.Player field;
    private Opponent opponent;

    public Player()
    {
    }

    /**
     * Разместить корабль.
     */
    public void placeShip()
    {
    }

    /**
     * @return - объек выстрела
     */
    public Pointer shoot()
    {
        return this.opponent.getPointer();
    }

    /**
     * @param x - горизонтальный индекс ячейки
     * @param y - вертикальный индекс ячейки
     * @return - перенаправляет проверку выстрела объекту класса Field текущего игрока
     */
    public Sector attacked(int x, int y)
    {
        return this.field.attacked(x, y);
    }

    public boolean isDefeated()
    {
        return field.isDefeated();
    }
}
