package home.home2.Model.DAO.Queries;

import home.home2.Model.DAO.DBConnection;

import java.sql.*;

public class queries {



    /*  Connection connection = DriverManager.getConnection("jdbc:mysql://allinoneexchange.com:3306/FillTheDish", "testUser", "7BEpa]q=tLkm"); */


    public queries() throws SQLException {

    /*    Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from utenti");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("username")); */
    }


    public static ResultSet credentials(Statement stmt, String username, String password) throws SQLException {


        String selectCredentials = String.format("Select username, password From utenti Where username ='%s' AND password ='%s'", username, password);

            /*ResultSet resultSet = statement.executeQuery("Select username, password From utenti Where username = '%s' and password = '%s' ", username,password);

             while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
            return resultSet; */
            return stmt.executeQuery(selectCredentials);

    }

    public static int enroll( Statement stmt, String username, String nome, String cognome, String email, String password) throws SQLException {

        String enrollNow = String.format("INSERT INTO `utenti`(username, nome, cognome, email, password) VALUES ('%s','%s','%s','%s','%s')", username, nome, cognome, email, password);
        return stmt.executeUpdate(enrollNow);   //ritorna un intero con il numero di righe aggiunte

    }
}


