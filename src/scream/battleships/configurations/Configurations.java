package scream.battleships.configurations;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.prefs.Preferences;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Configurations
{
    private static Configurations instance;
    Preferences userPreferences;

    private SimpleStringProperty userName;
    private Language language;

    private final ObservableList<Language> languages = FXCollections.observableArrayList();

    private Configurations()
    {
        this.userPreferences = Preferences.userNodeForPackage(getClass());
        this.userName = new SimpleStringProperty(userPreferences.get("user_name", ""));
        this.language = Language.EN;
        this.languages.addAll(Language.values());
    }

    public static Configurations getInstance()
    {
        if (instance == null)
            instance = new Configurations();

        return instance;
    }

    public SimpleStringProperty getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName.set(userName);
    }

    public Language getLanguage()
    {
        return this.language;
    }

    public void setLanguage(Language language)
    {
        this.language = language;
    }

    public ObservableList<Language> getLanguages()
    {
        return this.languages;
    }

    public void save()
    {
        this.userPreferences.put("user_name", this.userName.get());
    }

    /**
     * Перечисление зарегистрированных языков.
     */
    public enum Language
    {
        RU("Русский", "ru"), EN("English", "en");

        private String name;
        private String code;

        Language(String name, String code)
        {
            this.name = name;
            this.code = code;
        }

        public String asCode()
        {
            return this.code;
        }

        @Override
        public String toString()
        {
            return this.name;
        }
    }
}
