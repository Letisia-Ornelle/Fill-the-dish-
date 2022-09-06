package home.home2;

import home.home2.Controller.enrollController;
import home.home2.Controller.loginController;
import home.home2.Model.Beans.enrollBean;
import home.home2.Model.Beans.loginBean;
import home.home2.Model.Exceptions.loginFailedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import static home.home2.Home2.ps;

public class Login2Controller {

    private PendentScreen2 ps2;

     @FXML
     private TextField username;

     @FXML
     private PasswordField password;

     @FXML
     private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField email;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField passWord;

    @FXML
    private PasswordField repeatPassword;


     @FXML
    public void clickLogin(ActionEvent event) throws IOException, SQLException, loginFailedException {

        General2.loginState = true;

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
                General2.changeScene(General2.setSource("Home2"));
            }
            else{
               General2.changeScene(ps.get());
            }

        }

    }

    public void clickRegister(ActionEvent event) throws IOException, SQLException {

        enrollBean enrollbean = new enrollBean();
        enrollbean.setUsername(userName.getText());
        enrollbean.setName(name.getText());
        enrollbean.setCognome(lastname.getText());
        enrollbean.setEmail(email.getText());
        enrollbean.setPassword(passWord.getText());

        enrollController controller = new enrollController();

        if (controller.addUser(enrollbean) == true && enrollbean.getPassword().equals(repeatPassword.getText())) {

            System.out.println("Nuovo utente registrato con successo!");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Account registrato con successo! Ora puoi accedere.");
            alert.show();

            userName.setText("");
            name.setText("");
            lastname.setText("");
            email.setText("");
            passWord.setText("");
            repeatPassword.setText("");

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Le due password non coincidono!");
            alert.show();
        }

    }

    public void clickInterfaceButton(ActionEvent event) {
         // No
    }

    public void clickReviewButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Review2"));

    }

    public void clickFridgeButton(ActionEvent event) throws IOException {
        if (General2.loginState) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Fridge2.fxml");
            //System.out.println();
            General2.changeScene(General2.setSource("Login2"));
        }

    }

    public void clickFavouriteButton(ActionEvent event) throws IOException {
        if (General2.loginState) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }

    }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Login2"));

    }

    public void clickAddButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Add2"));

    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Search2"));

    }

    public void clickHomeButton(ActionEvent event) throws IOException {
         General2.changeScene(General2.setSource("Home2"));
    }

    public void clickBackButton(ActionEvent event) {
    }

    public void clickInsertIngredients(ActionEvent event) throws IOException {
         General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButton(ActionEvent event) throws IOException {
         ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
}
