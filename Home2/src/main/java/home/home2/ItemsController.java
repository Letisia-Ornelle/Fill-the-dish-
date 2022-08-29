package home.home2;

import home.home2.Model.Beans.calculateRecipeBean;
import home.home2.Model.RecipeEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ItemsController {

    @FXML
    private Button recipeButton;
    @FXML
    private ImageView recipeImage;
    @FXML
    private Hyperlink recipeName;


    private calculateRecipeBean recipe;

    public void clickRecipeImage(MouseEvent mouseEvent) throws IOException {
        General.changeScene(General.setSource("Recipe"));
    }

    public void setData(calculateRecipeBean recipe) {
        this.recipe = recipe;
        recipeName.setText(recipe.getName());

       // Image image = new Image(getClass().getResourceAsStream(recipe.getImgSrc()));
        recipeImage.setImage(recipe.getImage());

    }


}
