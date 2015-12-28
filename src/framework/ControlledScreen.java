package framework;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public interface ControlledScreen
{
    /**
     * Метод предоставляет возможность инъецировать родительский ScreenPane
     */
    void setScreenParent(ScreensController parent);
}
