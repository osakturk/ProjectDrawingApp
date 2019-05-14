package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/res/fxml/test.fxml"));
            Parent content = loader.load();
            primaryStage.setTitle("Project Drawing App");



            //Map<String, Double> resData = Common.calculateAppWindowSize();
            primaryStage.setScene(new Scene(content, 1024, 768 ));

            //stage.getIcons().add(new Image(getClass().getResource("/gpts/res/img/gpts_ico.png").toExternalForm()));
            primaryStage.show();


            MainScreenController controller = loader.getController();
            controller.screenResizeAction();

        } catch( Exception e ){
            e.printStackTrace();
        }
    }

}