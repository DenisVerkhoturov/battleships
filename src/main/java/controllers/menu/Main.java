package controllers.menu;

import framework.ScreenController;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Main extends ScreenController
{
	@Override
	public void onShow()
	{
		System.out.println("Screen main shown");
	}

	@Override
	public void onHide()
	{
		System.out.println("Screen main hidden");
	}
}
