package home.home2.Controller;

import home.home2.Model.*;
import home.home2.Beans.favouritesBean;
import home.home2.Model.DAO.favouritesDAO;
import home.home2.Model.Exceptions.duplicateRecipeException;
import home.home2.Model.Exceptions.provideLoginException;

import java.util.ArrayList;
import java.util.List;

public class favouritesController {

    public  favouritesEntity favouritesList = null;
    private List<RecipeEntity> favourites;
    favouritesDAO favouritesDAO = new favouritesDAO();


    public favouritesController() throws provideLoginException {
        if(user.getInstance().getUser() == null){
            throw new provideLoginException();
        }
        favourites = favouritesDAO.userFavourites(user.getInstance().getUser().getUsername());
        favouritesList = favouritesEntity.createFavouritesList(favourites,user.getInstance().getUser().getUsername());
    }

    public void addToFavourites(favouritesBean favouritesbean) throws duplicateRecipeException {

        for(RecipeEntity recipe : favourites){
            if(recipe.getRecipe().equals(favouritesbean.getRecipeName())){
                throw new duplicateRecipeException("Ingrediente gia esistente nella lista di preferiti");
            }
        }

        RecipeEntity recipeEntity;
        favouritesDAO favouritesDAO = new favouritesDAO();

        recipeEntity = favouritesEntity.getInstance().addToFavourites(favouritesbean.getRecipeName());

        favouritesDAO.insertIntoFavourites(user.getInstance().getUser().getUsername(),recipeEntity);

    }

    public void deleteFromFavourites(favouritesBean favouritesbean){
        favouritesDAO favouritesDAO = new favouritesDAO();
        RecipeEntity recipeEntity = new RecipeEntity(favouritesbean.getRecipeName());

        favouritesEntity.getInstance().removeFromFavourites(recipeEntity);

        favouritesDAO.deleteFromFavourites(user.getInstance().getUser().getUsername(), favouritesbean.getRecipeName());

    }

    public List<favouritesBean> showFavourites(){
        favouritesDAO favouritesDAO = new favouritesDAO();
        List<favouritesBean> favouritesBeans = new ArrayList<>();
        List<RecipeEntity> recipes = favouritesDAO.userFavourites(user.getInstance().getUser().getUsername());

        for(RecipeEntity recipe : recipes){
            favouritesBeans.add(new favouritesBean(recipe.getRecipe(), recipe.getRecipeSrc()));
        }

        // Ok me le stampa in modo coretto !

        /*for(RecipeEntity recipe : user.getInstance().getUser().getFavourites()){
            System.out.println(recipe.getRecipe());
        }

       for(RecipeEntity recipe : favouritesEntity.getInstance().getUserFavouritesList()){
           System.out.println(recipe.getRecipe());
       }*/

        return favouritesBeans;
    }

}
