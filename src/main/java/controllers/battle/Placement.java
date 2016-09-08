package controllers.battle;

import framework.ScreenController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Placement extends ScreenController implements Initializable
{
	@FXML
	private Canvas battleground;

	private GraphicsContext ctx;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		//drawBattleGround();
	}

	private void drawBattleGround()
	{
        this.ctx.strokeRect(10, 10, 50, 50);
	}

	@Override
	public void onShow()
	{
		System.out.println("Screen placement shown");
	}

	@Override
	public void onHide()
	{
		System.out.println("Screen placement hidden");
	}
}
