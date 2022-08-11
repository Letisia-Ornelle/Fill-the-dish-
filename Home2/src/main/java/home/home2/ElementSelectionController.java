package home.home2;

import home.home2.Model.Beans.fridgeBean;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ElementSelectionController {

    @FXML
    private Button name;
    @FXML
    private ImageView img;


    fridgeBean fridgebean = new fridgeBean();



    public void setData(fridgeBean fridgebean){
        this.fridgebean = fridgebean;
        name.setText(fridgebean.getIngredientName());
        img.setImage(fridgebean.getIngredientImage());

    }

}
