package ui.page;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ui.projectcanvas.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectFormPageController extends UIPageController implements Initializable {

    @FXML private Label uiTitle;
    @FXML private VBox uiZonesContainer;
    @FXML private VBox uiNodesContainer;
    @FXML private VBox uiPointsContainer;
    @FXML private Button uiLoadXMLBtn;
    @FXML private Button uiProjectSettingsBtn;
    @FXML private Button uiSaveBtn;
    @FXML private Button uiBackBtn;
    @FXML private Button uiHomeBtn;
    @FXML private Button uiForwardBtn;
    @FXML private Button uiZoomInBtn;
    @FXML private Button uiZoomOutBtn;
    @FXML private Button uiPCESensorBtn;
    @FXML private Button uiPCEZoneBtn;
    @FXML private Button uiPCETextBtn;
    @FXML private Button uiPCEImageBtn;
    @FXML private Button uiDeleteBtn;
    @FXML private VBox uiPropertiesContainer;
    @FXML private VBox uiLayersContainer;

    @Override
    public void initialize(URL url, ResourceBundle rb ){

        uiProjectSettingsBtn.setOnMousePressed( ev -> {
            ProjectCanvasProperties props = new ProjectCanvasProperties();
            // @todo add the PCEElem first, and then select that as active layer
            // @todo and load selected layer's properties according to it's type
        });

        uiPCESensorBtn.setOnMousePressed( ev -> {
            PCESensorProperties props = new PCESensorProperties();
        });

        uiPCETextBtn.setOnMousePressed( ev -> {
            PCETextProperties props = new PCETextProperties();
        });

        uiPCEImageBtn.setOnMousePressed( ev -> {
            PCEImageProperties props = new PCEImageProperties();
        });

        uiPCEZoneBtn.setOnMousePressed( ev -> {
            PCEZoneProperties props = new PCEZoneProperties();
        });


    }

    private void setPropertiesContent( Node ui ){
        uiPropertiesContainer.getChildren().clear();
        uiPropertiesContainer.getChildren().add(ui);
    }

}
