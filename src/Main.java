import javax.swing.*;

/**
 * Точка входа
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

        controllers.Game game = new controllers.Game();
    }
}
