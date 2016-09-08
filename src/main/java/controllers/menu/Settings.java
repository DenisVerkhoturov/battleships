package controllers.menu;

import framework.ScreenController;
import framework.ScreenManager;
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

    ScreenManager controller;

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

    @Override
    public void onShow()
    {
        System.out.println("Screen settings shown");
    }

    @Override
    public void onHide()
    {
        System.out.println("Screen settings hidden");
    }
}
