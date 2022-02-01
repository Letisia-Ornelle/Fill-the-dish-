package home.home2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Home2Controller implements Initializable {
    public static ArrayList list;
    @FXML
    private GridPane grid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("Main2.fxml"));
            Pane anchorPane = fxmlloader.load();

            grid.add(anchorPane, 0,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickBackButton() {
        Home m = new Home();
        list = m.getList();

        if (list.size() > 1) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource(General.setSource((String)list.get(list.size() - 2))));
                Pane anchorPane = fxmlloader.load();

                grid.add(anchorPane, 0,0);
                list.remove(list.size()-1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void clickHomeButton() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("Main2.fxml"));
            Pane anchorPane = fxmlloader.load();

            grid.add(anchorPane, 0,0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Home m = new Home();
        list = m.getList();
        list.clear();
        list.add("Main2.fxml");
    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("Search2.fxml"));
            Pane anchorPane = fxmlloader.load();

            grid.add(anchorPane, 0,0);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Home m = new Home();
        list = m.getList();
        list.add("Search2.fxml");
    }
    public void clickAddButton(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("Add2.fxml"));
            Pane anchorPane = fxmlloader.load();

            grid.add(anchorPane, 0,0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Home m = new Home();
        list = m.getList();
        list.add("Add2.fxml");
    }
    public void clickLoginButton(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("Login2.fxml"));
            Pane anchorPane = fxmlloader.load();

            grid.add(anchorPane, 0,0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Home m = new Home();
        list = m.getList();
        list.add("Login2.fxml");
    }
    public void clickFavouriteButton(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("Favourite2.fxml"));
            Pane anchorPane = fxmlloader.load();

            grid.add(anchorPane, 0,0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Home m = new Home();
        list = m.getList();
        list.add("Favourite2.fxml");
    }
    public void clickFridgeButton(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("Fridge2.fxml"));
            Pane anchorPane = fxmlloader.load();

            grid.add(anchorPane, 0,0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Home m = new Home();
        list = m.getList();
        list.add("Fridge2.fxml");
    }
    public void clickReviewButton(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("Review2.fxml"));
            Pane anchorPane = fxmlloader.load();

            grid.add(anchorPane, 0,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Home m = new Home();
        list = m.getList();
        list.add("Review2.fxml");

    }
    public void clickInterfaceButton(ActionEvent event) throws IOException {
        Home.GUI=0;
        General.changeScene(General.setSource("Home"));
    }
}
