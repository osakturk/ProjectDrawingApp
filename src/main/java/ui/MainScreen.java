package ui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class MainScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/main_screen.fxml"));
            Parent content = loader.load();
            primaryStage.setTitle("Project Drawing App");


            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2500),
                    ae -> System.out.println("CUF CUF")));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();

            /** we should define new properties for live sensor data
             * you can get all sensor data from here
             *  we can set some sensor for live data
             *  you can listen from there
             * */
            //Map<String, Double> resData = Common.calculateAppWindowSize();
            primaryStage.setScene(new Scene(content, 1280, 1024 )); // @todo - calculate client's width-height, give offset to that

            //stage.getIcons().add(new Image(getClass().getResource("/gpts/res/img/gpts_ico.png").toExternalForm()));
            primaryStage.show();


            MainScreenController controller = loader.getController();
            controller.screenResizeAction();

        } catch( Exception e ){
            e.printStackTrace();
        }
    }

}