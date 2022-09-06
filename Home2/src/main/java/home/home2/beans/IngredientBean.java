package home.home2.beans;

import javafx.scene.image.Image;

public class IngredientBean {

    String ingredient;
    Image image;

    public IngredientBean(String ingredient){
        this.ingredient = ingredient;
    }

    public IngredientBean(){
    }

    public void setIngredientName(String ingr){
        this.ingredient = ingr;
    }

    public String getIngredientName(){
        return ingredient;
    }

    public void setIngredientImage(Image img){
        this.image = img;
    }

    public Image getIngredientImage(){
        return image;
    }
}
