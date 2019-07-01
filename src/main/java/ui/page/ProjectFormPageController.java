package ui.page;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import ui.projectcanvas.*;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProjectFormPageController extends UIPageController implements Initializable {

    @FXML private AnchorPane uiWorkSpace;
    @FXML private Label uiTitle;
    @FXML private VBox uiZonesContainer;
    @FXML private VBox uiNodesContainer;
    @FXML private VBox uiPointsContainer;
    @FXML private Button uiLoadXMLBtn;
    @FXML private Button uiProjectSettingsBtn;
    @FXML private Button uiSaveBtn;
    @FXML private Button uiUploadBackground;
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
            setPropertiesContent(props.getUI());
        });

        uiPCESensorBtn.setOnMousePressed( ev -> {
            PCESensorProperties props = new PCESensorProperties();
            setPropertiesContent(props.getUI());
        });

        uiPCETextBtn.setOnMousePressed( ev -> {
            PCETextProperties props = new PCETextProperties();
            setPropertiesContent(props.getUI());
        });

        uiPCEImageBtn.setOnMousePressed( ev -> {
            PCEImageProperties props = new PCEImageProperties();
            setPropertiesContent(props.getUI());
        });

        uiPCEZoneBtn.setOnMousePressed( ev -> {
            PCEZoneProperties props = new PCEZoneProperties();
            setPropertiesContent(props.getUI());
        });

        uiUploadBackground.setOnMousePressed( ev -> {
            uploadBackground();
        });

    }

    private void setPropertiesContent( Node ui ){
        uiPropertiesContainer.getChildren().clear();
        uiPropertiesContainer.getChildren().add(ui);
    }

    private void uploadBackground(){
        FileChooser fileChooser = new FileChooser();

        //Prompt user to select a file
        File file = fileChooser.showOpenDialog(null);
        System.out.println(file);
        BackgroundImage image = new BackgroundImage(new Image(file.toURI().toString()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        uiWorkSpace.setBackground(new Background(image));

    }

}
