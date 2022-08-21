package home.home2;

import home.home2.Controller.loginController;
import home.home2.Model.Beans.loginBean;
import home.home2.Model.Exceptions.loginFailedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import static home.home2.Home.ps;

public class Login2Controller {

     @FXML
     private TextField username;

     @FXML
     private PasswordField password;

     @FXML
    public void clickLogin(ActionEvent event) throws IOException, SQLException, loginFailedException {

        General.loginState = true;

        loginBean loginB = new loginBean();
        loginB.setUsername(username.getText());
        loginB.setPassword(password.getText());

        username.setText("");
        password.setText("");

        loginController loginC = new loginController();
        if(loginC.login(loginB) == false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Credenziali Errate!");
            alert.show();
        }
        else{
            // Reindirizzare.....
            if(ps.isNull()){
                General.changeScene(General.setSource("Home2"));
            }
            else{
               General.changeScene(ps.get());
            }

        }



    }

    public void clickRegister(ActionEvent event) throws IOException {

    }

    public void clickInterfaceButton(ActionEvent event) {
         // No
    }

    public void clickReviewButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Review2"));

    }

    public void clickFridgeButton(ActionEvent event) throws IOException {
        if (General.loginState) {
            General.changeScene(General.setSource("Fridge2"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("Fridge2.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login2"));
        }

    }

    public void clickFavouriteButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Favourite2"));

    }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Login2"));

    }

    public void clickAddButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Add2"));

    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Search2"));

    }

    public void clickHomeButton(ActionEvent event) {
    }

    public void clickBackButton(ActionEvent event) {
    }
}
