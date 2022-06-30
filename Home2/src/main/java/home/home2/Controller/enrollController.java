package home.home2.Controller;

import home.home2.Model.Beans.enrollBean;
import home.home2.Model.DAO.enrollDAO;

import java.sql.SQLException;

import static home.home2.Model.Beans.enrollBean.verifyEmail;

public class enrollController {

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    public boolean addUser(enrollBean eb ) throws SQLException {

        enrollDAO dao = new enrollDAO();

        if ((eb.getPassword() == "" || eb.getUsername() == "" || eb.getName() == "" || eb.getCognome() == "" || eb.getEmail() == "") || verifyEmail(eb.getEmail()) == false || ( eb.getPassword().length() < 8 )) {
            return false;
        } else {


            Boolean add = dao.newUser(eb.getUsername(), eb.getName(), eb.getCognome(), eb.getEmail(), eb.getPassword());

            if (add == true) {
                return true;
            } else {
                return false;
            }
        }

    }
}
