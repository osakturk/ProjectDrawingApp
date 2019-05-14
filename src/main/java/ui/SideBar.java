package ui;

import javafx.scene.layout.AnchorPane;

public class SideBar {

    private AnchorPane UI;
    private String fxmlFile = "side_bar";
    private SideBarController controller;

    public SideBar(){

    }

    public void initUI(){
        UILoader loader = new UILoader(fxmlFile);
        UI = (AnchorPane)loader.getUI();
        controller = (SideBarController)loader.getController();
    }

    public AnchorPane getUI(){
        return UI;
    }
    public SideBarController getController(){
        return controller;
    }

}