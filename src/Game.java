import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Запускаемый класс, реализующий всю логику игры
 */
public class Game
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)
    {
        Player player;
        Player npc = new Player("Воробей");

        System.out.println("Приветствую тебя, бравый моряк, как мне тебя называть?");

        try {
            String name = reader.readLine();
            player = new Player(name);

            while (player.isDefeated() || npc.isDefeated()) {
                /**
                 * Блок действий игрока
                 */
                {
                    Sector sector = new Sector(1, 1);

                    Shot shot = player.shoot(sector);
                    shot.setStatus(npc.getHit(shot));
                }

                /**
                 * Блок действий компьютера
                 */
                {
                    Sector sector = new Sector(1, 1);

                    Shot shot = player.shoot(sector);
                    shot.setStatus(npc.getHit(shot));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
