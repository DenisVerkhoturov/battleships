package framework;

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

	public ScreenManager(final Set<Screen> screenSet)
	{
		super();
		this.screenSet = screenSet;
	}

	public void setScreen(Screen newScreen)
	{
		if (!this.getChildren().isEmpty() && currentScreen != null) {
			currentScreen.getController().onHide();
			clearConstraints(currentScreen.getNode());
			this.getChildren().clear();
		}
		this.currentScreen = newScreen;
		this.getChildren().add(newScreen.getNode());
		setTopAnchor(newScreen.getNode(), 0.0);
		setRightAnchor(newScreen.getNode(), 0.0);
		setBottomAnchor(newScreen.getNode(), 0.0);
		setLeftAnchor(newScreen.getNode(), 0.0);
		newScreen.getController().onShow();

		if (newScreen.getUpper() != null) {
			this.upBtn = new Button(newScreen.getUpper().getName());
			this.getChildren().add(this.upBtn);
			setTopAnchor(this.upBtn, 0.0);
			setLeftAnchor(this.upBtn, 50.0);
			setRightAnchor(this.upBtn, 50.0);
			this.upBtn.setOnMouseClicked(event -> this.slideUp());
		}

		if (newScreen.getRight() != null) {
			this.rightBtn = new Button(newScreen.getRight().getName());
			this.getChildren().add(this.rightBtn);
			setRightAnchor(this.rightBtn, 0.0);
			setTopAnchor(this.rightBtn, 50.0);
			setBottomAnchor(this.rightBtn, 50.0);
			this.rightBtn.setOnMouseClicked(event -> this.slideRight());
		}

		if (newScreen.getLower() != null) {
			this.downBtn = new Button(newScreen.getLower().getName());
			this.getChildren().add(this.downBtn);
			setBottomAnchor(this.downBtn, 0.0);
			setLeftAnchor(this.downBtn, 50.0);
			setRightAnchor(this.downBtn, 50.0);
			this.downBtn.setOnMouseClicked(event -> this.slideDown());
		}

		if (newScreen.getLeft() != null) {
			this.leftBtn = new Button(newScreen.getLeft().getName());
			this.getChildren().add(this.leftBtn);
			setLeftAnchor(this.leftBtn, 0.0);
			setTopAnchor(this.leftBtn, 50.0);
			setBottomAnchor(this.leftBtn, 50.0);
			this.leftBtn.setOnMouseClicked(event -> this.slideLeft());
		}
	}

	private void slideUp()
	{
		Screen oldScreen = currentScreen;
		Screen newScreen = currentScreen.getUpper();
		new Timeline(
				new KeyFrame(
						Duration.millis(500),
						event -> {
							this.setScreen(newScreen);
							newScreen.getNode().translateYProperty().set(-this.getHeight());
							new Timeline(
									new KeyFrame(Duration.millis(500), new KeyValue(newScreen.getNode().translateYProperty(), 0.0))
							).play();
						},
						new KeyValue(oldScreen.getNode().translateYProperty(), oldScreen.getNode().getTranslateY() + this.getHeight())
				)
		).play();
	}

	private void slideRight()
	{
		Screen oldScreen = currentScreen;
		Screen newScreen = currentScreen.getRight();
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
						new KeyValue(oldScreen.getNode().translateXProperty(), oldScreen.getNode().getTranslateX() - this.getHeight())
				)
		).play();
	}

	private void slideDown()
	{
		Screen oldScreen = currentScreen;
		Screen newScreen = currentScreen.getLower();
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
						new KeyValue(oldScreen.getNode().translateYProperty(), oldScreen.getNode().getTranslateY() - this.getHeight())
				)
		).play();
	}

	private void slideLeft()
	{
		Screen oldScreen = currentScreen;
		Screen newScreen = currentScreen.getLeft();
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
						new KeyValue(oldScreen.getNode().translateXProperty(), oldScreen.getNode().getTranslateX() + this.getHeight())
				)
		).play();
	}
}
