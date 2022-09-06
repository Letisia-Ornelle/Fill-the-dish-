package home.home2.Beans;

import javafx.scene.image.Image;

import java.io.InputStream;

public class fridgeBean {

    private String ingredient;
    private Image image;
    private  InputStream ingredientInputStream;

    public fridgeBean(){}

    public fridgeBean(String ingredient, Image image){
        this.ingredient = ingredient;
        this.image = image;
    }

    public InputStream getIngredientInputStream(){
        return ingredientInputStream;
    }

    public void setIngredientInputStream(InputStream ingredientInputStream){
        this.ingredientInputStream = ingredientInputStream;
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