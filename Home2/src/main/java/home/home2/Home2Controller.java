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

import static home.home2.Home.ps;

public class Home2Controller implements Initializable {
    public static ArrayList list;
    @FXML
    private GridPane grid ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void clickBackButton() {
        Home m = new Home();
        list = m.getList();
        //System.out.println(General.setSource((String)list.get(list.size() - 2)));

        if (list.size() > 1) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource((String)list.get(list.size() - 2)));
                Pane anchorPane = fxmlloader.load();

                grid.add(anchorPane, 0,0);
                list.remove(list.size()-1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    public void clickHomeButton(ActionEvent event) throws IOException {


    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Search2"));

    }
    public void clickAddButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Add2"));

    }
    public void clickLoginButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Login2"));

    }
    public void clickFavouriteButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Favourite2"));
    }

    // Scrivere un metodo che mi prende in input una stringa e la aggiunge alla griglia ????
    // Si ma perche la griglia dovrebbe essere vuota ????

/*
    public void setData(String  view) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource(view));
        Pane anchorPane = fxmlloader.load();
        grid.add(anchorPane, 0,0);
    }*/

    public void clickFridgeButton(ActionEvent event) throws IOException {
        if (General.loginState) {
            General.changeScene(General.setSource("Fridge2"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("Fridge2.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login2"));
        }
    }
    public void clickReviewButton(ActionEvent event) throws IOException {
       General.changeScene(General.setSource("Review2"));

    }
    public void clickInterfaceButton(ActionEvent event) throws IOException {
        Home.GUI=0;
        General.changeScene(General.setSource("Home"));
    }
}
