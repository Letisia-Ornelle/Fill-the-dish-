package home.home2;

import home.home2.Model.Beans.fridgeBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ElementController2 {

    @FXML
    private Button name;

    @FXML
    private ImageView img;

    private fridgeBean fridgebean;

    public void setData(fridgeBean fridgebean){
        this.fridgebean = fridgebean;
        name.setText(fridgebean.getIngredientName());
        img.setImage(fridgebean.getIngredientImage());
    }

    public void removeIngredient(ActionEvent event) {
    }
}
