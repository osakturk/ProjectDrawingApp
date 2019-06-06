package ui.page;

public class ProjectsPage extends UIPage {

    public ProjectsPage(){
        loadFXML("projects_page");
    }

    @Override
    public ProjectsPageController getController(){
        return (ProjectsPageController)controller;
    }

}
