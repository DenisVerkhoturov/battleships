package scream.battleships.objects;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class SpriteAnimation extends Transition
{
    private final ImageView imageView;
    private final int count;
    private final int columns;
    private final int horizontalOffset;
    private final int verticalOffset;
    private final int height;
    private final int width;

    private int lastIndex;

    public SpriteAnimation(ImageView imageView, Duration duration, int count, int columns, int horizontalOffset, int verticalOffset, int width, int height)
    {
        this.imageView = imageView;
        this.count = count;
        this.columns = columns;
        this.horizontalOffset = horizontalOffset;
        this.verticalOffset = verticalOffset;
        this.width = width;
        this.height = height;

        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double frac)
    {
        final int index = Math.min((int) Math.floor(frac * this.count), count - 1);

        if (index != this.lastIndex) {
            final int x = (index % this.columns) * this.width + this.horizontalOffset;
            final int y = (index / this.columns) * this.height + this.verticalOffset;
            imageView.setViewport(new Rectangle2D(x, y, this.width, this.height));
            this.lastIndex = index;
        }
    }
}
