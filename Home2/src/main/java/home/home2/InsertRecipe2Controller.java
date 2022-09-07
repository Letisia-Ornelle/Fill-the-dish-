package home.home2;

import javafx.event.ActionEvent;

import java.io.IOException;

import static home.home2.Home2.ps;

public class InsertRecipe2Controller {
    public void clickSearchButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Search2"));

    }

    public void clickAddButton(ActionEvent event) throws IOException {
       // General.changeScene(General.setSource("Review2"));

    }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Login2"));

    }

    public void clickFavouriteButton(ActionEvent event) throws IOException {
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }
    }

    public void clickFridgeButton(ActionEvent event) throws IOException {
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Fridge2.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login2"));
        }

    }

    public void clickReviewButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Review2"));

    }

    public void clickHomeButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickBackButton(ActionEvent event) {
    }

    public void clickInsertIngredients(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButton(ActionEvent event) throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
}
