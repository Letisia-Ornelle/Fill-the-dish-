package home.home2;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Home extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 640);
        stage.setResizable(false);
        stage.setTitle("Fill The Dish!");
        stage.setScene(scene);
        stage.show();
    }

    public void setNewScene(String oldFXML, String newFXML) throws IOException {
        //Parent oldPane = FXMLLoader.load(getClass().getResource(oldFXML));
        Parent newPane = FXMLLoader.load(getClass().getResource(newFXML));

        //FadeTransition fadeTransitionOld = new FadeTransition(Duration.seconds(1.5), oldPane);
        //FadeTransition fadeTransitionNew = new FadeTransition(Duration.seconds(1.5), newPane);

        //fadeTransitionOld.setFromValue(1);
        //fadeTransitionOld.setToValue(0);
        //fadeTransitionOld.play();

        //fadeTransitionOld.setOnFinished(event ->{
            stg.getScene().setRoot(newPane);
            //fadeTransitionNew.setFromValue(0);
            //fadeTransitionNew.setToValue(1);
            //fadeTransitionNew.play();
        //});



    }

    /*
    public void addScene(String fxml) throws IOException {

    }
    */

    public static void main(String[] args) {
        launch();
    }
}