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
    public static ArrayList list;
    public static List<Element> Elements = new ArrayList<>();
    // esempio lista di piatti inseriti nella lista dei preferiti
    public static String[] piatti = {"Pasta alla carbonara", "Pasta al tonno", "Pasta al sugo", "Pasta ai funghi"};

    public static void addElement() {
            // ee
    }

    public static void removeEl(String string) {
        int k=0;
        for (int i=0;i<piatti.length;i++) {
            if (piatti[i].equals(string)) {
                k++;
            }

            if (k>=piatti.length) {
                piatti[i] = "";
            } else {
                piatti[i] = piatti[k];
            }


            k++;
        }

    }

    public static String setSource(String newScreen) {
        String tempSrc = newScreen;
        tempSrc += ".fxml";
        return tempSrc;
    }

    public static void changeScene(String newSource) throws IOException {
        int i;
        Home m = new Home();
        list = m.getList();
        list.add(newSource);

        if (newSource.equals("Home.fxml")) {
            list.clear();
            list.add(newSource);
        }

        if (newSource.equals("Home2.fxml")) {
            list.clear();
            list.add("Main2.fxml");
        }

        m.setNewScene(newSource);
    }


    public static void setBackScene() throws IOException {
        Home m = new Home();
        String newScene;

        list = m.getList();
        if (list.size() > 1) {
            newScene = (String)list.get(list.size() - 2);
            m.setNewScene(newScene);

            if (newScene == "Home") {
                list.clear();
            } else {
                list.remove(list.size()-1);
            }


        }
    }

}
