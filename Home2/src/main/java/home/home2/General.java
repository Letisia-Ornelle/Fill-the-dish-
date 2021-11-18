package home.home2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class General {

    public static Boolean loginState = false;
    //private static ScreenList list = new ScreenList();

    public static String setSource(String newScreen) {
        String tempSrc = newScreen;
        tempSrc += ".fxml";
        return tempSrc;
    }

    public static void changeScene(String source) throws IOException {
        Home m = new Home();
        //list.appendScreen(source);
        m.setNewScene(source);
    }

    /*
    public static String getBackScene() throws IOException {
        //return list.getPrev().getContent();
    }
    */
}
