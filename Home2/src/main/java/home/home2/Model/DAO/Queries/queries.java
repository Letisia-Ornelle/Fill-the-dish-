package home.home2.Model.DAO.Queries;

import home.home2.Model.DAO.DBConnection;
import javafx.scene.image.Image;

import java.sql.*;

public class queries {



    /*  Connection connection = DriverManager.getConnection("jdbc:mysql://allinoneexchange.com:3306/FillTheDish", "testUser", "7BEpa]q=tLkm"); */


    public queries() {
    }


    public static ResultSet credentials(Statement stmt, String username, String password) throws SQLException {

        String selectCredentials = String.format("Select * From utenti Where username ='%s' AND password ='%s'", username, password);
        return stmt.executeQuery(selectCredentials);

    }

    /*public static ResultSet allUsers(Statement stmt) throws SQLException {
        String returnUsers = String.format("Select * From utenti");
        return stmt.executeQuery(returnUsers);

    }*/

    public static int enroll( Statement stmt, String username, String nome, String cognome, String email, String password) throws SQLException {

        String enrollNow = String.format("INSERT IGNORE INTO `utenti`(username, nome, cognome, email, password) VALUES ('%s','%s','%s','%s','%s')", username, nome, cognome, email, password);
        return stmt.executeUpdate(enrollNow);   //ritorna un intero con il numero di righe aggiunte

    }

    // Dovrei fare il controllo anche sull'utente ? o non e necessario ?
    public static ResultSet getImageFromIng(Statement stmt,String username, String ingredient) throws SQLException {

        String selectImage = String.format("SELECT immagine from ingredienti where nome = %s", ingredient);

        if(stmt.executeQuery(selectImage) != null){
            String insertF = String.format("INSERT IGNORE INTO fridge(utente, ingrediente, immagine) VALUES ('%s','%s','%s')", username,ingredient,selectImage);
            stmt.executeUpdate(insertF);
        }
        return stmt.executeQuery(selectImage);
    }
}


