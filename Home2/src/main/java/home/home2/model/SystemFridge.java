package home.home2.Model;

import home.home2.Model.DAO.calculateRecipeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class systemFridge {

    public static ObservableList<Ingredient> ingredients = FXCollections.observableArrayList();

    private static systemFridge instance = null;

    public static synchronized systemFridge getInstance(){
        if(instance == null){
            instance = new systemFridge();
        }
        return instance;
    }

    private systemFridge(){
        this.ingredients = calculateRecipeDAO.ingredients();
    }

    public ObservableList<Ingredient> getIngredients() {
        return ingredients;
    }

}
