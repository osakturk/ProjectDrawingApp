package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectThumbController implements Initializable {

    @FXML private StackPane uiContainer;
    @FXML private Label uiNameLabel;
    @FXML private ImageView uiImage;

    @Override
    public void initialize(URL url, ResourceBundle rb ){


        uiContainer.setOnMousePressed( ev -> {

        });


    }

    public void setName( String name ){
        uiNameLabel.setText(name);
    }
    public void setImage( Image img ){
        uiImage.setImage( img );
    }

}
