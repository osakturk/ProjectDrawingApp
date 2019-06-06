package ui.projectcanvas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Zone;

import java.net.URL;
import java.util.ResourceBundle;

public class PCEZonePropertiesController implements Initializable{

    @FXML private Label uiNameLabel;
    @FXML private TextField uiNameInput;
    @FXML private Button uiXMLDataBtn;
    @FXML private Label uiXMLDataLabel;
    @FXML private Button uiLinkBtn;
    @FXML private Label uiLinkLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void fillForm( Zone zone ){

    }

}
