package home.home2.Controller;

import home.home2.Model.Beans.calculateRecipeBean;
import home.home2.Model.Beans.calculateRecipeBean;
import home.home2.Model.Beans.ingredientBean;
import home.home2.Model.DAO.calculateRecipeDAO;
import home.home2.Model.DAO.calculateRecipeDAO;
import home.home2.Model.Ingredient;
import home.home2.Model.RecipeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class calculateRecipeController {



    public List<calculateRecipeBean> checkIngredients(calculateRecipeBean RecipeBean) {

        List<calculateRecipeBean> recipesresultBeans = new ArrayList<>();

        calculateRecipeDAO Rdao = new calculateRecipeDAO();

        List<RecipeEntity> recipes = Rdao.Recipes(RecipeBean.getListIng());

        for(RecipeEntity i : recipes ){
            recipesresultBeans.add(new calculateRecipeBean(i.getRecipe(),i.getDescrizione(),i.getRecipeSrc(),i.getType()));
        }


        return recipesresultBeans; // ritorna una lista di ricette complete (nome..descrizione..)
    }



    public  List<ingredientBean> getIngredients(calculateRecipeBean recipeBean){

        List<ingredientBean> ingredientBeans = new ArrayList<>();
        List<Ingredient> ingredients = calculateRecipeDAO.RecipesIngredients(recipeBean.getName());

        for(Ingredient ingr : ingredients){
            ingredientBeans.add(new ingredientBean(ingr.getName()));
        }

        return ingredientBeans;

    }



}

