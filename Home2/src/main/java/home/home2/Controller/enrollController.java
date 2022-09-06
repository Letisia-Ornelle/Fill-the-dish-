package home.home2.Controller;

import home.home2.Beans.enrollBean;
import home.home2.Model.user;
import javafx.scene.control.Alert;

import java.sql.SQLException;

import static home.home2.Beans.enrollBean.verifyEmail;

public class enrollController {

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    public boolean addUser(enrollBean eb ) throws SQLException {

        if ((eb.getPassword() == "" || eb.getUsername() == "" || eb.getName() == "" || eb.getCognome() == "" || eb.getEmail() == "")) {
            //return false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Ci sono campi vuoti!");
            alert.show();

            return false;
        }
        if( eb.getPassword().length() < 8 ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Password troppo corta!");
            alert.show();

            return false;

        }
        if( verifyEmail(eb.getEmail()) == false ){
            // Qui dobbiamo lanciare l'eccezione
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Sintassi dell'email non valida!");
            alert.show();
            return false;


        }
        else {

            user.getInstance().registerNewUser(eb.getUsername(), eb.getName(), eb.getCognome(), eb.getEmail(), eb.getPassword());
            // Send email to the user

            return true;

        }
    }
}
