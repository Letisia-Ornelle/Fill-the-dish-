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

    Statement stmt = null;
    Statement stmt1 = null;
    Connection conn = null;


    public ObservableList<String> ingredients() throws SQLException {
        conn = DBConnection.getInstance().getConnection();
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ObservableList<String> listaIng = FXCollections.observableArrayList();
        ResultSet res = queries.takeIngredientsDB(stmt);

        if (res.first() == false) {
            System.out.println("ResultSetIngredienti vuoto\n");
            return null;

        } else {
            while (res.next()) {
                String ingredientName = res.getString("nome");
                listaIng.add(ingredientName);
            }
            return listaIng;

        }


    }
// questo metodo restituisce array di ricette e assegna alla variabile nomeRicetta un nome alla volta

    public List<RecipeEntity> Recipes(ObservableList<String> userIngredients ){

        // FXCollections.observableArrayList();
        List<RecipeEntity> recipes = new ArrayList<>();
        RecipeEntity recipe ;
        Image image = null;
        int count = 0;
        //ObservableList<String> userIngredients = FXCollections.observableArrayList();
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

                recipe = new RecipeEntity(name,image,descrizione,tipologia) ;


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

               // System.out.println("Ingredienti della Ricetta:\n");
               // System.out.println(name);
               // System.out.println(descrizione);
               // for(Ingredient i : ingredients){
                  //  System.out.println(i.getName());
               // }
                //System.out.println("\n");

                // Itero sulla lista di ingredienti del dataBase , e per ogni elemento , verifico che ci sia una corrispondenza
                // Con gli elementi della lista dell'utente. In caso positivo, incremento il contatore.
                // Se alla fine il contatore è maggiore o uguale a 3, aggiungo la ricetta alla lista di ricette.
                for(Ingredient ingr : ingredients){
                    //for(int i = 0; i< userIngredients.size();i++){
                        if(userIngredients.contains(ingr.getName())){
                            count++;
                        }
                   // }
                }

               if(count >= 1){
                    //Faccio ad solo in caso di corrispondenze... Quindi va fatto più sotto
                    recipes.add(recipe);
                }


               // A questo punto , dovrei avere la lista della prima ricetta // Penso -->  e quindi faccio il confronto
                // Confronto tra gli elementi delle  2 liste..... faccio il count degli elementi in comune, e se sono
                // Maggiori o uguali di 3, metto nella lista di ricette che restituirò.
                // Ovviamente faccio la rimozione dopo aver fatto in confronto
                ingredients.removeAll(ingredients);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        // Ricette dell'utente in corrispondenza della lista di ingredienti dell'utente ovviamente

         return recipes;
    }

    // Metodo che prende dal DB tutte le ricette in modo che se non c'è una corrispondenza con gli ingredienti dell'utente
    // Vengono restituite tutte le ricette..................
    
   /*public ArrayList<String> listOfRecipes() throws SQLException {
        ArrayList<String> recipeArray = new ArrayList<String>();
        String nomeRicetta;
        conn = DBConnection.getInstance().getConnection();
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = queries.getRecipesName(stmt);
        while (rs.next()) {
            recipeArray.add(rs.getString("id_ricetta"));

        }
        for (int i = 0; i < recipeArray.size(); i++) {
            //stampo per controllare
            nomeRicetta = (recipeArray.get(i));

            System.out.println(nomeRicetta);

        }
       // System.out.println(recipeArray);

        return recipeArray;
    }*/

    public void RecipesIngredients() throws SQLException {

        /*   per ora lo commento perche non funge questa funzione

       ResultSet ingredienti;
        ArrayList<String> ricette;

        conn = DBConnection.getInstance().getConnection();
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ricette = listOfRecipes();

        for (int i = 0; i < ricette.size(); i++) {
            ingredienti = queries.selectRecipesIngredients(stmt, ricette.get(i));


        }



*/
    }

}







