package home.home2.Model.DAO;
import home.home2.Model.DAO.Queries.queries;
import home.home2.Model.Exceptions.loginFailedException;
import home.home2.Model.userEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDAO {

    static Statement stmt = null;
    static Connection con = null;
    String UserName = null;
    private static List<userEntity> all = new ArrayList<>();


    // Devo fare un metodo che mi restituisce l'utente loggato! --> getUserAccount
    // Verify mi restituisce lo username dell'utente. null se non c'e la corrispondenza sul db

   public String verify( String username, String password) {
       String result = null;

       try{
           con = DBConnection.getInstance().getConnection();
           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

           ResultSet res = queries.credentials(stmt, username, password);


           if (!res.first()) {
               System.out.println("ResultSet vuoto\n");
           } else {
               String UN = res.getString("username");
               String PW = res.getString("password");


               if (UN.equals(username) && PW.equals(password)) {
                   result = res.getString("username");
               }
           }
       }catch (SQLException e){
           e.printStackTrace();
       }

       return result;


   }

    public static userEntity getUserAccount(String username, String password) throws SQLException {

        con = DBConnection.getInstance().getConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultset = queries.credentials(stmt, username,password);

        userEntity userentity;

        if(!resultset.first()){
            return null;
        }

        else{

            resultset.first();

            userentity = new userEntity();

            userentity.setUsername(resultset.getString("username"));
            userentity.setName(resultset.getString("nome"));
            userentity.setSurname(resultset.getString("cognome"));
            userentity.setEmail(resultset.getString("email"));
            userentity.setPassword(resultset.getString("password"));

        }


        return userentity;

    }


}
