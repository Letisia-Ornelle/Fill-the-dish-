package home.home2.Model;

import home.home2.Model.Beans.fridgeBean;
import javafx.scene.image.Image;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Forse devo fare in modo che implementa fridgeObserver , in modo tale che quando viene aggiunto un nuovo ingrediente, viene notificato

public class fridgeSingletonEntity extends fridgeSubject{


    // Lista di ingredienti --> setter et getter

    // Metodo per aggiungere un ingrediente al frigo

    // Utente che aggiunge l'ingrediente nel frigo --> setter et getter

    // frigo come singleton ???? In modo che possa aggiungere gli elementi all'istanza di frigo creata

    // Da ripensare a questa parte

    // Devo recuperare la lista di ingredienti dal DAO ( Ingredienti dell'utente) --> Ho trovato un'altro modo .... forse

    // Quale relazione esiste tra frigo e ingredienti ? --> Composizione

    private List<IngredientEntity> ingredientList ;
    private static fridgeSingletonEntity instance = null;
    userEntity userentity;
    private String username ;

    // Prima l'ho pensata cosi, ma poi mi sono accorta che non andava bene con il fatto
    public fridgeSingletonEntity(List<IngredientEntity> ingredientList, String userName) {
        this.ingredientList = ingredientList;
        this.username = userName;
    }

    // public fridgeSingleton(){

   // }

    // Costruttore
    //public fridgeSingleton(List<Ingredient> ingredientList, String userName) throws SQLException {
    // Composizione tra frigo e ingredienti

    public static synchronized fridgeSingletonEntity createFridge(List<IngredientEntity> ingredientList, String userName){

        if(instance == null){
            return new fridgeSingletonEntity(ingredientList,userName);
        }
        return instance;

    }

    // In teoria non dovrei più fare la new
    public static synchronized fridgeSingletonEntity getInstance(){
        if(instance == null){
                return new fridgeSingletonEntity();
        }
        return instance;
    }

    public fridgeSingletonEntity(){
        this.ingredientList = new ArrayList<>();
    }

    public List<IngredientEntity> getIngredientList(){
        return ingredientList;
    }

    public IngredientEntity addIngredient(String name, Image image){
        IngredientEntity ingrediente = new IngredientEntity();
        ingrediente.setIngredient(name);
        ingrediente.setIngredientSrc(image);

        ingredientList.add(ingrediente);

        fridgeBean f = new fridgeBean();
        f.setIngredientName(name);
        f.setIngredientImage(image);

        notifyObserversNewIngredient(f);

        return ingrediente;
    }

    public void removeIngredient(IngredientEntity ingredient){
        for(IngredientEntity ingr : ingredientList){
            if (ingr.getIngredient().equals(ingredient.getIngredient())){
                ingredientList.remove(ingredient);
            }
        }
    }

    // Devo prendere come parametro il nome dell'utente,
    // Il vecchio ingrediente ( quello da cambiare )
    // Ed il nuovo , in modo da passare il nuovo come argomento del setingredient name and source
    // O forse dovrei fare la modifica indipendente ? Tipo modifico nome , modifico immagine a piacere

    public void modifyIngredient(IngredientEntity oldIngredient, IngredientEntity newIngredient){
        for(IngredientEntity ingr : ingredientList){
            if(ingr.getIngredient().equals(oldIngredient.getIngredient())){
                ingr.setIngredient(newIngredient.getIngredient());
                ingr.setIngredientSrc(newIngredient.getIngredientSrc());
            }
        }
    }

}
