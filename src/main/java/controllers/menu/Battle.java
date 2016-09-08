package controllers.menu;

import framework.ScreenController;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Battle extends ScreenController
{
	@Override
	public void onShow()
	{
		System.out.println("Screen battle shown");
	}

	@Override
	public void onHide()
	{
		System.out.println("Screen battle hidden");
	}
}
