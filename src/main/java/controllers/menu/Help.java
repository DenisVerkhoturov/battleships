package controllers.menu;

import framework.ScreenController;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Help extends ScreenController
{
	@Override
	public void onShow()
	{
		System.out.println("Screen help shown");
	}

	@Override
	public void onHide()
	{
		System.out.println("Screen help hidden");
	}
}
