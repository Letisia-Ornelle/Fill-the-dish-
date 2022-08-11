package home.home2.Model.Beans;

import javafx.scene.image.Image;

import java.util.List;

public class ingredientBean {

    String ingredient;

    List<String> ingredientList ;

    Image image;
    /*
    public List<String> getIngredientList(){
        return ingredientList;
    }

    public void setIngredientList(String ingr){
        this.ingredientList.add(ingr);
    }*/

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
