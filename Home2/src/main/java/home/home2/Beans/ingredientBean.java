package home.home2.Beans;

import javafx.scene.image.Image;

public class ingredientBean {

    String ingredient;
    Image image;

    public ingredientBean(String ingredient){
        this.ingredient = ingredient;
    }

    public ingredientBean(){
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
