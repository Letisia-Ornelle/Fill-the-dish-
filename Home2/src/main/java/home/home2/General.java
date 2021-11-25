package home.home2;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class General {

    public static Boolean loginState = false;
    private static ArrayList list;


    public static String setSource(String newScreen) {
        String tempSrc = newScreen;
        tempSrc += ".fxml";
        return tempSrc;
    }

    public static void changeScene(String nowSource, String newSource) throws IOException {
        int i;
        Home m = new Home();
        list = m.getList();
        list.add(newSource);

        for (i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }

        m.setNewScene(nowSource, newSource);
    }


    public static void setBackScene() throws IOException {
        Home m = new Home();
        list = m.getList();
        if (list.size() > 0) {
            m.setNewScene("Home.fxml", (String)list.get( list.size() - 2 ));
            list.remove(list.size()-1);
        }
    }

}
