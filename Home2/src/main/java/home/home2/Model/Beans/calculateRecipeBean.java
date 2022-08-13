package home.home2.Model.Beans;

import javafx.collections.ObservableList;

import java.sql.Blob;

public class calculateRecipeBean {

    String name;
    Blob image;
    ObservableList<String> IngrList;

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

    public void setImage(Blob immagine){
        this.image = immagine;
    }

    public Blob getImage(){
        return image;
    }
}
