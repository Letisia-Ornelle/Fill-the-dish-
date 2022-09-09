package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.beans.IngredientBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home2.ps;

public class Recipe2Controller implements Initializable {

    @FXML
    private Text recipeDescription;

    @FXML
    private Label recipeName;

    @FXML
    private ImageView recipeImg;

    @FXML
    private VBox verticalBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PendentScreen2 ps = Home2.getPS2();

        recipeName.setText(ps.getName());
        recipeImg.setImage(ps.getImage());
        recipeDescription.setText(ps.getDescription());
        System.out.println(ps.getDescription());
        System.out.println(ps.getType());

        CalculateRecipeBean recipeBean = new CalculateRecipeBean();
        recipeBean.setName(recipeName.getText());


        CalculateRecipeController recipeController = new CalculateRecipeController();
        List<IngredientBean> ingredientBeanList = recipeController.getIngredients(recipeBean);

        // Ok devo iterare su questa lista e aggiungere in modo progressivo il coso nel verticalBox

        for(int i=0; i<ingredientBeanList.size();i++){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ingredient.fxml"));

                Pane anchorPane = fxmlLoader.load();

                IngredientController ingredientController = fxmlLoader.getController();
                ingredientController.setData(ingredientBeanList.get(i));

                verticalBox.getChildren().add(anchorPane);
                verticalBox.setMargin(anchorPane, new Insets(2));

            }catch(IOException e){
                e.printStackTrace();
            }

        }

    }

    public void clickHomeButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Home2"));
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
        PendentScreen2 ps = Home2.getPS2();
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }      }
    public void clickReviewButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }

    public void clickFridgeButton(ActionEvent event) throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Fridge2.fxml");
            //System.out.println();
            General2.changeScene(General2.setSource("Login2"));
        }
    }

    public void clickInsertIngredients(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButton(ActionEvent event) throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }

    public void clickBackButton(ActionEvent event) {
    }


}
