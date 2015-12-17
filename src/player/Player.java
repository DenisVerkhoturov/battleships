package player;

import field.*;
import ship.*;

import java.util.*;

/**
 * Игрок
 */
public class Player
{
    private final String name;
    private Field field;
    private final Field opponent;
    private final List <Shot> history;
    private Sector pointer;

    public Player(String name)
    {
        this.name = name;
        this.history = new ArrayList<Shot>();
        this.opponent = new Field();
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
        this.history.add(shot);
        return shot;
    }

    /**
     * @param shot - выстрел
     * @return - перенаправляет проверку выстрела объекту класса Field текущего игрока
     */
    public boolean attacked(int x, int y)
    {
        return this.field.attacked(x, y);
    }

    /**
     * Проверить, остались ли у игрока корабли на плаву.
     * @return - если такой корабль найден, возвращает false
     */
    public boolean isDefeated()
    {
        for (Ship ship : this.field.getShips()) {
            if (ship.isAfloat())
                return false;
        }

        return true;
    }
}
