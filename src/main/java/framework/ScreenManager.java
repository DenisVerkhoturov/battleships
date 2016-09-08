package framework;

import com.sun.istack.internal.NotNull;
import exceptions.ScreenNotFoundException;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.*;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class ScreenManager extends AnchorPane
{
	private Button upBtn;
	private Button rightBtn;
	private Button downBtn;
	private Button leftBtn;
	private final Set<Screen> screenSet;
	private Screen currentScreen;

	public ScreenManager(@NotNull final Set<Screen> screenSet)
	{
		super();
		this.screenSet = screenSet;
	}

	private void slideUp()
	{
		Screen newScreen = currentScreen.getUpper();
		new Timeline(
				new KeyFrame(
						Duration.millis(500),
						event -> {
							this.setScreen(currentScreen);
							newScreen.getNode().translateYProperty().set(-this.getHeight());
							System.out.println(newScreen.getNode().translateYProperty().get());
							new Timeline(
									new KeyFrame(Duration.millis(500), new KeyValue(newScreen.getNode().translateYProperty(), 0.0))
							).play();
						},
						new KeyValue(currentScreen.getNode().translateYProperty(), currentScreen.getNode().getTranslateY() + this.getHeight())
				)
		).play();
	}

	private void slideRight()
	{
		Screen newScreen = currentScreen.getUpper();

		new Timeline(
				new KeyFrame(
						Duration.millis(500),
						event -> {
							this.setScreen(newScreen);
							newScreen.getNode().translateXProperty().set(this.getHeight());
							new Timeline(
									new KeyFrame(Duration.millis(500), new KeyValue(newScreen.getNode().translateXProperty(), 0.0))
							).play();
						},
						new KeyValue(currentScreen.getNode().translateXProperty(), currentScreen.getNode().getTranslateX() - this.getHeight())
				)
		).play();
	}

	private void slideDown()
	{
		Screen newScreen = currentScreen.getUpper();
		new Timeline(
				new KeyFrame(
						Duration.millis(500),
						event -> {
							this.setScreen(newScreen);
							newScreen.getNode().translateYProperty().set(this.getHeight());
							new Timeline(
									new KeyFrame(Duration.millis(500), new KeyValue(newScreen.getNode().translateYProperty(), 0.0))
							).play();
						},
						new KeyValue(currentScreen.getNode().translateYProperty(), currentScreen.getNode().getTranslateY() - this.getHeight())
				)
		).play();
	}

	private void slideLeft()
	{
		Screen newScreen = currentScreen.getUpper();
		new Timeline(
				new KeyFrame(
						Duration.millis(500),
						event -> {
							this.setScreen(newScreen);
							newScreen.getNode().translateXProperty().set(-this.getHeight());
							new Timeline(
									new KeyFrame(Duration.millis(500), new KeyValue(newScreen.getNode().translateXProperty(), 0.0))
							).play();
						},
						new KeyValue(currentScreen.getNode().translateXProperty(), currentScreen.getNode().getTranslateX() + this.getHeight())
				)
		).play();
	}

	public void setScreen(@NotNull Screen newScreen)
	{
		if (!this.getChildren().isEmpty() && currentScreen != null) {
			currentScreen.getController().onHide();
			clearConstraints(currentScreen.getNode());
			this.getChildren().remove(currentScreen.getNode());
		}

		this.getChildren().add(0, newScreen.getNode());
		setTopAnchor(newScreen.getNode(), 0.0);
		setRightAnchor(newScreen.getNode(), this.getWidth());
		setBottomAnchor(newScreen.getNode(), this.getHeight());
		setLeftAnchor(newScreen.getNode(), 0.0);
		newScreen.getController().onShow();
	}
}
