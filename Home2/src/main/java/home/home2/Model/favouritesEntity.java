package home.home2.Model;

import java.util.List;

public class favouritesEntity {

    private static favouritesEntity instance = null;
    private static List<RecipeEntity> favourites;
    private String username;

    public favouritesEntity(List<RecipeEntity> favourites, String username){
        this.favourites = favourites;
        this.username = username;
    }

    public static synchronized favouritesEntity createFavouritesList(List<RecipeEntity> favourites, String username){
        if (instance != null){

        }
        instance = new favouritesEntity(favourites, username);
        return instance;
    }

    public static  favouritesEntity getInstance(){
        if(instance == null){
            //
        }
        return instance;
    }

    public List<RecipeEntity> getUserFavouritesList(){
        return favourites;
    }

    public static RecipeEntity addToFavourites(String name){
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setRecipe(name);

        favourites.add(recipeEntity);

        return recipeEntity;

    }

    public static void removeFromFavourites(RecipeEntity recipeEntity){
        for(RecipeEntity recipe : favourites){
            if(recipe.getRecipe().equals(recipeEntity.getRecipe())){
                favourites.remove(recipeEntity);
            }
        }

    }


}
