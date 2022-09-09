package home.home2;

import java.io.IOException;


public class InsertRecipe2Controller {
    private static final String LOGIN = "Login2";
    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Search2"));

    }

    public void clickAddButton() throws IOException {
       //

    }

    public void clickLoginButton() throws IOException {
        General2.changeScene(General2.setSource(LOGIN));

    }

    public void clickFavouriteButton() throws IOException {
        PendentScreen2 ps =Home2.getPS2();
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource(LOGIN));
        }
    }

    public void clickFridgeButton() throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps.add("Fridge2.fxml");
            General.changeScene(General.setSource(LOGIN));
        }

    }

    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));

    }

    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickBackButton() {
        //
    }

    public void clickInsertIngredients() throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButton() throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
}
