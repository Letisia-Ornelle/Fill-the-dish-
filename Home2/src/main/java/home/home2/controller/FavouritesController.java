package home.home2.controller;

import home.home2.boundary.FavouritesSendEmailBoundary;
import home.home2.Model.*;
import home.home2.beans.FavouritesBean;
import home.home2.Model.DAO.favouritesDAO;
import home.home2.Model.Exceptions.duplicateRecipeException;
import home.home2.Model.Exceptions.provideLoginException;

import java.util.ArrayList;
import java.util.List;

public class FavouritesController {

     public final favouritesEntity favouritesList ;
     List<RecipeEntity> favourites;


    public FavouritesController() throws provideLoginException {
        favouritesDAO favouritesD = new favouritesDAO();

        if(user.getInstance().getUser() == null){
            throw new provideLoginException();
        }
        favourites = favouritesD.userFavourites(user.getInstance().getUser().getUsername());
        favouritesList = favouritesEntity.createFavouritesList(favourites,user.getInstance().getUser().getUsername());
    }

    public void addToFavourites(FavouritesBean favouritesbean) throws duplicateRecipeException {
        favouritesDAO favouritesD = new favouritesDAO();
        for(RecipeEntity recipe : user.getInstance().getUser().getFavourites()){
            if(recipe.getRecipe().equals(favouritesbean.getRecipeName())){
                throw new duplicateRecipeException("Ingrediente gia esistente nella lista di preferiti");
            }
        }

        RecipeEntity recipeEntity;

        recipeEntity = favouritesEntity.getInstance().addToFavourites(favouritesbean.getRecipeName());

        favouritesD.insertIntoFavourites(user.getInstance().getUser().getUsername(),recipeEntity);

        FavouritesSendEmailBoundary fav = new FavouritesSendEmailBoundary();
        fav.send(favouritesbean);

    }

    public void deleteFromFavourites(FavouritesBean favouritesbean){
        favouritesDAO favouritesD = new favouritesDAO();
        RecipeEntity recipeEntity = new RecipeEntity(favouritesbean.getRecipeName());

        favouritesEntity.getInstance().removeFromFavourites(recipeEntity);

        favouritesD.deleteFromFavourites(user.getInstance().getUser().getUsername(), favouritesbean.getRecipeName());

    }

    public  List<FavouritesBean> showFavourites(){
        favouritesDAO favouritesD = new favouritesDAO();
        List<FavouritesBean> favouritesBeans = new ArrayList<>();
        List<RecipeEntity> recipes = favouritesD.userFavourites(user.getInstance().getUser().getUsername());

        for(RecipeEntity recipe : recipes){
            favouritesBeans.add(new FavouritesBean(recipe.getRecipe(), recipe.getRecipeSrc()));
        }

        return favouritesBeans;
    }

}
