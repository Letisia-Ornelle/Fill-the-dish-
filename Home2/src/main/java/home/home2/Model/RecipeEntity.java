package home.home2.Model;

import javafx.scene.image.Image;

import java.util.List;

public class RecipeEntity {

    String id_ricetta;
    String descrizione;
    Image immagine;
    String tipo;
    List<IngredientEntity> ingredients;

    public RecipeEntity(String nomeRicetta, Image imm, String descrizione, String tipologia){
        this.id_ricetta = nomeRicetta;
        this.immagine = imm;
       this.descrizione = descrizione;
        this.tipo = tipologia;

    }

    public void setIngredientList(List<IngredientEntity> ingredients){
        this.ingredients = ingredients;
    }

    public List<IngredientEntity> getIngredientList(){
        return ingredients;
    }

    public String getRecipe(){
        return id_ricetta;
    }

    public void setRecipe( String recipe){
        this.id_ricetta = recipe;
    }

    public String getDescrizione(){ return descrizione;}

    public void setDescrizione(String description){
        this.descrizione = description;
    }

    public Image getRecipeSrc(){ return immagine;}

    public void setRecipeSrc(Image im){ this.immagine = im;}

    public String getType(){ return tipo;}


    public void setType( String tiporicetta){
        this.tipo = tiporicetta;
    }




}
