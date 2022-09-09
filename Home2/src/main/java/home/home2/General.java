package home.home2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class General {

    private General(){}

    public static Boolean LOGINSTATE = false ;

    private static List<String> list = new ArrayList<>();


    public static String setSource(String newScreen) {
        String tempSrc = newScreen;
        tempSrc += ".fxml";
        return tempSrc;
    }

    public static void changeScene(String newSource) throws IOException {
        Home m = new Home();
        list = Home.getList();
        list.add(newSource);

        if (newSource.equals("Home.fxml")) {
            list.clear();
            list.add(newSource);
        }

        m.setNewScene(newSource);
    }

    public static void setBackScene() throws IOException {
        Home m = new Home();
        String newScene;

        list = Home.getList();
        if (list.size() > 1) {
            newScene = list.get(list.size() - 2);
            m.setNewScene(newScene);

            if (newScene.equals("Home")) {
                list.clear();
            } else {
                list.remove(list.size()-1);
            }

        }
    }

}
