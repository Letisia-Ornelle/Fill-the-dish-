package home.home2;

import javafx.event.ActionEvent;

import java.io.IOException;

import static home.home2.Home.ps;

public class InsertRecipe2Controller {
    public void clickSearchButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Search2"));

    }

    public void clickAddButton(ActionEvent event) throws IOException {
       // General.changeScene(General.setSource("Review2"));

    }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Login2"));

    }

    public void clickFavouriteButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Favourite2"));

    }

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

    // Da rimuovere
    public void clickInterfaceButton(ActionEvent event) {
    }

    public void clickHomeButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Home2"));
    }

    public void clickBackButton(ActionEvent event) {
    }
}
