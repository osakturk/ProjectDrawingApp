package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

import java.net.URL;
import java.util.ResourceBundle;

public class TopBarController implements Initializable {

    @FXML private Label uiVersionLabel;
    @FXML private Button uiProjectsBtn;
    @FXML private Button uiNewProjectBtn;
    @FXML private Button uiSettingsBtn;

    @FXML private Button uiBackBtn;
    @FXML private Button uiForwardBtn;
    @FXML private Button uiHomeBtn;
    @FXML private Button uiZoomInBtn;
    @FXML private Button uiZoomOutBtn;


    @Override
    public void initialize(URL url, ResourceBundle rb ){


        Tooltip tt = new Tooltip("Test");
        uiBackBtn.setTooltip(tt);


    }

}
