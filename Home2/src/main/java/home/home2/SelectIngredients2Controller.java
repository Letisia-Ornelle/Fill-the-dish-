package home.home2;

import home.home2.Controller.calculateRecipeController;
import home.home2.Controller.manageFridgeController;
import home.home2.Beans.calculateRecipeBean;
import home.home2.Beans.fridgeBean;
import home.home2.Model.Ingredient;
import home.home2.Model.fridgeObserver;
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



public class SelectIngredients2Controller implements Initializable, fridgeObserver {

    private static PendentScreen2 ps;

    @FXML
    private VBox verticalBox;

    private static List<calculateRecipeBean> recipeBeans = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Home2 m = new Home2();
        ps = m.getPS2();

        manageFridgeController fridgeController = new manageFridgeController();
        List<fridgeBean> fridgeBeans;
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

    public List<calculateRecipeBean> getRecipesBeans(){
        return recipeBeans;
    }


    public void clickRecipesButton(ActionEvent event) throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }

    public void ClickRecipe(ActionEvent event) throws IOException {
        System.out.println("ciao!!!!");
        ps.setScreen2("3");
        ElementSelection2Controller elementController = new ElementSelection2Controller();

        calculateRecipeController recipeController = new calculateRecipeController();
        calculateRecipeBean recipeBean = new calculateRecipeBean();

        ObservableList<Ingredient> FridgeIngredients = elementController.getFridgeIngredients();

        recipeBean.setListIng(FridgeIngredients);

        recipeBeans =  recipeController.checkIngredients(recipeBean);
        General2.changeScene(General2.setSource("Result2"));

    }

    @Override
    public void update(fridgeBean fridgebean) {

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
        if (General2.loginState) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }      }

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
