package objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Configurations
{
    private static Configurations instance;
    private SimpleStringProperty userName;
    private Language language;
    private ObservableList<Language> languages = FXCollections.observableArrayList();

    private Configurations()
    {
        this.language = Language.EN;
        this.languages.addAll(Language.values());
    }

    public static Configurations getInstance()
    {
        if (instance == null)
            instance = new Configurations();

        return instance;
    }

    public String getUserName()
    {
        return userName.get();
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
