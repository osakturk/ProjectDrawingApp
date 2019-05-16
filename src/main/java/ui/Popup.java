package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Popup {

    private static VBox popupOverlay;
    private static VBox content;


    public static void show(){
        MainScreenController.WRAPPER.getChildren().setAll(reverseElems());
    }

    public static void hide(){
        MainScreenController.WRAPPER.getChildren().setAll(reverseElems());
    }

    private static ObservableList<Node> reverseElems(){
        ObservableList<Node> prevList = MainScreenController.WRAPPER.getChildren();
        ObservableList<Node> newList = FXCollections.observableArrayList();
        newList.add(0, prevList.get(1) );
        newList.add(1, prevList.get(0) );
        return newList;
    }

    public static void setContent( VBox _content ){
        content = _content;
    }
    public static void setOverlay( VBox _overlay ){
        popupOverlay = _overlay;
    }

}
