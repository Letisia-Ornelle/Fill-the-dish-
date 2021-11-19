package letisiaornelle.com.fillthedish1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import letisiaornelle.com.fillthedish1.model.Recipe;

import java.io.IOException;

public class ItemsController {

    @FXML
    private Label recipeName;

    @FXML
    private ImageView recipeImage;

    private Recipe recipe;

    public void setData( Recipe recipe){
       this.recipe = recipe;
        recipeName.setText(recipe.getName());

        Image image = new Image(getClass().getResourceAsStream(recipe.getImgSrc()));
        recipeImage.setImage(image);
    }

    public void click(MouseEvent mouseEvent) throws IOException {
        MainActivity h = new MainActivity();
        h.changeScene("recipes3.fxml");

    }
}
