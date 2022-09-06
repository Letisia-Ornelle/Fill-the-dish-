package home.home2;

import home.home2.controller.FavouritesController;
import home.home2.beans.FavouritesBean;
import home.home2.Model.Exceptions.provideLoginException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home2.ps;

public class Favourite2Controller implements Initializable {

    @FXML
    private VBox verticalBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i;


        List<FavouritesBean> favouritesBeans;

        FavouritesController favController = null;
        try {
            favController = new FavouritesController();
        } catch (provideLoginException e) {
            e.printStackTrace();
        }

        favouritesBeans = favController.showFavourites();

        try {
            for (i=0;i<favouritesBeans.size();i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("ListElement2.fxml"));
                Pane anchorPane = fxmlloader.load();

                ElementController2 elementController = fxmlloader.getController();
                elementController.setData1(favouritesBeans.get(i));

                verticalBox.getChildren().add(anchorPane);
                verticalBox.setMargin(anchorPane, new Insets(5));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clickReviewButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Review2"));

    }

    public void clickFridgeButton(ActionEvent event) throws IOException {
        if (General2.loginState) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Fridge2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }

    }

    public void clickFavouriteButton(ActionEvent event) {
        // No
    }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Login2"));

    }

    public void clickAddButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Add2"));

    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Home2"));

    }

    public void clickHomeButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Home2"));

    }

    public void clickBackButton(ActionEvent event) {
    }

    public void clickInsertIngredients(ActionEvent event) {
    }

    public void clickRecipesButton(ActionEvent event) throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
}
