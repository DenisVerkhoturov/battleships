package field;

import field.ship.*;

import java.util.ArrayList;

/**
 * Поле игрока
 */
public class Player extends Field
{
    public Player(int width, int height) {
        super(width, height);
    }

    /**
     * @param layout - размещение корабля
     */
    public void placeShip(Layout layout)
    {
        this.ships.add(new Ship(layout));
    }

    /**
     * @return - массив секторов, доступных для позиционирования.
     */
    public ArrayList<Sector> getPossibleSectors()
    {
        ArrayList <Sector> possibleSectors = new ArrayList<Sector>();

        for (ArrayList <? super Sector> row : this.sectors)
            for (Object sector : row)
                if (!(sector instanceof Occupied))
                    possibleSectors.add((Sector) sector);

        return possibleSectors;
    }
}
