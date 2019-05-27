package ui.page;

public class ProjectFormPage extends UIPage {

    public ProjectFormPage(){
        loadFXML("project_form_page");
    }

    @Override
    public ProjectFormPageController getController(){
        return (ProjectFormPageController)controller;
    }

}
