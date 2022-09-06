package home.home2;

import home.home2.Model.Ingredient;
import home.home2.Model.systemFridge;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DynamicCB2Controller implements Initializable {

    @FXML
    private ChoiceBox choiceBox;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.setValue("Inserisci un nuovo ingrediente");

        systemFridge fridge = systemFridge.getInstance();

        ObservableList<Ingredient> ingredients = fridge.getIngredients();

        ObservableList<String> ingredientsString = FXCollections.observableArrayList();
        for (Ingredient i : ingredients) {
            ingredientsString.add(i.getName());
        }

        choiceBox.setItems(ingredientsString);


    }


    private static final ObservableList<Ingredient> SelectedIngredients =FXCollections.observableArrayList();

    public ObservableList<Ingredient> getValues() {
        return SelectedIngredients;
    }

    public void getChoiceBoxValue(ActionEvent event) throws IOException {

        System.out.println("Eccomi");
        String ingrediente = (String) choiceBox.getValue();

        systemFridge fridge = systemFridge.getInstance();

        ObservableList<Ingredient> ingredients = fridge.getIngredients();

        for (Ingredient i : ingredients) {
            if (ingrediente.equals(i.getName())) {
                SelectedIngredients.add(new Ingredient(ingrediente));
            }
        }

    }

}

