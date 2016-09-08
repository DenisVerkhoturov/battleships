package framework;

import com.sun.istack.internal.NotNull;
import exceptions.ScreenNotFoundException;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.*;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class ScreensManager extends AnchorPane
{
	private static final String LOCALE_BUNDLES_URI = "resources.bundles.Locale";
	private HashMap<String, Node> screens = new HashMap<>();
	private final Set<Screen> screenSet;

	public ScreensManager()
	{
		super();
		this.screenSet = new HashSet<>();
	}

	public ScreensManager(Set<Screen> screenSet)
	{
		super();
		this.screenSet = screenSet;
	}

	public void setScreen(@NotNull final String name) throws ScreenNotFoundException
	{
		Node newScreen = screens.get(name);
		if (newScreen == null)
			throw new ScreenNotFoundException(name);
		this.setScreen(newScreen);
	}

	/**
	 * Попытаться отобразить screen.
	 */
	public boolean slide(final String name, Direction direction)
	{
		if (screens.get(name) != null) {
			final Node oldScreen = getChildren().get(0);
			final Node newScreen = screens.get(name);

			switch (direction) {
				case UP:
					slideUp(oldScreen, newScreen);
					break;
				case RIGHT:
					slideRight(oldScreen, newScreen);
					break;
				case DOWN:
					slideDown(oldScreen, newScreen);
					break;
				case LEFT:
					slideLeft(oldScreen, newScreen);
					break;
				default:
			}
			return true;
		} else {
			new Alert(Alert.AlertType.ERROR, "Screen hasn't been loaded!", ButtonType.CLOSE).showAndWait();
			return false;
		}
	}

	private void slideUp(Node oldScreen, Node newScreen)
	{
		new Timeline(
				new KeyFrame(
						Duration.millis(500),
						event -> {
							this.setScreen(newScreen);
							newScreen.translateYProperty().set(-this.getHeight());
							System.out.println(newScreen.translateYProperty().get());
							new Timeline(
									new KeyFrame(Duration.millis(500), event1 -> System.out.println(newScreen.getTranslateY()), new KeyValue(newScreen.translateYProperty(), 0.0))
							).play();
						},
						new KeyValue(oldScreen.translateYProperty(), oldScreen.getTranslateY() + this.getHeight())
				)
		).play();
	}

	private void slideRight(Node oldScreen, Node newScreen)
	{
		new Timeline(
				new KeyFrame(
						Duration.millis(500),
						event -> {
							this.setScreen(newScreen);
							newScreen.translateXProperty().set(this.getHeight());
							new Timeline(
									new KeyFrame(Duration.millis(500), new KeyValue(newScreen.translateXProperty(), 0.0))
							).play();
						},
						new KeyValue(oldScreen.translateXProperty(), oldScreen.getTranslateX() - this.getHeight())
				)
		).play();
	}

	private void slideDown(Node oldScreen, Node newScreen)
	{
		new Timeline(
				new KeyFrame(
						Duration.millis(500),
						event -> {
							this.setScreen(newScreen);
							newScreen.translateYProperty().set(this.getHeight());
							new Timeline(
									new KeyFrame(Duration.millis(500), new KeyValue(newScreen.translateYProperty(), 0.0))
							).play();
						},
						new KeyValue(oldScreen.translateYProperty(), oldScreen.getTranslateY() - this.getHeight())
				)
		).play();
	}

	private void slideLeft(Node oldScreen, Node newScreen)
	{
		new Timeline(
				new KeyFrame(
						Duration.millis(500),
						event -> {
							this.setScreen(newScreen);
							newScreen.translateXProperty().set(-this.getHeight());
							new Timeline(
									new KeyFrame(Duration.millis(500), new KeyValue(newScreen.translateXProperty(), 0.0))
							).play();
						},
						new KeyValue(oldScreen.translateXProperty(), oldScreen.getTranslateX() + this.getHeight())
				)
		).play();
	}

	public void setScreen(@NotNull Node newScreen)
	{
		if (!this.getChildren().isEmpty()) {
			System.out.println("Removing old screen");
			Node oldScreen = this.getChildren().get(0);
			this.getChildren().remove(oldScreen);
			clearConstraints(newScreen);
		}
		System.out.println("Setting new screen");

		this.getChildren().add(0, newScreen);
		setTopAnchor(newScreen, 0.0);
		setRightAnchor(newScreen, this.getWidth());
		setBottomAnchor(newScreen, this.getHeight());
		setLeftAnchor(newScreen, 0.0);
	}

	public void setScreen(@NotNull Screen newScreen)
	{
		if (!this.getChildren().isEmpty()) {
			Node oldScreenNode = this.getChildren().get(0);
			clearConstraints(oldScreenNode);
			this.getChildren().remove(oldScreenNode);
		}

		this.getChildren().add(0, newScreen.getNode());
		setTopAnchor(newScreen.getNode(), 0.0);
		setRightAnchor(newScreen.getNode(), this.getWidth());
		setBottomAnchor(newScreen.getNode(), this.getHeight());
		setLeftAnchor(newScreen.getNode(), 0.0);
	}
}
