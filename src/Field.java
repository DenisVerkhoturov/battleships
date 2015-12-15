import java.util.List;

/**
 * Поле
 */
public class Field
{
    private Sector[][] sectors;
    private List <Ship> ships;

    public Field()
    {
        this.init();
    }

    private void init()
    {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sectors[y][x] = new Sector(x, y);
            }
        }
    }
}
