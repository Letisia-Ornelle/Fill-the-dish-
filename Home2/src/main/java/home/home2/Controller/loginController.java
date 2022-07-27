package home.home2.Controller;

import home.home2.Model.Beans.loginBean;
import home.home2.Model.DAO.userDAO;
import home.home2.Model.user;

import java.sql.SQLException;

public class loginController {

    private String username;
    private String pass;

    /*public boolean verifyLogin(userBean b) throws SQLException {

        userDAO dao = new userDAO();


        Boolean risultato = dao.verify(b.getUsername(), b.getPassword());

        if(risultato == true){
            return true;
        }

        else{
            return false;
        }

    }*/

    public boolean login(loginBean loginbean) throws SQLException {

        userDAO userdao = new userDAO();

        String s = userdao.verify(loginbean.getUsername(),loginbean.getPassword());
        if(s == null){
            return false;
        }
        else {
           user.loginUser(loginbean.getUsername(), loginbean.getPassword());

            System.out.println(user.getInstance().getUser().getUsername());

            System.out.println(user.getInstance().getUser().getPassword());

           // System.out.println(user.getInstance().getUser());

            System.out.println(user.getInstance().getUser().getEmail());


            return true;
        }


    }


    public void loginFacebook(){

    }
}
