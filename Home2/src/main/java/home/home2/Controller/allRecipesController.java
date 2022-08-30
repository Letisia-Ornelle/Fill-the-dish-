package home.home2.Controller;

import home.home2.Model.Beans.calculateRecipeBean;
import home.home2.Model.DAO.allRecipesDAO;
import home.home2.Model.RecipeEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class allRecipesController {

    public List<calculateRecipeBean> allRecipes() throws SQLException {

        List<calculateRecipeBean> RecipesBeans = new ArrayList<>();

        allRecipesDAO RecipesDAO = new allRecipesDAO();

        List<RecipeEntity> Recipes = RecipesDAO.getAllRecipes();

        for(RecipeEntity i: Recipes){
            RecipesBeans.add(new calculateRecipeBean(i.getRecipe(),i.getRecipeSrc(),i.getDescrizione(),i.getType()));

        }
        return RecipesBeans;
    }
}
