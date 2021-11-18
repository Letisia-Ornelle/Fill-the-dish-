package home.home2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    public void setNewScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    /*
    public void addScene(String fxml) throws IOException {

    }
    */

    public static void main(String[] args) {
        launch();
    }
}