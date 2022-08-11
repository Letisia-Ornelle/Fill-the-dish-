package home.home2.Model.DAO.Queries;

import home.home2.Model.IngredientEntity;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class queries {


    public queries() {
    }


    public static ResultSet credentials(Statement stmt, String username, String password) throws SQLException {

        String selectCredentials = String.format("Select * From utenti Where username ='%s' AND password ='%s'", username, password);
        return stmt.executeQuery(selectCredentials);

    }


    public static void enroll(Statement stmt, String username, String nome, String cognome, String email, String password) throws SQLException {

        String enrollNow = String.format("INSERT INTO `utenti`(username, nome, cognome, email, password) VALUES ('%s','%s','%s','%s','%s')", username, nome, cognome, email, password);
        stmt.executeUpdate(enrollNow);   //ritorna un intero con il numero di righe aggiunte

    }


    public static ResultSet getImageFromIng(Statement stmt, String ingredient) throws SQLException {

        String selectImage = String.format("SELECT * from `ingredienti` where nome = '%s'", ingredient);
        return stmt.executeQuery(selectImage);
    }


    public static void insertIntoFridge(Connection conn, String username, IngredientEntity ingredient, InputStream ingredientImageInputStream) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `frigo`(utente,ingrediente,immagine) values (?,?,?)");
        try{
            pstmt.setString(1, username);
            pstmt.setString(2,ingredient.getIngredient());
            pstmt.setBlob(3,ingredientImageInputStream);

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            pstmt.close();
        }

    }


    public static ResultSet getIngredients(Statement stmt) throws SQLException {
        String ingredients = String.format("SELECT `nome`  FROM `ingredienti`");
        return stmt.executeQuery(ingredients);
    }

    public static ResultSet getIngredientsFromFridge(Statement stmt, String username) throws SQLException {
        String ingredients = String.format("SELECT * FROM `frigo` where `utente` = '%s'", username);
        return stmt.executeQuery(ingredients);
    }

    public static void deleteFromFridge(Statement stmt,String username, String ingredient) throws SQLException{
        String delete = String.format("DELETE FROM `frigo` WHERE `utente` = '%s' AND `ingrediente` = '%s' ",username,ingredient);
        stmt.executeUpdate(delete);
    }
}


