package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Sector extends SpriteAnimation
{

    private SimpleStringProperty symbol;

    public Sector(ImageView imageView, Duration duration, int count, int columns, int horizontalOffset, int verticalOffset, int width, int height) {
        super(imageView, duration, count, columns, horizontalOffset, verticalOffset, width, height);
    }
}
