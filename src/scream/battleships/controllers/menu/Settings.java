package scream.battleships.controllers.menu;

import scream.battleships.framework.ControlledScreen;
import scream.battleships.framework.ScreensController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import scream.battleships.configurations.Configurations;
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
    private ChoiceBox<Configurations.Language> languageChoiceBox;

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
        controller.setScreen(BattleShips.menuMainID);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.resourceBundle = resources;
        this.languageChoiceBox.getItems().addAll(Configurations.getInstance().getLanguages());
        this.languageChoiceBox.getSelectionModel().select(Configurations.getInstance().getLanguage());

        this.languageChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Configurations.Language>()
        {
            @Override
            public void changed(ObservableValue<? extends Configurations.Language> observable, Configurations.Language oldValue, Configurations.Language newValue)
            {
                Configurations.getInstance().setLanguage(newValue);
            }
        });

        this.userNameTextField.textProperty().bindBidirectional(Configurations.getInstance().getUserName());
    }
}
