package player;

import field.Field;
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
    private final List <Ship> availableShips;

    public Player(String name, List <Ship> availableShips)
    {
        this.name = name;
        this.history = new ArrayList<Shot>();
        this.opponent = new Field();
        this.availableShips = availableShips;
    }

    /**
     * Разместить корабли.
     */
    public void placeShips()
    {
    }

    /**
     * Совершить выстрел. И сохранить его в истории выстрелов.
     * @param sector - сектор, по которому будет произведен выстрел
     * @return - объек выстрела
     */
    public Shot shoot(field.Sector sector)
    {
        Shot shot = new Shot(sector);
        this.history.add(shot);
        return shot;
    }

    /**
     * @param shot - выстрел
     * @return - если сектор, по которому произвели выстрел занят целой палубой корабля, возвращает true
     */
    public boolean attacked(Shot shot)
    {
        for (Ship ship : this.field.getShips()) {
            for (Deck deck : ship.getDecks()) {
                if (shot.getTarget().isSameAs(deck.getOccupiedSector())) {
                    deck.attacked();
                    return true;
                }
            }
        }

        return false;
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
