package scream.battleships.framework;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import scream.battleships.configurations.Settings;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class ScreensController extends AnchorPane
{
	public static final String LOCALE_BUNDLES_URI = "scream.battleships.bundles.Locale";
	private HashMap<String, Node> screens = new HashMap<>();


	public ScreensController()
	{
		super();
	}

	/**
	 * Загрузить fxml файл, добавить его в коллецию и инъекцировать ScreenPane в контроллер.
	 *
	 * @param resource
	 * 		Имя fxml файла.
	 */
	public void loadScreen(String name, String resource) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
		Locale locale = new Locale(Settings.getInstance().getLanguage().asCode());
		ResourceBundle resources = ResourceBundle.getBundle(LOCALE_BUNDLES_URI, locale);
		loader.setResources(resources);

		Parent loadedScreen = loader.load();
		ControlledScreen controller = loader.getController();
		controller.setScreenParent(this);
		this.screens.put(name, loadedScreen);
	}

	public boolean setScreen(final String name)
	{
		Node newScene = screens.get(name);
		if (newScene != null) {
			getChildren().add(0, newScene);
			setTopAnchor(newScene, 0.0);
			setRightAnchor(newScene, this.getBoundsInParent().getWidth());
			setBottomAnchor(newScene, this.getBoundsInParent().getHeight());
			setTopAnchor(newScene, 0.0);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Попытаться отобразить screen.
	 */
	public boolean setScreen(final String name, Direction direction)
	{
		if (screens.get(name) != null) {
			final Node oldScene = getChildren().get(0);
			final Node newScene = screens.get(name);

			switch (direction) {
				case UP:
					goUpper(oldScene, newScene);
					break;
				case RIGHT:
					goRight(oldScene, newScene);
					break;
				case DOWN:
					goDown(oldScene, newScene);
					break;
				case LEFT:
					goLeft(oldScene, newScene);
					break;
				default:
			}
			return true;
		} else {
			new Alert(Alert.AlertType.ERROR, "Screen hasn't been loaded!", ButtonType.CLOSE).showAndWait();
			return false;
		}
	}

	private void goUpper(Node oldScene, Node newScene)
	{
		new Timeline(
				new KeyFrame(Duration.millis(0), new KeyValue(oldScene.layoutYProperty(), oldScene.getLayoutY())),
				new KeyFrame(
						Duration.millis(250),
						event -> {
							getChildren().remove(oldScene);
							getChildren().add(0, newScene);
							new Timeline(
									new KeyFrame(
											Duration.millis(0),
											new KeyValue(newScene.layoutYProperty(), -oldScene.getBoundsInParent().getHeight())
									),
									new KeyFrame(
											Duration.millis(250),
											new KeyValue(newScene.layoutYProperty(), 0.0)
									)
							).play();
						},
						new KeyValue(oldScene.layoutYProperty(), oldScene.getLayoutY() + oldScene.getLayoutBounds().getHeight())
				)
		).play();
	}

	private void goRight(Node oldScene, Node newScene)
	{
		new Timeline(
				new KeyFrame(Duration.millis(0), new KeyValue(oldScene.layoutXProperty(), oldScene.getLayoutX())),
				new KeyFrame(
						Duration.millis(250),
						event -> {
							getChildren().remove(oldScene);
							getChildren().add(0, newScene);
							new Timeline(
									new KeyFrame(
											Duration.millis(0),
											new KeyValue(newScene.layoutXProperty(), oldScene.getBoundsInParent().getWidth())
									),
									new KeyFrame(
											Duration.millis(250),
											new KeyValue(newScene.layoutXProperty(), 0.0)
									)
							).play();
						},
						new KeyValue(oldScene.layoutXProperty(), oldScene.getLayoutX() - oldScene.getLayoutBounds().getWidth())
				)
		).play();
	}

	private void goDown(Node oldScene, Node newScene)
	{
		new Timeline(
				new KeyFrame(Duration.millis(0), new KeyValue(oldScene.layoutYProperty(), oldScene.getLayoutY())),
				new KeyFrame(
						Duration.millis(250),
						event -> {
							getChildren().remove(oldScene);
							getChildren().add(0, newScene);
							new Timeline(
									new KeyFrame(
											Duration.millis(0),
											new KeyValue(newScene.layoutYProperty(), oldScene.getBoundsInParent().getHeight())
									),
									new KeyFrame(
											Duration.millis(250),
											new KeyValue(newScene.layoutYProperty(), 0.0)
									)
							).play();
						},
						new KeyValue(oldScene.layoutYProperty(), oldScene.getLayoutY() - oldScene.getLayoutBounds().getHeight())
				)
		).play();
	}

	private void goLeft(Node oldScene, Node newScene)
	{
		new Timeline(
				new KeyFrame(Duration.millis(0), new KeyValue(oldScene.layoutXProperty(), oldScene.getLayoutX())),
				new KeyFrame(
						Duration.millis(250),
						event -> {
							getChildren().remove(oldScene);
							getChildren().add(0, newScene);
							new Timeline(
									new KeyFrame(
											Duration.millis(0),
											new KeyValue(newScene.layoutXProperty(), -oldScene.getBoundsInParent().getWidth())
									),
									new KeyFrame(
											Duration.millis(250),
											new KeyValue(newScene.layoutXProperty(), 0.0)
									)
							).play();
						},
						new KeyValue(oldScene.layoutXProperty(), oldScene.getLayoutX() + oldScene.getLayoutBounds().getWidth())
				)
		).play();
	}
}
