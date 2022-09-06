package home.home2.controller;

import home.home2.beans.CalculateRecipeBean;
import home.home2.beans.IngredientBean;
import home.home2.Model.DAO.calculateRecipeDAO;
import home.home2.Model.Ingredient;
import home.home2.Model.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

public class CalculateRecipeController {



    public List<CalculateRecipeBean> checkIngredients(CalculateRecipeBean recipeBean) {

        List<CalculateRecipeBean> recipesresultBeans = new ArrayList<>();

        calculateRecipeDAO rDao = new calculateRecipeDAO();

        List<RecipeEntity> recipes = rDao.Recipes(recipeBean.getListIng());

        for(RecipeEntity i : recipes ){
            recipesresultBeans.add(new CalculateRecipeBean(i.getRecipe(),i.getDescrizione(),i.getRecipeSrc(),i.getType()));
        }


        return recipesresultBeans; // ritorna una lista di ricette complete (nome..descrizione..)
    }



    public  List<IngredientBean> getIngredients(CalculateRecipeBean recipeBean){

        List<IngredientBean> ingredientBeans = new ArrayList<>();
        List<Ingredient> ingredients = calculateRecipeDAO.RecipesIngredients(recipeBean.getName());

        for(Ingredient ingr : ingredients){
            ingredientBeans.add(new IngredientBean(ingr.getName()));
        }

        return ingredientBeans;

    }



}

