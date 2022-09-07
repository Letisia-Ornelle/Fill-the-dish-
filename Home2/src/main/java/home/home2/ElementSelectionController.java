package home.home2;

import home.home2.beans.FridgeBean;
import home.home2.model.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;

public class ElementSelectionController {

    @FXML
    private Button name;
    @FXML
    private ImageView img;
    @FXML
    private CheckBox checkBox;


    FridgeBean fridgebean = new FridgeBean();



    public void setData(FridgeBean fridgebean){
        this.fridgebean = fridgebean;
        name.setText(fridgebean.getIngredientName());
        img.setImage(fridgebean.getIngredientImage());

    }

    private static ObservableList<Ingredient> selectedIngredients = FXCollections.observableArrayList();

    public void selectedIng() {

        String ingredientName ;

        if (checkBox.isSelected()){
            ingredientName = name.getText() ;
            selectedIngredients.add(new Ingredient(ingredientName));
        }

    }

    public ObservableList<Ingredient> getFridgeIngredients(){
        return selectedIngredients;
    }
}