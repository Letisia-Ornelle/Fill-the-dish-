package home.home2.Model.Beans;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.sql.Blob;

public class calculateRecipeBean {

    String name;
    Image image;
    String description;
    String type;
    ObservableList<String> IngrList;

    public calculateRecipeBean(String name, Image image, String description, String type){
        this.name = name;
        this.image = image;
        this.description = description;
        this.type = type;
    }

    public calculateRecipeBean(){}

    public ObservableList<String> setListIng(ObservableList<String> listOfIngredients){
        this.IngrList = listOfIngredients;
        return listOfIngredients;
    }
    public ObservableList<String> getListIng(){
        return IngrList;
    }

    public void setName(String nome){
        this.name = nome;
    }

    public String getName(){
        return name;

    }

    public void setImage(Image immagine){
        this.image = immagine;
    }

    public Image getImage(){
        return image;
    }
}
