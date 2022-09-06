package home.home2;

import home.home2.Controller.favouritesController;
import home.home2.Controller.manageFridgeController;
import home.home2.Model.Beans.favouritesBean;
import home.home2.Model.Beans.fridgeBean;
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

    private favouritesBean favBean;

    private fridgeBean fridgebean;

    public void setData(fridgeBean fridgebean){
        this.fridgebean = fridgebean;
        name.setText(fridgebean.getIngredientName());
        img.setImage(fridgebean.getIngredientImage());
    }

    public void setData1(favouritesBean favBean) {
        this.favBean = favBean;
        name.setText(favBean.getRecipeName());
        img.setImage(favBean.getRecipeImage());
    }

    public void removeIngredient(ActionEvent event) throws IOException {

        fridgeBean fridgebean = new fridgeBean();
        fridgebean.setIngredientName(name.getText());
        manageFridgeController fridgeController = new manageFridgeController();
        fridgeController.deleteIngredient(fridgebean);

        General2.changeScene(General2.setSource("Fridge2"));
    }

    @FXML
    public void clickRemoveRecipe(MouseEvent event) throws IOException, provideLoginException {

        favouritesBean favBean = new favouritesBean();
        favBean.setRecipeName(name.getText());
        favBean.setRecipeImage(img.getImage());

        favouritesController favController = new favouritesController();
        favController.deleteFromFavourites(favBean);

        General2.changeScene(General2.setSource("Favourite2"));
    }
}
