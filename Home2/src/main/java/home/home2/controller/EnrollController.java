package home.home2.controller;

import home.home2.beans.EnrollBean;
import home.home2.model.User;
import javafx.scene.control.Alert;

import java.sql.SQLException;

import static home.home2.beans.EnrollBean.verifyEmail;

public class EnrollController {

    public boolean addUser(EnrollBean eb ) throws SQLException {

        if ((eb.getPassword().equals("") || eb.getUsername().equals("") || eb.getName().equals("") || eb.getCognome().equals("") || eb.getEmail().equals(""))) {
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
        if(!verifyEmail(eb.getEmail())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Sintassi dell'email non valida!");
            alert.show();
            return false;


        }
        else {

            User.getInstance().registerNewUser(eb.getUsername(), eb.getName(), eb.getCognome(), eb.getEmail(), eb.getPassword());

            return true;

        }
    }
}
