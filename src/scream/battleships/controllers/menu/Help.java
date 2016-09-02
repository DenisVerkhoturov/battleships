package scream.battleships.controllers.menu;

import scream.battleships.framework.ControlledScreen;
import scream.battleships.framework.Direction;
import scream.battleships.framework.ScreensController;
import javafx.event.ActionEvent;
import scream.battleships.start.BattleShips;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Help implements ControlledScreen
{
    ScreensController controller;

    @Override
    public void setScreenParent(ScreensController parent)
    {
        this.controller = parent;
    }

    public void main(ActionEvent actionEvent)
    {
        controller.setScreen(BattleShips.menuMainID, Direction.DOWN);
    }
}
