package home.home2.Model.DAO;

import home.home2.Model.DAO.Queries.queries;
import home.home2.Model.Ingredients;
import home.home2.Model.RecipeEntity;
import home.home2.Recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public List<RecipeEntity> Recipes(){

        List<RecipeEntity> recipes = new ArrayList<>();
        RecipeEntity recipe ;

        List<Ingredients> ingredients = new ArrayList<>();
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
                // ho tralasciato l'immagine per il momento
                String name = resultSet.getString("id_ricetta");
                String tipologia = resultSet.getString("tipo");
                String descrizione = resultSet.getString("descrizione");
                System.out.println(name);

                recipe = new RecipeEntity(name) ;
                //Faccio ad solo in caso di corrispondenze... Quindi va fatto più sotto
                recipes.add(recipe);

               // recipe.setRecipe(name); // è necessario ?
                // Recupero la lista d'ingredienti della ricetta precisa ?
                // Certo come parametro potevo direttamente passare la stringa name presa sopa.... però vabbe dovrebbe essere uguale
                ResultSet res = queries.selectRecipesIngredients(stmt1,name);
                // Recuperata questa lista, dovrei confrontarla con la lista passata come parametro

                res.first();
                Ingredients ingredient ;

                do{
                    // Devo reinizializzare questa lista in modo da non agggiungere alla lista precedente , ma ad una nuova lista
                    String nameIngr = res.getString("ingrediente");
                    ingredient = new Ingredients(nameIngr);
                    ingredients.add(ingredient);
                   // ingredients.set(1,ingredient);

                    //ingredient.setName(nameIngr);

                } while(res.next());

                System.out.println("Ingredienti della Ricetta:\n");
                System.out.println(name);
                for(Ingredients i : ingredients){
                    System.out.println(i.getName());
                }
                System.out.println("\n");




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







