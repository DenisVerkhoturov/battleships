package scream.battleships.start;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import scream.battleships.objects.SpriteAnimation;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Test extends Application
{
    private static final int COLUMNS = 16;
    private static final int COUNT = 16;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 0;
    private static final int WIDTH = 64;
    private static final int HEIGHT = 512;
    private static final Image IMAGE = new Image(Main.class.getResourceAsStream("../resources/images/explosions.png"));

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Smoke animated");
        final ImageView imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        primaryStage.setScene(new Scene(new Group(imageView)));
        primaryStage.show();
    }
}
