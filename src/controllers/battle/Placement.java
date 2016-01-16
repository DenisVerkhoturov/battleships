package controllers.battle;

import framework.ControlledScreen;
import framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Placement implements ControlledScreen, Initializable
{
    @FXML
    private GridPane player;

    @FXML
    private GridPane opponent;

    private ScreensController controller;

    @Override
    public void setScreenParent(ScreensController parent)
    {
        this.controller = parent;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        int width = 10;
        int height = 10;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.player.add(new Text("x"), i, j);
            }
        }

        this.player.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event)
            {

            }
        });
    }

    @FXML
    public void menu(ActionEvent actionEvent)
    {
        controller.setScreen(start.BattleShips.menuBattleID);
    }

    @FXML
    public void battle(ActionEvent actionEvent)
    {
        controller.setScreen(start.BattleShips.battleBattleID);
    }
}
