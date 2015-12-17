package field;

import field.ship.*;

import java.util.ArrayList;

/**
 * Поле боя
 */
public abstract class Field
{
    protected final ArrayList <ArrayList <? super Sector>> sectors;
    protected final ArrayList <Ship> ships;

    protected Field(int width, int height)
    {
        this.ships = new ArrayList<Ship>();
        this.sectors = new ArrayList <ArrayList <? super Sector>>(height);

        for (int verticalOffset = 0; verticalOffset < this.sectors.size(); verticalOffset++) {
            ArrayList <? super Sector> row = new ArrayList<Sector>(width);

            for (int horizontalOffset = 0; horizontalOffset < row.size(); horizontalOffset++)
                row.add(new Sector(horizontalOffset, verticalOffset));
        }
    }

    public ArrayList <Ship> getShips()
    {
        return this.ships;
    }

    public boolean attacked(int horizontalOffset, int verticalOffset)
    {
        return ((Sector) sectors.get(verticalOffset).get(horizontalOffset)).attacked();
    }

    /**
     * Проверить, остались ли корабли на плаву.
     * @return - если такой корабль найден, возвращает false
     */
    public boolean isDefeated()
    {
        for (Ship ship : ships)
            if (ship.isAfloat())
                return false;

        return true;
    }
}
