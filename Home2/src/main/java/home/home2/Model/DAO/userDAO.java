package home.home2.Model.DAO;
import home.home2.Model.DAO.Queries.queries;
import home.home2.Model.user;
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

   public String verify( String username, String password) throws SQLException {

        con = DBConnection.getInstance().getConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet res = queries.credentials(stmt, username, password);
        String result = null;

        if(!res.first()){
            System.out.println("ResultSet vuoto\n");
        }
        else{
            String UN = res.getString("username");
            String PW = res.getString("password");


            if (UN.equals(username) && PW.equals(password)){
                result = res.getString("username");
            }
        }
        return result;

       /* if(res.first() == false){
            System.out.println("ResultSet vuoto\n");

        }
        else {
            String UN = res.getString("username");
            String PW = res.getString("password");


            if (UN.equals(username) && PW.equals(password)) {
                return true;
            }
        }
        return false;*/
    }

    /*public static void allUsers() throws SQLException {

        con = DBConnection.getInstance().getConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultset = queries.allUsers(stmt);

        if(!resultset.first()){
            all = null;
        }

        resultset.first();
        do {
            userEntity userentity ;
            for(userEntity a: all){
                if(a.getUsername().equals(resultset.getString("username"))){
                    userentity = a;
                }
            }

        } while (resultset.next());


    }*/

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
