package objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Field
{
    private ObservableList<Sector> map = FXCollections.observableArrayList();

    public Field(int width, int height)
    {
        for (int i = 0; i < width * height; i++);
    }
}
