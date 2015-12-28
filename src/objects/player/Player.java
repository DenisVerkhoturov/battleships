package objects.player;

import objects.field.sector.Sector;
import objects.field.Pointer;
import objects.field.ship.Type;

import java.util.ArrayList;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Player
{
    private objects.field.Player myField;
    private objects.field.Opponent opponentField;

    public Player(ArrayList <Type> ships)
    {
    }

    /**
     * Разместить корабль.
     */
    public void placeShip()
    {
    }

    /**
     * @return
     *        Объек указателя на сектор, по которому был произведен выстрел.
     */
    public Pointer shoot()
    {
        return opponentField.getPointer();
    }

    /**
     * @param target
     *        Указатель на целевой сектор, по которому произведен выстрел.
     *
     * @return
     *        Перенаправляет проверку результатов попадания объекту класса Field текущего игрока.
     *        Вернет объект сектора, готовый к подстановке в поле.
     */
    public Sector attacked(Pointer target)
    {
        return myField.attacked(target);
    }

    /**
     * Проверить, побежден ли уже игрок.
     *
     * @return
     *        true - если флот игрока разбит.
     *        false - если остались корабли на плаву.
     */
    public boolean isDefeated()
    {
        return myField.isDefeated();
    }
}
