package scream.battleships.controllers.battle;

import scream.battleships.framework.ControlledScreen;
import scream.battleships.framework.ScreensController;

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
