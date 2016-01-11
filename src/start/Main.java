package start;

import framework.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Main extends Application
{
    public static String menuMainID = "main";
    public static String menuMainFile = "../fxml/menu/main.fxml";

    public static String menuHelpID = "help";
    public static String menuHelpFile = "../fxml/menu/help.fxml";

    public static String menuBattleID = "newbattle";
    public static String menuBattleFile = "../fxml/menu/battle.fxml";

    public static String battlePlacementID = "placement";
    public static String battlePlacementFile = "../fxml/battle/placement.fxml";

    public static String battleBattleID = "battle";
    public static String battleBattleFile = "../fxml/battle/battle.fxml";

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        ScreensController container = new ScreensController();
        container.loadScreen(menuMainID, menuMainFile);
        container.loadScreen(menuHelpID, menuHelpFile);
        container.loadScreen(menuBattleID, menuBattleFile);
        container.loadScreen(battlePlacementID, battlePlacementFile);
        container.loadScreen(battleBattleID, battleBattleFile);
        container.setScreen(menuMainID);

        Group root = new Group();
        root.getChildren().addAll(container);
        Scene scene = new Scene(root);
        stage.setTitle("Battle Ships");
        stage.setMinWidth(500);
        stage.setMinHeight(300);
        stage.setScene(scene);
        stage.show();
    }
}
