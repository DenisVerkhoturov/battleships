package scream.battleships.controllers.menu;

import scream.battleships.framework.ControlledScreen;
import scream.battleships.framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import scream.battleships.start.BattleShips;

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
        controller.setScreen(BattleShips.menuMainID);
    }

    @FXML
    public void singlePlayer(ActionEvent actionEvent)
    {
        controller.setScreen(BattleShips.battlePlacementID);
    }

    @FXML
    public void multiPlayer(ActionEvent actionEvent)
    {}
}
