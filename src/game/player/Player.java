package game.player;

import game.field.sector.Sector;
import game.Round;

/**
 * Игрок
 */
public class Player
{
    private final String name;
    private Sector pointer;
    private Round round;

    public Player(String name)
    {
        this.name = name;
    }

    public Sector getTargetOfPointer() {
        return this.pointer;
    }

    public void setPointerTo(Sector pointer) {
        this.pointer = pointer;
    }

    /**
     * Разместить корабли.
     */
    public void placeShips()
    {
    }

    /**
     * Совершить выстрел. И сохранить его в истории выстрелов.
     * @return - объек выстрела
     */
    public Shot shoot()
    {
        Shot shot = new Shot(this.pointer);
        return shot;
    }

    /**
     * @param x - горизонтальный индекс ячейки
     * @param y - вертикальный индекс ячейки
     * @return - перенаправляет проверку выстрела объекту класса Field текущего игрока
     */
    public boolean attacked(int x, int y)
    {
        return this.round.getPlayerField().attacked(x, y);
    }
}
