package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.model.Ingredient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home2.ps;

public class InsertIngredients2Controller implements Initializable {

    private static PendentScreen2 ps2;

    @FXML
    private GridPane grid;

    private static DynamicCB2Controller choiceBox2Controller ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int column = 0 ;
        int row  = 1;

        ps2 = Home2.getPS2();

        try {

            for(int i=0;i<22;i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("dynamicCB2.fxml"));

                Pane pane = fxmlLoader.load();
                choiceBox2Controller = fxmlLoader.getController();


                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                // set grid height
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                grid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(50));
                grid.setAlignment(Pos.CENTER);
                GridPane.setHalignment(pane, HPos.CENTER);
                grid.setGridLinesVisible(false);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Search2"));
    }

    public void clickAddButton() throws IOException {
        General2.changeScene((General2.setSource("Add2")));
    }

    public void clickLoginButton() throws IOException {
        General2.changeScene((General2.setSource("Login2")));
    }

    public void clickFavouriteButton() throws IOException {
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            Home2 m = new Home2();
            ps2 = m.getPS2();
            ps2.add("Favourite2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }    }

    public void clickFridgeButton() throws IOException {
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            ps2 = Home2.getPS2();
            ps2.add("Fridge2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }

    }

    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }



    public void clickInsertIngredients() throws IOException {
       //
    }

    public void clickRecipesButton() throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }

    public void clickFridge() throws IOException {
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("SelectIngredients2"));
        } else {
            ps2 = Home2.getPS2();
            ps2.add("SelectIngredients2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }
    }

    private static List<CalculateRecipeBean> recipeBeans2 = new ArrayList<>();

    public List<CalculateRecipeBean> getRecipes(){
        return recipeBeans2;
    }

    public void clickRecipe() throws IOException {

        ps2.setScreen2("2");

        ObservableList<Ingredient> ingredients;
        ingredients = choiceBox2Controller.getValues();

        CalculateRecipeBean recipeBean = new CalculateRecipeBean();
        recipeBean.setListIng(ingredients);

        CalculateRecipeController recipeController = new CalculateRecipeController();

        recipeBeans2 = recipeController.checkIngredients(recipeBean);

        General2.changeScene(General2.setSource("Result2"));

    }

    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickBackButton() {
    }
}
