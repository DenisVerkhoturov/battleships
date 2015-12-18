package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Контроллер игры
 */
public class Game implements ActionListener
{
    private models.Game model;
    private views.Game view;

    public Game()
    {
        this.model = new models.Game();
        this.view = new views.Game(this.model);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {}
}
