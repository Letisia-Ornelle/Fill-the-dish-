package home.home2;


import home.home2.Beans.calculateRecipeBean;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ItemsController {

    @FXML
    private Button recipeButton;
    @FXML
    private ImageView recipeImage;
    @FXML
    private Label recipeName;
    @FXML
    private Label recipeDescription;
    @FXML
    private Label recipeType;
    private static PendentScreen ps;

    calculateRecipeBean recipe;


    public void clickRecipeImage(MouseEvent mouseEvent) throws IOException {
        Home m = new Home();
        ps = m.getPS();

        ps.setName(recipeName.getText());
        ps.setImage(recipeImage.getImage());
        ps.setDescription(recipeDescription.getText());

        General.changeScene(General.setSource("Recipe"));
    }


    public void setData(calculateRecipeBean recipe) {
        this.recipe = recipe;
        recipeName.setText(recipe.getName());
        recipeImage.setImage(recipe.getImage());
        recipeDescription.setText(recipe.getDescription());
    }


}
