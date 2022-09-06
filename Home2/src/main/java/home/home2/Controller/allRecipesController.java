package home.home2.Controller;

import home.home2.Model.Beans.calculateRecipeBean;
import home.home2.Model.DAO.allRecipesDAO;
import home.home2.Model.RecipeEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class allRecipesController {

    public List<calculateRecipeBean> allRecipes() throws SQLException {

        List<RecipeEntity> recipes = allRecipesDAO.getAllRecipes();
        List<calculateRecipeBean> recipeBeans = new ArrayList<>();

        for(RecipeEntity i : recipes){
            recipeBeans.add(new calculateRecipeBean(i.getRecipe(),i.getDescrizione(),i.getRecipeSrc(),i.getType()));
        }
        return recipeBeans;
    }


}
