package objects;

import java.util.ArrayList;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Field
{
    protected final ArrayList <ArrayList<Sector>> sectors;
    protected final ArrayList <Ship> ships;

    public Field(int columns, int rows)
    {
        this.ships = new ArrayList<>();
        this.sectors = new ArrayList <>(rows);

        for (int verticalOffset = 0; verticalOffset < this.sectors.size(); verticalOffset++) {
            ArrayList <Sector> row = new ArrayList<>(columns);

            for (int horizontalOffset = 0; horizontalOffset < row.size(); horizontalOffset++)
                row.add(new Sector());
        }
    }

    public ArrayList <Ship> getShips()
    {
        return this.ships;
    }

    /**
     * Вычиляет результат попадания по сектору, расположенному в указанных координатах.
     *
     * @param row - вертикальное смещение.
     * @param column - горизонтальное сщенеие
     * @return - объяект сектора, по которому совершили выстрел
     */
    public boolean attacked(int row, int column)
    {
        return (sectors.get(row).get(column)).attacked();
    }

    /**
     * Проверяет, остались ли корабли на плаву.
     * @return - если все корабли разбиты возвращает true
     */
    public boolean isDefeated()
    {
        for (Ship ship : ships)
            if (ship.isDefeated())
                return false;

        return true;
    }
}
