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

    public Field()
    {
        this.ships = new ArrayList<Ship>();
        this.sectors = new Sector[10][10];

        for (int y = 0; y < 10; y++)
            for (int x = 0; x < 10; x++)
                this.sectors[y][x] = new Sector(x, y);
    }

    public List <Ship> getShips()
    {
        return this.ships;
    }

    /**
     * @param ship - корабль с позиционированными палубами
     */
    public void placeShip(Ship ship, Sector sector)
    {
        while (!this.isReady()) {
            if (this.canPlaceShipOfTypeToSector(ship.getType() , sector)) {
                while (!ship.isReady()) {
                    Deck deck = new Deck(sector);
                    // TODO если позиционирование в этом секторе возможно добавляем палубу в корабль
                    ship.setDeckTo(deck);
                }
            }
        }
    }

    /**
     * @return - массив секторов, доступных для позиционирования.
     */
    public Sector[] getPossibleSectors()
    {
        List <Sector> possibleSectors = new ArrayList<Sector>();

        for (Sector[] line : this.sectors) for (Sector sector : line) possibleSectors.add(sector);

        for (Ship ship : ships) for (Sector sector : ship.getOccupationArea()) possibleSectors.remove(sector);

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

        if (this.sectors[sector.getY()][sector.getX()].isAvailable()) {
            {
                for (int x = 0; x < 10; x++) {
                }
            }
        }

        return true;
    }

    public boolean isSectorEmpty(int x, int y)
    {
        return this.sectors[y][x].isAvailable();
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
}
