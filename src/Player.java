import java.util.List;

/**
 * Игрок
 */
public class Player
{
    private String name;
    private Field field;
    private List <Ship> ships;
    private List <Shot> history;

    public Player(String name)
    {
        this.name = name;
        this.init();
    }

    public Shot shoot(Sector sector)
    {
        return new Shot(sector);
    }

    public boolean getHit(Shot shot)
    {
        for (Ship ship : this.ships) {
            for (Deck deck : ship.getDecks()) {
                if (deck.getSector() == shot.getSector())
                    return true;
            }
        }

        return false;
    }

    private void init()
    {
        ships.add(new Ship(Ship.Type.SINGLE_DECK));
        ships.add(new Ship(Ship.Type.SINGLE_DECK));
        ships.add(new Ship(Ship.Type.SINGLE_DECK));
        ships.add(new Ship(Ship.Type.SINGLE_DECK));

        ships.add(new Ship(Ship.Type.DOUBLE_DECKER));
        ships.add(new Ship(Ship.Type.DOUBLE_DECKER));
        ships.add(new Ship(Ship.Type.DOUBLE_DECKER));

        ships.add(new Ship(Ship.Type.THREE_DECKER));
        ships.add(new Ship(Ship.Type.THREE_DECKER));

        ships.add(new Ship(Ship.Type.FOUR_DECKER));
    }

    public boolean isDefeated()
    {
        for (Ship ship : this.ships) {
            if (ship.getState() == Ship.State.WHOLE)
                return false;
        }

        return true;
    }
}
