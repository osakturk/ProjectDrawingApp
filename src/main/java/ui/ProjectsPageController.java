package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectsPageController extends UIPageController implements Initializable {

    @FXML private TextField uiSearchInput;
    @FXML private Button uiSearchBtn;

    @FXML private TitledPane uiProjectViewerPane;
    @FXML private TitledPane uiProjectExplorerPane;

    @FXML private Label uiResultsLabel;

    @FXML private FlowPane uiResultsContainer;


    @Override
    public void initialize(URL url, ResourceBundle rb ){


        ProjectSubModule subModuleTest = new ProjectSubModule();



    }

}
