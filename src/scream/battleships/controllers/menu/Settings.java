package scream.battleships.controllers.menu;

import scream.battleships.framework.ControlledScreen;
import scream.battleships.framework.Direction;
import scream.battleships.framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import scream.battleships.start.BattleShips;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Settings implements ControlledScreen, Initializable
{
    @FXML
    private TextField userNameTextField;
    @FXML
    private ChoiceBox<scream.battleships.configurations.Settings.Language> languageChoiceBox;

    private ResourceBundle resourceBundle;

    ScreensController controller;

    @Override
    public void setScreenParent(ScreensController parent)
    {
        this.controller = parent;
    }

    @FXML
    public void main(ActionEvent actionEvent)
    {
        controller.setScreen(BattleShips.menuMainID, Direction.RIGHT);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.resourceBundle = resources;
        this.languageChoiceBox.getItems().addAll(scream.battleships.configurations.Settings.getInstance().getLanguages());
        this.languageChoiceBox.getSelectionModel().select(scream.battleships.configurations.Settings.getInstance().getLanguage());

        this.languageChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldLanguage, newLanguage) -> scream.battleships.configurations.Settings.getInstance().setLanguage(newLanguage)
        );

        this.userNameTextField.textProperty().bindBidirectional(scream.battleships.configurations.Settings.getInstance().getUserName());
    }
}
