package field;

import ship.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Поле боя
 */
public class Field
{
    private final Sector[][] sectors;
    private final List <Ship> ships;

    public Field(int width, int height)
    {
        this.ships = new ArrayList<Ship>();
        this.sectors = new Sector[height][width];

        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                this.sectors[y][x] = new Sector(x, y);
    }

    public List <Ship> getShips()
    {
        return this.ships;
    }

    /**
     * @param type - тип корабля, который собираемся размещать
     */
    public void placeShip(ship.Type type)
    {
        // TODO разместить корабль
    }

    /**
     * @return - массив секторов, доступных для позиционирования.
     */
    public List <Sector> getPossibleSectors()
    {
        List <Sector> possibleSectors = new ArrayList<Sector>();

        for (Sector[] line : this.sectors)
            for (Sector sector : line)
                if (sector.isOccupied())
                    possibleSectors.add(sector);

        return possibleSectors;
    }

    /**
     * @param type - палубность коробля, для которого проверяем место
     * @param sector - сектор, в окрестностях которого нас интересует свободное место
     * @return - если корабль указанной палубности помещается вернет true
     */
    private boolean canPlaceShipOfTypeToSector(ship.Type type, Sector sector)
    {
        List <Sector> possibleSectors = this.getPossibleSectors();

        if (this.sectors[sector.getY()][sector.getX()].isOccupied()) {
            {
                for (int x = 0; x < 10; x++) {
                }
            }
        }

        return true;
    }

    public boolean isSectorEmpty(int x, int y)
    {
        return this.sectors[y][x].isOccupied();
    }

    /**
     * @return - все ли возможные корабли расставлены
     */
    public boolean isReady()
    {
        for (Ship ship : ships) {
            if (!ship.isReady())
                return false;
        }

        return true;
    }

    public boolean attacked(int x, int y)
    {
        Sector targetSector = sectors[y][x];

        targetSector.markAsShoot();

        if (targetSector.hasDeck())
            for (Ship ship : ships)
                return ship.attacked(targetSector);

        return false;
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
