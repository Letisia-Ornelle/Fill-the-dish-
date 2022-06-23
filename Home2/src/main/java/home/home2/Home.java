package home.home2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Home extends Application {
    private static Stage stg;
    private static ArrayList screenList;
    public static PendentScreen ps;
    public static int GUI=0;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;

        ArrayList list = new ArrayList();
        list.add("Home.fxml");              // potrebbe dare bug se la app si apre in una schermata diversa dalla home
        screenList = list;

        PendentScreen pendentScreen = new PendentScreen();
        ps = pendentScreen;

        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 640);
        stage.setResizable(false);
        stage.setTitle("Fill The Dish!");
        stage.setScene(scene);
        stage.show();
    }

    public static ArrayList getList() {
        return screenList;
    }
    public static PendentScreen getPS() {
        return ps;
    }

    public void setNewScene(String newFXML) throws IOException {
        Parent newPane = FXMLLoader.load(getClass().getResource(newFXML));
       stg.getScene().setRoot(newPane);
    }

    public static void main(String[] args) {
        launch();
    }
}