package home.home2;

import java.io.IOException;
import java.util.ArrayList;

public class General {

    public static Boolean loginState = false;
    public static ArrayList list;


    public static String setSource(String newScreen) {
        String tempSrc = newScreen;
        tempSrc += ".fxml";
        return tempSrc;
    }

    public static void changeScene(String newSource) throws IOException {
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
