package letisiaornelle.com.fillthedish1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainActivity extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(MainActivity.class.getResource("recipes.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1280, 640);

        // scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Fill the dish!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
}