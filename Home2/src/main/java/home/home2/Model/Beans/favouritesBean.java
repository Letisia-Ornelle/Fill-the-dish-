package home.home2.Model.Beans;

import javafx.scene.image.Image;

public class favouritesBean {

    String recipeName;
    Image recipeImage;

    public favouritesBean(){}

    public favouritesBean(String recipeName, Image recipeImage){
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Image getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(Image recipeImage) {
        this.recipeImage = recipeImage;
    }
}
