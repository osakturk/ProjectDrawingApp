package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UIPageController  {

    @FXML protected Label uiTitle;

    protected void setTitle( String title ){
        uiTitle.setText( title );
    }

}
