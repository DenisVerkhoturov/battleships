package controllers.menu;

import framework.ScreenController;
import framework.ScreensManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Settings extends ScreenController implements Initializable
{
    @FXML
    private TextField userNameTextField;
    @FXML
    private ChoiceBox<configurations.Settings.Language> languageChoiceBox;

    private ResourceBundle resourceBundle;

    ScreensManager controller;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.resourceBundle = resources;
        this.languageChoiceBox.getItems().addAll(configurations.Settings.getInstance().getLanguages());
        this.languageChoiceBox.getSelectionModel().select(configurations.Settings.getInstance().getLanguage());

        this.languageChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldLanguage, newLanguage) -> configurations.Settings.getInstance().setLanguage(newLanguage)
        );

        this.userNameTextField.textProperty().bindBidirectional(configurations.Settings.getInstance().getUserName());
    }
}
