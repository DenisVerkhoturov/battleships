package models.field;

/**
 * Указатель на сектор
 * Содержит вертикальное и горизонтальное смещение сектора на поле.
 * Используется для предачи координат сектора между игроками.
 *
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Pointer
{
    private int horizontalOffset;
    private int verticalOffset;

    public Pointer(int verticalOffset, int horizontalOffset)
    {
        this.verticalOffset = verticalOffset;
        this.horizontalOffset = horizontalOffset;
    }

    public int getHorizontalOffset()
    {
        return this.horizontalOffset;
    }

    public int getVerticalOffset()
    {
        return this.verticalOffset;
    }

    public void setOffset(int vertical, int horizontal)
    {
        this.verticalOffset = vertical;
        this.horizontalOffset = horizontal;
    }
}
