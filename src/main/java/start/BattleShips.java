package start;

import io.vavr.control.Option;
import io.vavr.control.Try;
import javafx.fxml.FXMLLoader;
import configurations.Settings;
import framework.Screen;
import framework.ScreenManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class BattleShips extends Application {
    private static final String FXML_DIR = "/fxml";
    private static final String BUNDLES_URI = "bundles.Locale";

    private Locale locale = new Locale(Settings.getInstance().getLanguage().asCode());
    private ResourceBundle bundle = ResourceBundle.getBundle(BUNDLES_URI, locale);

    private final Screen main = loadScreen("main", getClass().getResource(FXML_DIR + "/menu/main.fxml")).getOrElseThrow(RuntimeException::new);

    private final ScreenManager screenManager;

    public BattleShips() {
        final Screen help = loadScreen("help", getClass().getResource(FXML_DIR + "/menu/help.fxml")).get();
        main.setUpper(help);
        final Screen resume = loadScreen("resume", getClass().getResource(FXML_DIR + "/battle/battle.fxml")).get();
        main.setRight(resume);
        final Screen battle = loadScreen("battle", getClass().getResource(FXML_DIR + "/menu/battle.fxml")).get();
        main.setLower(battle);
        final Screen settings = loadScreen("settings", getClass().getResource(FXML_DIR + "/menu/settings.fxml")).get();
        main.setLeft(settings);

        final Set<Screen> screens = new HashSet<>();
        screens.add(main);
        screens.add(help);
        screens.add(settings);
        screens.add(battle);
        screens.add(resume);

        screenManager = new ScreenManager(screens);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        ScreenManager root = screenManager;
        root.setScreen(main);

        Scene scene = new Scene(root);
        stage.setTitle("Battle Ships");
        stage.setMinWidth(500);
        stage.setMinHeight(300);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        Settings.getInstance().save();
    }

    private Option<Screen> loadScreen(final String name, final URL resource) {
        final FXMLLoader loader = new FXMLLoader(resource, bundle);
        return Try.of(() -> new Screen(bundle.getString(name), loader.load(), loader.getController()))
                  .toOption();
    }
}
