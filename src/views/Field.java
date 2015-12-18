package views;

import javax.swing.*;
import java.awt.*;

/**
 * Представление поля
 */
public class Field extends JPanel
{
    private static final long serialVersionUID = 1L;
    public Game model;

    public Field()
    {}

    protected void drawField(Graphics g)
    {
        for (int i = 0; i < 11; i++) {
            g.drawLine(i * 15, 0, i * 15, 150);
            g.drawLine(0, i * 15, 150, i * 15);
        }

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                drawSector(g, i, j);
            }
        }
    }

    protected void drawSector(Graphics g, int i, int j)
    {}
}
