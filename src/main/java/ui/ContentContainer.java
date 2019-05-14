package ui;

import javafx.scene.control.ScrollPane;

public class ContentContainer {


    private ScrollPane UI;
    private String fxmlFile = "content_container";
    private ContentContainerController controller;

    public void SideBar(){

    }

    public void initUI(){
        UILoader loader = new UILoader(fxmlFile);
        UI = (ScrollPane)loader.getUI();
        controller = (ContentContainerController)loader.getController();
    }

    public ScrollPane getUI(){
        return UI;
    }
    public ContentContainerController getController(){
        return controller;
    }

}
