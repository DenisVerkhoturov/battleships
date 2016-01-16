package controllers.menu;

import framework.ControlledScreen;
import framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import start.*;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Battle implements ControlledScreen
{
    private ScreensController controller;

    @Override
    public void setScreenParent(ScreensController parent)
    {
        this.controller = parent;
    }

    @FXML
    public void main(ActionEvent actionEvent)
    {
        controller.setScreen(start.BattleShips.menuMainID);
    }

    @FXML
    public void singlePlayer(ActionEvent actionEvent)
    {
        controller.setScreen(start.BattleShips.battlePlacementID);
    }

    @FXML
    public void multiPlayer(ActionEvent actionEvent)
    {}
}
