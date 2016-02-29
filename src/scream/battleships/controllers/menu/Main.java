package scream.battleships.controllers.menu;

import scream.battleships.framework.ControlledScreen;
import scream.battleships.framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import scream.battleships.start.BattleShips;

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
        controller.setScreen(BattleShips.menuHelpID);
    }

    @FXML
    public void settings(ActionEvent actionEvent)
    {
        controller.setScreen(BattleShips.menuSettingsID);
    }

    @FXML
    public void resume(ActionEvent actionEvent)
    {
    }

    @FXML
    public void battle(ActionEvent actionEvent)
    {
        controller.setScreen(BattleShips.menuBattleID);
    }
}
