package ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {


    @FXML private StackPane uiWrapper;
    @FXML private AnchorPane uiContentWrapper;
    @FXML private VBox uiPopupOverlay;
    @FXML private VBox uiPopup;

    private AnchorPane uiSideBar;
    public static ScrollPane CONTENT_CONTAINER;
    public static StackPane WRAPPER;



    @Override
    public void initialize(URL url, ResourceBundle rb ){
        try {

            SideBar sideBar = new SideBar();
            ContentContainer contentContainer = new ContentContainer();

            sideBar.initUI();
            contentContainer.initUI();

            uiSideBar = (AnchorPane)sideBar.getUI();
            CONTENT_CONTAINER = (ScrollPane)contentContainer.getUI();
            WRAPPER = uiWrapper;

            uiContentWrapper.getChildren().add( uiSideBar );
            AnchorPane.setLeftAnchor(uiSideBar, 0.0);
            AnchorPane.setTopAnchor(uiSideBar, 0.0);
            AnchorPane.setBottomAnchor(uiSideBar, 0.0);

            uiContentWrapper.getChildren().add( CONTENT_CONTAINER );
            AnchorPane.setLeftAnchor(CONTENT_CONTAINER, 220.0);
            AnchorPane.setRightAnchor(CONTENT_CONTAINER, 0.0);
            AnchorPane.setTopAnchor(CONTENT_CONTAINER, 0.0);
            AnchorPane.setBottomAnchor(CONTENT_CONTAINER, 0.0);

            // initalize popup
            Popup.setContent(uiPopup);
            Popup.setOverlay(uiPopupOverlay);


        } catch( Exception e ){
            e.printStackTrace();
        }
    }


    // @todo - debounce the event ??
    public void screenResizeAction(){
        uiContentWrapper.getScene().heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {

                uiSideBar.setStyle("-fx-pref-height:" + (newSceneHeight.doubleValue()) );
            }
        });
    }

}