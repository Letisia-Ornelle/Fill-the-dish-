package home.home2.Model.DAO;
import home.home2.Model.DAO.Queries.queries;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class loginDAO {

    Statement stmt = null;
    Connection con = null;

    public boolean verify( String username, String password) throws SQLException {

        con = DBConnection.getInstance().getConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet res = queries.credentials(stmt, username, password);

        if(res.first() == false){
            System.out.println("ResultSet vuoto\n");

        }
        else {
            String UN = res.getString("username");
            String PW = res.getString("password");


            if (UN.equals(username) && PW.equals(password)) {
                return true;
            }
        }


        return false;


    }


}
