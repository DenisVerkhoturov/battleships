package scream.battleships.controllers.battle;

import scream.battleships.framework.ControlledScreen;
import scream.battleships.framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import scream.battleships.start.BattleShips;

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
        this.player.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event)
            {
                System.out.println(event);
            }
        });
    }

    @FXML
    public void menu(ActionEvent actionEvent)
    {
        controller.setScreen(BattleShips.menuBattleID);
    }

    @FXML
    public void battle(ActionEvent actionEvent)
    {
        controller.setScreen(BattleShips.battleBattleID);
    }
}
