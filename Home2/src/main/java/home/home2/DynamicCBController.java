package home.home2;

import home.home2.Controller.calculateRecipeController;
import home.home2.Model.Beans.calculateRecipeBean;
import home.home2.Model.DAO.calculateRecipeDAO;
import home.home2.Model.Ingredient;
import home.home2.Model.systemFridge;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.InputMethodEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DynamicCBController implements Initializable {
    @FXML
    private ChoiceBox choiceBoxD;

    public void initialize(URL url, ResourceBundle resourceBundle) {


        choiceBoxD.setValue("Inserisci un nuovo ingrediente");

        systemFridge fridge = systemFridge.getInstance();

        ObservableList<Ingredient> ingredients = fridge.getIngredients();

        ObservableList<String> ingredientsString = FXCollections.observableArrayList();
        for (Ingredient i : ingredients) {
            ingredientsString.add(i.getName());
        }

        choiceBoxD.setItems(ingredientsString);


    }


    private static ObservableList<Ingredient> SelectedIngredients = FXCollections.observableArrayList();

    public ObservableList<Ingredient> getValues() {
        for (Ingredient i : SelectedIngredients) {
            // System.out.println(i);
        }

        return SelectedIngredients;
    }

    public void getChoiceBoxValue(ActionEvent event) throws IOException {

        System.out.println("Eccomi");
        String ingrediente = (String) choiceBoxD.getValue();

        systemFridge fridge = systemFridge.getInstance();

        ObservableList<Ingredient> ingredients = fridge.getIngredients();

        for (Ingredient i : ingredients) {
            if (ingrediente.equals(i.getName())) {
                SelectedIngredients.add(new Ingredient(ingrediente));
            }
        }

    }
}




