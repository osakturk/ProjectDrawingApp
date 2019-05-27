package ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@Deprecated
public class SideBarController implements Initializable {

    @FXML private HBox uiProjectsBtn;
    @FXML private HBox uiProjectFormBtn;
    @FXML private HBox uiLogsBtn;

    @FXML private Label uiProjectLabel;
    @FXML private Label uiProjectFormLabel;
    @FXML private Label uiLogsLabel;

    private int PIDProjects = 1,
                PIDProjectForm = 2,
                PIDLogsForm = 3;
    private int activePage = 0;
    private Map<Integer, UIPage> pagesCached = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle rb ){

        // @todo - permission checks for navigation menu
        uiProjectsBtn.setOnMousePressed( ev -> {
            if( !checkPageInitied( PIDProjects ) ){
                Popup.showLoader();
                Thread load = new Thread( () -> {
                    ProjectsPage projectsPage = new ProjectsPage();
                    projectsPage.getController().setTitle("Projects"); // @todo language
                    pagesCached.put(PIDProjects, projectsPage);
                    loadPage(PIDProjects, projectsPage);
                });
                load.setDaemon(true);
                load.start();
            } else {
                loadPageFromCache( PIDProjects );
            }
        });

        uiProjectFormBtn.setOnMousePressed( ev -> {
            if( !checkPageInitied( PIDProjectForm ) ){
                Popup.showLoader();
                Thread load = new Thread( () -> {
                    ProjectFormPage projectFormPage = new ProjectFormPage();
                    projectFormPage.getController().setTitle("New Project Form"); // @todo language
                    pagesCached.put(PIDProjectForm, projectFormPage);
                    loadPage(PIDProjectForm, projectFormPage );
                });
                load.setDaemon(true);
                load.start();
            } else {
                loadPageFromCache( PIDProjectForm );
            }
        });

    }

    private boolean checkPageInitied( int pageID ){
        return pagesCached.containsKey(pageID);
    }

    private void loadPageFromCache( int pageID ){
        if( activePage == pageID ) return;
        MainScreenController.CONTENT_CONTAINER.setContent( pagesCached.get(pageID).getUI() );
        activePage = pageID;
    }

    private void loadPage( int pageID, UIPage pageObject ){
        Platform.runLater( () -> {
            MainScreenController.CONTENT_CONTAINER.setContent(pageObject.getUI());
            activePage = pageID;
            Popup.hide();
        });
    }

}
