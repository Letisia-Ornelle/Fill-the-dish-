package home.home2;

import home.home2.controller.FavouritesController;
import home.home2.controller.ManageFridgeController;
import home.home2.beans.FavouritesBean;
import home.home2.beans.FridgeBean;
import home.home2.Model.Exceptions.provideLoginException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ElementController2 {

    @FXML
    private Button name;

    @FXML
    private ImageView img;

    @FXML
    private Pane cover;

    private FavouritesBean favBean;

    private FridgeBean fridgebean;

    public void setData(FridgeBean fridgebean){
        this.fridgebean = fridgebean;
        name.setText(fridgebean.getIngredientName());
        img.setImage(fridgebean.getIngredientImage());
    }

    public void setData1(FavouritesBean favBean) {
        this.favBean = favBean;
        name.setText(favBean.getRecipeName());
        img.setImage(favBean.getRecipeImage());
    }

    public void removeIngredient(ActionEvent event) throws IOException {

        FridgeBean fridgebean = new FridgeBean();
        fridgebean.setIngredientName(name.getText());
        ManageFridgeController fridgeController = new ManageFridgeController();
        fridgeController.deleteIngredient(fridgebean);

        General2.changeScene(General2.setSource("Fridge2"));
    }

    @FXML
    public void clickRemoveRecipe(MouseEvent event) throws IOException, provideLoginException {

        FavouritesBean favBean = new FavouritesBean();
        favBean.setRecipeName(name.getText());
        favBean.setRecipeImage(img.getImage());

        FavouritesController favController = new FavouritesController();
        favController.deleteFromFavourites(favBean);

        General2.changeScene(General2.setSource("Favourite2"));
    }
}
