import java.util.ArrayList;
import java.util.List;

/**
 * Поле боя
 */
public class Field
{
    private Sector[][] sectors;
    private List <Ship> ships;

    public Field()
    {
        this.init();
    }

    /**
     * @param ship - корабль с позиционированными палубами
     */
    public void placeShip(Ship ship, Sector sector)
    {
        while (!this.isReady()) {
            if (this.canPlaceShipTo(sector)) {
                while (!ship.isReady()) {
                    Deck deck = new Deck(sector);
                    if (canPlaceDeck(deck)) {
                        // TODO если позиционирование в этом секторе возможно добавляем палубу в корабль
                    }
                }
            }
        }
    }

    /**
     * @return - массив секторов, доступных для позиционирования.
     */
    public List <Sector> getPossibleSectors()
    {
        List <Sector> possibleSectors = new ArrayList<Sector>();

        for (Sector[] line : this.sectors) {
            for (Sector sector : line) {
                possibleSectors.add(sector);
            }
        }

        for (Ship ship : ships) {
            for (Sector sector : ship.getOccupationZone()) {
                possibleSectors.remove(sector);
            }
        }

        return possibleSectors;
    }

    public List <Ship> getShips()
    {
        return this.ships;
    }

    private boolean canPlaceShipTo(Sector sector)
    {
        return true;
    }

    /**
     * Проверяет может ли палуба занимать, указанный в ней сектор.
     * @param deck - проверяемая палуба
     * @return - возвращает true, если этот сектор еще ничем не занят
     */
    private boolean canPlaceDeck(Deck deck)
    {
        for (Sector sector : this.getPossibleSectors()) {
            if (deck.getSector().isSameAs(sector)) {
                return false;
            }
        }

        return true;
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

    /**
     * Инициализация стартовых условий.
     */
    private void init()
    {
        this.ships = new ArrayList<Ship>();
        this.sectors = new Sector[10][10];

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                this.sectors[y][x] = new Sector(x, y);
            }
        }

        /**
         * Заполнение массива кораблями
         */
        this.ships.add(new Ship(Ship.Type.SINGLE_DECK));
        this.ships.add(new Ship(Ship.Type.SINGLE_DECK));
        this.ships.add(new Ship(Ship.Type.SINGLE_DECK));
        this.ships.add(new Ship(Ship.Type.SINGLE_DECK));

        this.ships.add(new Ship(Ship.Type.DOUBLE_DECKER));
        this.ships.add(new Ship(Ship.Type.DOUBLE_DECKER));
        this.ships.add(new Ship(Ship.Type.DOUBLE_DECKER));

        this.ships.add(new Ship(Ship.Type.THREE_DECKER));
        this.ships.add(new Ship(Ship.Type.THREE_DECKER));

        this.ships.add(new Ship(Ship.Type.FOUR_DECKER));
    }
}
