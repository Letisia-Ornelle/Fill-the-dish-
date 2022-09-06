package home.home2.controller;

import home.home2.beans.LoginBean;
import home.home2.Model.DAO.userDAO;
import home.home2.Model.Exceptions.loginFailedException;
import home.home2.Model.user;

import java.sql.SQLException;

public class LoginController {

    public boolean login(LoginBean loginbean) throws SQLException, loginFailedException {

        userDAO userdao = new userDAO();

        String s = userdao.verify(loginbean.getUsername(),loginbean.getPassword());
        if(s == null){
            throw new loginFailedException("Account non registrato");
        }
        else {
           user.loginUser(loginbean.getUsername(), loginbean.getPassword());

            return true;
        }


    }

}
