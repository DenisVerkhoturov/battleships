package controllers.menu;

import framework.ControlledScreen;
import framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Main implements ControlledScreen
{
    ScreensController controller;

    @Override
    public void setScreenParent(ScreensController parent)
    {
        this.controller = parent;
    }

    @FXML
    public void help(ActionEvent actionEvent)
    {
        controller.setScreen(start.BattleShips.menuHelpID);
    }

    @FXML
    public void settings(ActionEvent actionEvent)
    {
    }

    @FXML
    public void resume(ActionEvent actionEvent)
    {
    }

    @FXML
    public void battle(ActionEvent actionEvent)
    {
        controller.setScreen(start.BattleShips.menuBattleID);
    }
}
