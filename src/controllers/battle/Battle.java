package controllers.battle;

import framework.ControlledScreen;
import framework.ScreensController;

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
}
