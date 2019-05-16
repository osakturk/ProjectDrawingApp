package ui;

public class SettingsPage extends UIPage {

    public SettingsPage(){
        loadFXML("settings_page");
    }

    @Override
    public SettingsPageController getController(){
        return (SettingsPageController)controller;
    }


}
