import javax.swing.*;

/**
 * Точка входа
 *
 * Долго пытался, потратил кучу времени, но не смог закончить до следующего занятия.
 * Этот проект буду продолжать дальше писать. Думаю, это достойно того чтобы этим заниматься, к тому же отличный пример для обучения.
 * Если по существу, пункты домашнего задания:
 * 1) System.out.println("Приветствую бравый моряк, назовите мне ваше имя");
 * 2) BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 *    String username = reader.readLine();
 * 3) Выполнено в models.Settings в конструкторе по умолчанию
 * 4) Выполнено в models.field.ship.Ship
 * 5) Не выполнил, но работу с массивами и заполнением масссивов можно посмотреть в конструкторе models.field.Field
 * 6) if ((int) Math.random() == 1)
 *        System.out.println("Вы победили");
 *    else
 *        System.out.println("Вы проиграли");
 *
 * Мой репозиторий https://bitbucket.org/Leo_Scream/battle-ships
 */
public class Main
{
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }

        int random = (int) Math.random();
        controllers.Game game = new controllers.Game();
    }
}
