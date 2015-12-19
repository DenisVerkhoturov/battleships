package models.field;

import models.field.sector.Empty;
import models.field.sector.Sector;
import models.field.ship.Layout;
import models.field.ship.Ship;

import java.util.ArrayList;

/**
 * @author Verhoturov Denis - Leo.Scream.
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

        for (ArrayList <Sector> row : this.sectors)
            for (Sector sector : row)
                if (!(sector instanceof Empty))
                    possibleSectors.add(sector);

        return possibleSectors;
    }

    /**
     * Обозначить сектора вокруг корабля как недоступные
     */
    private void surroundShip()
    {
        // TODO реализовать метод
    }
}
