package views;

import javax.swing.*;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Game extends JFrame
{
    private static final long serialVersionUID = 1L;

    private models.Game model;

    private Field player;
    private Field opponent;

    /**
     * Создание представления главной формы
     * @param model - модель главной формы
     */
    public Game(models.Game model) {
        this.model = model;
        buildUI();
    }

    /**
     * построение интерфейса пользователя
     */
    private void buildUI() {
        this.setTitle("Морской Бой");
        this.setResizable(false);
        this.setBounds(400, 300, 483, 228);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        player = new Field();
        player.setBounds(20, 31, 151, 151);
        this.getContentPane().add(player);

        opponent = new Field();
        opponent.setBounds(190, 31, 151, 151);
        this.getContentPane().add(opponent);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 477, 21);
        this.getContentPane().add(menuBar);

        menuBar.add(new JMenu("Игра").add(new JMenuItem("Новая игра")));
    }
}