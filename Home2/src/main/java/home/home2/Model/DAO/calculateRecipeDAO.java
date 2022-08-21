package home.home2.Model.DAO;

import home.home2.Model.DAO.Queries.queries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class  calculateRecipeDAO {

    Statement stmt = null;
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
    
    public ArrayList<String> listOfRecipes() throws SQLException {
        ArrayList<String> recipeArray = new ArrayList<String>();
        String nomeRicetta;
        conn = DBConnection.getInstance().getConnection();
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = queries.getRecipesName(stmt);
        while (rs.next()) {
            recipeArray.add(rs.getString("id_ricetta"));
            for (int i = 0; i < recipeArray.size(); i++) {
                //stampo per controllare
                nomeRicetta = (recipeArray.get(i));

                System.out.println(nomeRicetta);

            }

        }
        return recipeArray;
    }

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







