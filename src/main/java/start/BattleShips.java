package start;

import javafx.fxml.FXMLLoader;
import configurations.Settings;
import framework.Screen;
import framework.ScreensManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class BattleShips extends Application
{
	private final String FXML_DIR = "/fxml";
	private final String BUNDLES_URI = "bundles.Locale";

	private Locale locale = new Locale(Settings.getInstance().getLanguage().asCode());
	private ResourceBundle bundle = ResourceBundle.getBundle(BUNDLES_URI, locale);

	private final Screen main = loadScreen("main", getClass().getResource(FXML_DIR + "/menu/main.fxml"));
	private final Screen help = loadScreen("help", getClass().getResource(FXML_DIR + "/menu/help.fxml"));
	private final Screen settings = loadScreen("settings", getClass().getResource(FXML_DIR + "/menu/settings.fxml"));
	private final Screen battle = loadScreen("battle", getClass().getResource(FXML_DIR + "/menu/battle.fxml"));
	private final Screen resume = loadScreen("resume", getClass().getResource(FXML_DIR + "/battle/battle.fxml"));

	private final ScreensManager screensManager;

	public BattleShips()
	{
		main.setUpper(help);
		main.setRight(resume);
		main.setLower(battle);
		main.setLeft(settings);

		Set<Screen> screens = new HashSet<>();
		screens.add(main);
		screens.add(help);
		screens.add(settings);
		screens.add(battle);
		screens.add(resume);

		screensManager = new ScreensManager(screens);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		ScreensManager root = screensManager;
		root.setScreen(main);

		Scene scene = new Scene(root);
		stage.setTitle("Battle Ships");
		stage.setMinWidth(500);
		stage.setMinHeight(300);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void stop() throws Exception
	{
		Settings.getInstance().save();
	}

	private Screen loadScreen(String name, URL resource)
	{
		Screen screen;
		try {
			FXMLLoader loader = new FXMLLoader(resource);
			loader.setResources(bundle);
			screen = new Screen(bundle.getString(name), loader.load(), loader.getController());
		} catch (IOException e)
		{
			e.printStackTrace();
			screen = null;
		}

		return screen;
	}
}
