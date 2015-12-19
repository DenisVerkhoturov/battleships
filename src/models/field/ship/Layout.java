package models.field.ship;

import models.field.sector.Occupied;

import java.util.ArrayList;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Layout
{
    private final ArrayList<Occupied> sectors;
    private final Type type;

    public Layout()
    {
        this.type = null;
        this.sectors = new ArrayList<Occupied>();
    }

    public Layout(Type type)
    {
        this.type = type;
        this.sectors = new ArrayList<Occupied>(type.getNumberOfDecks());
    }

    public void addToLayout(Occupied sector)
    {
        if (this.type == null)
            this.sectors.add(sector);
        else
            if (this.sectors.size() == this.type.getNumberOfDecks())
                this.sectors.add(sector);
    }

    public ArrayList<Occupied> getSectors()
    {
        return this.sectors;
    }
}
