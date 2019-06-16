package ui.blocks;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import ui.MainScreenController;
import ui.page.UIPage;
import ui.page.ProjectFormPage;
import ui.popup.Popup;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TopBarController implements Initializable {

    @FXML private Label uiVersionLabel;
    @FXML private Button uiProjectsBtn;
    @FXML private Button uiNewProjectBtn;
    @FXML private Button uiSettingsBtn;


    private int PIDProjects = 1,
                PIDProjectForm = 2,
                PIDSettings = 3;
    private int activePage = 0;
    private Map<Integer, UIPage> pagesCached = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle rb ){


        uiNewProjectBtn.setOnMousePressed( ev -> {
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