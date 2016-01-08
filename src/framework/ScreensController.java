package framework;

import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class ScreensController  extends StackPane
{
    private HashMap<String, Node> container = new HashMap<>();

    public ScreensController()
    {
        super();
    }

    public void addScreen(String name, Node screen)
    {
        container.put(name, screen);
    }

    public Node getScreen(String name)
    {
        return container.get(name);
    }

    /**
     * Загрузить fxml файл, добавить его в коллецию и инъекцировать ScreenPane в контроллер.
     *
     * @param name
     *             Имя под которым, screen будет храниться в коллеции.
     * @param resource
     *                 Имя fxml файла.
     * @return
     *         Если файл существует и его удалось загрузить - вернет true.
     */
    public boolean loadScreen(String name, String resource)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) loader.load();
            ControlledScreen controller = ((ControlledScreen) loader.getController());
            controller.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Попытаться отобразить screen.
     */
    public boolean setScreen(final String name)
    {
        if (container.get(name) != null) {
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                getChildren().remove(0);
                                getChildren().add(0, container.get(name));
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(container.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }
    }

    /**
     * @param name
     *             Имя screen'a, который необходимо удалить из коллекции.
     * @return
     *         Если screen'a с таким именем нет, вернет false.
     */
    public boolean unloadScreen(String name)
    {
        if (container.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }
}
