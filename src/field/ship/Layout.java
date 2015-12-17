package field.ship;

import field.Sector;

import java.util.ArrayList;

/**
 * Расположение корабля
 * Используется как указатель для создания корабля
 */
public class Layout
{
    private final ArrayList<Sector> sectors;
    private final Type typeOfShip;

    public Layout(Type type, ArrayList<Sector> availableSectors)
    {
        this.sectors = availableSectors;
        this.typeOfShip = type;
    }

    public void addToLayout(Sector sector)
    {
        this.sectors.add(sector);
    }

    protected ArrayList<Sector> getSectors()
    {
        return this.sectors;
    }

    public Type getTypeOfShip()
    {
        return this.typeOfShip;
    }

    public boolean validate()
    {
        return this.sectors.size() == this.typeOfShip.getNumberOfDecks();
    }
}
