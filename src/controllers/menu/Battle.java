package controllers.menu;

import framework.ControlledScreen;
import framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Battle implements ControlledScreen
{
    ScreensController controller;

    @Override
    public void setScreenParent(ScreensController parent)
    {
        this.controller = parent;
    }

    @FXML
    public void main(ActionEvent actionEvent)
    {
        controller.setScreen(start.Main.menuMainID);
    }

    @FXML
    public void singlePlayer(ActionEvent actionEvent)
    {}

    @FXML
    public void multiPlayer(ActionEvent actionEvent)
    {}
}
