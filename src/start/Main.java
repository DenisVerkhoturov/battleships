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

        container.setScreen(menuMainID);


        Group root = new Group();
        root.getChildren().addAll(container);
        Scene scene = new Scene(root);
        stage.setTitle("Battle Ships");
        stage.setScene(scene);
        stage.show();
    }
}
