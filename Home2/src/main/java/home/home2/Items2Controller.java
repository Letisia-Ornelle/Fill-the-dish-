package home.home2;

import home.home2.Beans.calculateRecipeBean;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Items2Controller {
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
    private static PendentScreen2 ps;
    calculateRecipeBean recipe;

    public void clickRecipeIm(MouseEvent mouseEvent) throws IOException {
        Home2 m = new Home2();
        ps = m.getPS2();

        ps.setName(recipeName.getText());
        ps.setImage(recipeImage.getImage());
        ps.setDescription(recipeDescription.getText());

        General2.changeScene(General2.setSource("Recipe2"));
    }

    public void setData(calculateRecipeBean recipe) {
        this.recipe = recipe;
        recipeName.setText(recipe.getName());
        recipeImage.setImage(recipe.getImage());
        recipeDescription.setText(recipe.getDescription());
    }
}
