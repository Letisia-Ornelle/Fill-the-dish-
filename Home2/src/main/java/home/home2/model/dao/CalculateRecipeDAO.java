package home.home2.Model.DAO;

import home.home2.Model.DAO.Queries.queries;
import home.home2.Model.Ingredient;
import home.home2.Model.RecipeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  calculateRecipeDAO {

    static Statement stmt = null;
    Statement stmt1 = null;
    static Connection conn = null;


    public static ObservableList<Ingredient> ingredients() {
        ObservableList<Ingredient> listaIng = FXCollections.observableArrayList();
        Ingredient ingredient = null;
        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet res = queries.takeIngredientsDB(stmt);

            if (res.first() == false) {
                System.out.println("ResultSetIngredienti vuoto\n");
                return null;

            } else {
                while (res.next()) {
                    String ingredientName = res.getString("nome");
                    listaIng.add(new Ingredient(ingredientName));
                }
            }
        }catch(SQLException e){
                e.printStackTrace();
            }

            return listaIng;


    }
// questo metodo restituisce array di ricette e assegna alla variabile nomeRicetta un nome alla volta

    public List<RecipeEntity> Recipes(ObservableList<Ingredient> userIngredients){

        // FXCollections.observableArrayList();
        List<RecipeEntity> recipes = new ArrayList<>();
        RecipeEntity recipe ;
        Image image = null;
        int count = 0;
        List<Ingredient> ingredients = new ArrayList<>();
       // Ingredients ingredient;

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = queries.getRecipesName(stmt);

            if(!resultSet.first()){
                return recipes;
            }

            resultSet.first();
            while(resultSet.next()){
                // Ok tutto preso dal DB in modo opportuno
                // ho tralasciato l'immagine per il momento
                String name = resultSet.getString("id_ricetta");
                String tipologia = resultSet.getString("tipo");
                String descrizione = resultSet.getString("descrizione");
                Blob bl = resultSet.getBlob("immagine");
                if(bl != null){
                    InputStream inputStream = bl.getBinaryStream();
                    image = new Image(inputStream);
                }
              //  System.out.println(name);

               // recipe = new RecipeEntity(name,image,descrizione,tipologia) ;


               // recipe.setRecipe(name); // è necessario ?
                // Recupero la lista d'ingredienti della ricetta precisa ?
                // Certo come parametro potevo direttamente passare la stringa name presa sopa.... però vabbe dovrebbe essere uguale
                ResultSet res = queries.selectRecipesIngredients(stmt1,name);
                // Recuperata questa lista, dovrei confrontarla con la lista passata come parametro

                res.first();
                Ingredient ingredient ;

                do{
                    // Devo reinizializzare questa lista in modo da non agggiungere alla lista precedente , ma ad una nuova lista
                    String nameIngr = res.getString("ingrediente");
                    ingredient = new Ingredient(nameIngr);
                    ingredients.add(ingredient);

                } while(res.next());

                // Ok prende gli elementi in comune.... Cioè se hanno minimo 2 elementi in comune viene restituita la ricetta

                for(Ingredient ingr : ingredients){
                    for(Ingredient ingr1 : userIngredients){
                        if(ingr.getName().equals(ingr1.getName())){
                            count++;
                           // System.out.println("Ciao ecco qui il confronto per gli ingredienti");
                        }
                    }
                }

                System.out.println(count);
               if(count >= 2){
                   recipes.add(new RecipeEntity(name,image,descrizione,tipologia));
                }

                ingredients.removeAll(ingredients);
               count = 0;

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return recipes;
    }

    // Data una ricetta , restituisce la lista di ingredienti , in modo da settare mostrare tali ingredienti sulla View all'utente

    public static List<Ingredient> RecipesIngredients(String recipe)  {

        List<Ingredient> ingredients = new ArrayList<>();

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = queries.selectRecipesIngredients(stmt,recipe);
            if(!resultSet.first()){
                return ingredients;
            }

            resultSet.first();
            do{
                String name = resultSet.getString("ingrediente");

                ingredients.add(new Ingredient(name));

            }while(resultSet.next());


        }catch(SQLException e){
            e.printStackTrace();
        }

        return ingredients;

    }

}







