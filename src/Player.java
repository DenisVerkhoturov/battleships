import java.util.*;

/**
 * Игрок
 */
public class Player
{
    private String name;
    private Field field;
    private Field opponent;
    private List <Shot> history;

    public Player(String name)
    {
        this.name = name;
        this.init();
    }

    /**
     * Инициализация стартовых условий.
     */
    private void init()
    {
        this.history = new ArrayList<Shot>();
        this.opponent = new Field();
    }

    /**
     * Разместить корабли.
     */
    public void placeShips()
    {
    }

    /**
     * Совершить выстрел. И сохранить его в истории выстрелов.
     * @param sector - сектор, по которому будет произведен выстрел
     * @return - объек выстрела
     */
    public Shot shoot(Sector sector)
    {
        Shot shot = new Shot(sector);
        this.history.add(shot);
        return shot;
    }

    /**
     * @param shot - выстрел
     * @return - если сектор, по которому произвели выстрел занят целой палубой корабля, возвращает true
     */
    public boolean attacked(Shot shot)
    {
        for (Ship ship : this.field.getShips()) {
            for (Deck deck : ship.getDecks()) {
                if (deck.getSector().isSameAs(shot.getSector()) && deck.getState() == Deck.State.WHOLE) {
                    deck.attacked();
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Проверить, остались ли у игрока живые корабли.
     * @return - если такой корабль найден, возвращает false
     */
    public boolean isDefeated()
    {
        for (Ship ship : this.field.getShips()) {
            if (ship.getState() == Ship.State.WHOLE)
                return false;
        }

        return true;
    }
}
