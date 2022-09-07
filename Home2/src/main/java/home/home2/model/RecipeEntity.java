package home.home2.model;
import javafx.scene.image.Image;
import java.util.List;
public class RecipeEntity {

    String idRicetta;
    String descrizione;
    Image immagine;
    String tipo;
    List<IngredientEntity> ingredients;
    public RecipeEntity(String nomeRicetta, Image imm, String descrizione, String tipologia){
        this.idRicetta = nomeRicetta;
        this.immagine = imm;
        this.descrizione = descrizione;
        this.tipo = tipologia;
    }

    public RecipeEntity(String recipeName) {
        this.idRicetta = recipeName;
    }

    public String getRecipe(){
        return idRicetta;
    }

    public void setRecipe( String recipe){
        this.idRicetta = recipe;
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