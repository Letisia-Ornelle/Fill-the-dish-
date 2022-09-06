package home.home2.Controller;

import home.home2.Beans.loginBean;
import home.home2.Model.DAO.userDAO;
import home.home2.Model.Exceptions.loginFailedException;
import home.home2.Model.user;

import java.sql.SQLException;

public class loginController {

    private String username;
    private String pass;


    public boolean login(loginBean loginbean) throws SQLException, loginFailedException {

        userDAO userdao = new userDAO();

        String s = userdao.verify(loginbean.getUsername(),loginbean.getPassword());
        if(s == null){
            throw new loginFailedException("Account non registrato");
        }
        else {
           user.loginUser(loginbean.getUsername(), loginbean.getPassword());

            System.out.println(user.getInstance().getUser().getUsername());

            System.out.println(user.getInstance().getUser().getPassword());

            System.out.println(user.getInstance().getUser().getSurname());

           System.out.println(user.getInstance().getUser());

            System.out.println(user.getInstance().getUser().getEmail());

            System.out.println("ciao");


            return true;
        }


    }

}
