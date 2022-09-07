package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.controller.ManageFridgeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.beans.FridgeBean;
import home.home2.model.Ingredient;
import home.home2.model.FridgeObserver;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class SelectIngredients2Controller implements Initializable, FridgeObserver {

    private static PendentScreen2 ps;

    @FXML
    private VBox verticalBox;

    private static List<CalculateRecipeBean> recipeBeans = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Home2 m = new Home2();
        ps = m.getPS2();

        ManageFridgeController fridgeController = new ManageFridgeController();
        List<FridgeBean> fridgeBeans;
        fridgeBeans = fridgeController.showFridge();

        for(int i = 0; i<fridgeBeans.size(); i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ElementFridgeSelection2.fxml"));
                Pane anchorPane = fxmlLoader.load();

                ElementSelection2Controller selection2Controller = fxmlLoader.getController();
                selection2Controller.setData(fridgeBeans.get(i));

                verticalBox.getChildren().add(anchorPane);
                verticalBox.setMargin(anchorPane, new Insets(5));

            }catch(IOException e){
                e.printStackTrace();

        }
    }


    }

    public List<CalculateRecipeBean> getRecipesBeans(){
        return recipeBeans;
    }


    public void clickRecipesButton(ActionEvent event) throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }

    public void ClickRecipe(ActionEvent event) throws IOException {
        ps.setScreen2("3");
        ElementSelection2Controller elementController = new ElementSelection2Controller();

        CalculateRecipeController recipeController = new CalculateRecipeController();
        CalculateRecipeBean recipeBean = new CalculateRecipeBean();

        ObservableList<Ingredient> fridgeIngredients = elementController.getFridgeIngredients();

        recipeBean.setListIng(fridgeIngredients);

        recipeBeans =  recipeController.checkIngredients(recipeBean);
        General2.changeScene(General2.setSource("Result2"));

    }

    @Override
    public void update(FridgeBean fridgebean) {

    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Search2"));
    }

    public void clickAddButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Add2"));
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
        }      }

    public void clickFridgeButton(ActionEvent event) throws IOException {
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Fridge2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }
    }

    public void clickReviewButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }

    public void clickBackButton(ActionEvent event) {
        //General2.changeScene(General2.setSource());
    }

    public void clickHomeButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickInsertIngredients(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }
}
