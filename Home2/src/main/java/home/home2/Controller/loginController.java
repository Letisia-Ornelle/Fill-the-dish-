package home.home2.Controller;

import home.home2.Model.Beans.loginBean;
import home.home2.Model.DAO.loginDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class loginController {

    private String username;
    private String pass;

    public boolean verifyLogin(loginBean b) throws SQLException {

        loginDAO dao = new loginDAO();


        Boolean risultato = dao.verify(b.getUsername(), b.getPassword());

        if(risultato == true){
            return true;
        }

        else{
            return false;
        }



    }
}
