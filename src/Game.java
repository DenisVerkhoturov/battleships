import field.Sector;
import player.Player;
import player.Shot;
import ship.Ship;
import ship.Type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Запускаемый класс, реализующий всю логику игры
 */
public class Game
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final List <Ship> availableShips = Arrays.asList(
            new Ship(Type.SINGLE_DECK),
            new Ship(Type.SINGLE_DECK),
            new Ship(Type.SINGLE_DECK),
            new Ship(Type.SINGLE_DECK),
            new Ship(Type.DOUBLE_DECKER),
            new Ship(Type.DOUBLE_DECKER),
            new Ship(Type.DOUBLE_DECKER),
            new Ship(Type.THREE_DECKER),
            new Ship(Type.THREE_DECKER),
            new Ship(Type.FOUR_DECKER)
    );

    public static void main(String[] args)
    {
        Player player;
        Player npc = new Player("Воробей", availableShips);

        System.out.println("Приветствую тебя, бравый моряк, как мне тебя называть?");

        try {
            String name = reader.readLine();
            player = new Player(name, availableShips);

            /**
             * Пока игрок или компьютер не побежден будем реализовывать ход по очереди
             */
            while (player.isDefeated() || npc.isDefeated()) {

                /**
                 * Блок действий игрока
                 */
                {
                    Sector sector = new Sector(1, 1);

                    Shot shot = player.shoot(sector);
                    shot.setStatus(npc.attacked(shot));
                }

                /**
                 * Блок действий компьютера
                 */
                {
                    Sector sector = new Sector(1, 1);

                    Shot shot = npc.shoot(sector);
                    shot.setStatus(player.attacked(shot));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
