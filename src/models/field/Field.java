package models.field;

import models.field.sector.Empty;
import models.field.sector.Sector;
import models.field.ship.Ship;

import java.util.ArrayList;

/**
 * Поле боя
 */
public abstract class Field
{
    protected final ArrayList <ArrayList <Sector>> sectors;
    protected final ArrayList <Ship> ships;
    private final Pointer pointer;

    protected Field(int width, int height)
    {
        this.ships = new ArrayList<Ship>();
        this.sectors = new ArrayList <ArrayList <Sector>>(height);

        for (int verticalOffset = 0; verticalOffset < this.sectors.size(); verticalOffset++) {
            ArrayList <Sector> row = new ArrayList<Sector>(width);

            for (int horizontalOffset = 0; horizontalOffset < row.size(); horizontalOffset++)
                row.add(new Empty());
        }

        this.pointer = new Pointer(0, 0);
    }

    public Pointer getPointer()
    {
        return this.pointer;
    }

    public ArrayList <Ship> getShips()
    {
        return this.ships;
    }

    /**
     * Вычиляет результат попадания по указанному сектору.
     * @param horizontalOffset - горизонтальное смещение сектора
     * @param verticalOffset - вертикальное смещение сектора
     * @return - объяект сектора, по которому совершили выстрел
     */
    public Sector attacked(int horizontalOffset, int verticalOffset)
    {
        return (sectors.get(verticalOffset).get(horizontalOffset)).attacked();
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
