package home.home2.Beans;

import home.home2.Model.Ingredient;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.List;

public class calculateRecipeBean {

    String name;
    Image image;
    String description;
    ObservableList<Ingredient> IngrList ;
    String type;


    public calculateRecipeBean(String name, String description, Image image,String type){
        this.name = name;
        this.description = description;
        this.image = image;
        this.type = type;
    }

    public calculateRecipeBean(){}


    public List<Ingredient> setListIng(ObservableList<Ingredient> listOfIngredients){
        this.IngrList = listOfIngredients;
        return listOfIngredients;
    }
    public ObservableList<Ingredient> getListIng(){
        return IngrList;
    }

    public void setName(String nome){
        this.name = nome;
    }

    public String getName(){
        return name;

    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;

    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;

    }

    public void setImage(Image immagine){
        this.image = immagine;
    }

    public Image getImage(){
        return image;
    }
}
