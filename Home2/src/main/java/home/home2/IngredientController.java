package home.home2;

import home.home2.Beans.ingredientBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IngredientController {

    @FXML
    private Label ingrediente;

    ingredientBean ingrBean;

    public void setData(ingredientBean ingrBean){
        this.ingrBean = ingrBean;
        ingrediente.setText(ingrBean.getIngredientName());
    }

}
