import field.Sector;
import game.Game;
import player.Player;
import player.Shot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Запускаемый класс, реализующий всю логику игры
 */
public class Main
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)
    {
        Game game = new Game();
        Player player;
        Player npc = new Player("Воробей");

        System.out.println("Приветствую тебя, бравый моряк, как мне тебя называть?");

        try {
            String name = reader.readLine();
            player = new Player(name);

            /**
             * Пока игрок или компьютер не побежден будем реализовывать ход по очереди
             */
            while (!player.isDefeated() || !npc.isDefeated()) {

                /**
                 * Блок действий игрока
                 */
                {
                    Sector sector = new Sector(1, 1);

                    Shot shot = player.shoot();
                    shot.setStatus(npc.attacked(shot.getTarget().getX(), shot.getTarget().getY()));
                }

                /**
                 * Блок действий компьютера
                 */
                {
                    Sector sector = new Sector(1, 1);

                    Shot shot = npc.shoot();
                    shot.setStatus(player.attacked(shot.getTarget().getX(), shot.getTarget().getY()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
