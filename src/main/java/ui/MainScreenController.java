package ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {


    private AnchorPane uiSideBar;
    private ScrollPane uiContentContainer;

    public static ScrollPane UICONTENTMAIN;

    @FXML
    private StackPane uiWrapper;
    @FXML private AnchorPane uiContentWrapper;
    @FXML private AnchorPane uiPopupWOverlay;
    @FXML private VBox uiPopup;


    @Override
    public void initialize(URL url, ResourceBundle rb ){
        try {


            SideBar sideBar = new SideBar();
            ContentContainer contentContainer = new ContentContainer();

            sideBar.initUI();
            contentContainer.initUI();

            uiSideBar = sideBar.getUI();
            uiContentContainer = contentContainer.getUI();

            uiContentWrapper.getChildren().add( uiSideBar );
            AnchorPane.setLeftAnchor(uiSideBar, 0.0);
            AnchorPane.setTopAnchor(uiSideBar, 0.0);
            AnchorPane.setBottomAnchor(uiSideBar, 0.0);

            uiContentWrapper.getChildren().add( uiContentContainer );
            AnchorPane.setLeftAnchor(uiContentContainer, 220.0);
            AnchorPane.setRightAnchor(uiContentContainer, 0.0);
            AnchorPane.setTopAnchor(uiContentContainer, 0.0);
            AnchorPane.setBottomAnchor(uiContentContainer, 0.0);




        } catch( Exception e ){
            e.printStackTrace();
        }
    }

    public void screenResizeAction(){
        uiContentWrapper.getScene().heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {

                uiSideBar.setStyle("-fx-pref-height:" + (newSceneHeight.doubleValue()) );
            }
        });
    }

}