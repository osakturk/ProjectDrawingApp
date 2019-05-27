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


    @FXML private StackPane uiWrapper;
    @FXML private AnchorPane uiContentWrapper;
    @FXML private VBox uiPopupOverlay;
    @FXML private VBox uiPopup;

    //private AnchorPane uiSideBar;
    private AnchorPane uiTopBar;
    private AnchorPane uiAlarmBar;
    public static ScrollPane CONTENT_CONTAINER;
    public static StackPane WRAPPER;



    @Override
    public void initialize(URL url, ResourceBundle rb ){
        try {

            //SideBar sideBar = new SideBar();
            TopBar topBar = new TopBar();
            AlarmBar alarmBar = new AlarmBar();
            ContentContainer contentContainer = new ContentContainer();
            topBar.initUI();
            alarmBar.initUI();
            contentContainer.initUI();

            uiTopBar = (AnchorPane)topBar.getUI();
            uiAlarmBar = (AnchorPane)alarmBar.getUI();
            CONTENT_CONTAINER = (ScrollPane)contentContainer.getUI();
            WRAPPER = uiWrapper;

            uiContentWrapper.getChildren().add( uiTopBar );
            AnchorPane.setLeftAnchor(uiTopBar, 0.0);
            AnchorPane.setTopAnchor(uiTopBar, 0.0);
            AnchorPane.setRightAnchor(uiTopBar, 0.0);

            uiContentWrapper.getChildren().add( uiAlarmBar );
            AnchorPane.setLeftAnchor(uiAlarmBar, 0.0);
            AnchorPane.setTopAnchor(uiAlarmBar, 80.0);
            AnchorPane.setRightAnchor(uiAlarmBar, 0.0);

            uiContentWrapper.getChildren().add( CONTENT_CONTAINER );
            AnchorPane.setLeftAnchor(CONTENT_CONTAINER, 0.0);
            AnchorPane.setRightAnchor(CONTENT_CONTAINER, 0.0);
            AnchorPane.setTopAnchor(CONTENT_CONTAINER, 150.0);
            AnchorPane.setBottomAnchor(CONTENT_CONTAINER, 0.0);

            // initalize popup
            Popup.initialize( uiPopupOverlay, uiPopup );


        } catch( Exception e ){
            e.printStackTrace();
        }
    }


    // @todo - debounce the event ??
    public void screenResizeAction(){
        /*uiContentWrapper.getScene().heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {

                uiSideBar.setStyle("-fx-pref-height:" + (newSceneHeight.doubleValue()) );
            }
        });*/
    }

}