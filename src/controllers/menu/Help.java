package controllers.menu;

import framework.ControlledScreen;
import framework.ScreensController;
import javafx.event.ActionEvent;

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
        controller.setScreen(start.Main.menuMainID);
    }
}
