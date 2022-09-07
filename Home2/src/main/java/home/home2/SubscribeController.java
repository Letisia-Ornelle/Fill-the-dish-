package home.home2;

import home.home2.controller.EnrollController;
import home.home2.beans.EnrollBean;
import home.home2.model.exceptions.FailedRegistrationException;
import home.home2.model.exceptions.InvalidSyntaxEmailException;
import home.home2.model.exceptions.LoginFailedException;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SubscribeController implements Initializable {
    private String c1, c2, c3, c4, c5, c6;
    private static PendentScreen ps;

    @FXML
    private TextField name, lastname, username, email, pwd, pwdRepeat;
    @FXML
    private Label pwdAlert1, pwdAlert2, pwdAlert3, pwdAlert4, alert, alertfail, alertUser;
    @FXML
    private Hyperlink login;
    @FXML
    private Pane menu, dark;
    @FXML
    private Button menuButton;
    @FXML
    private Button subscribe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pwdAlert1.setVisible(false);
        pwdAlert2.setVisible(false);
        pwdAlert3.setVisible(false);
        pwdAlert4.setVisible(false);
        alert.setVisible(false);
        alertUser.setVisible(false);

        menu.setVisible(false);
        dark.setVisible(false);

        Home m = new Home();
        ps = m.getPS();
    }

    @FXML
    private void clickMenuButton() throws IOException, InterruptedException {
        if (menu.isVisible()) {

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), dark);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menu);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(-320);
            translateTransition2.setByX(-220);
            translateTransition1.play();
            translateTransition2.play();

            fadeTransition.setOnFinished(event -> {
                menu.setVisible(false);
                dark.setVisible(false);
            });

        } else {
            menu.setVisible(true);
            dark.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), dark);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menu);
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), menuButton);
            translateTransition1.setByX(320);
            translateTransition2.setByX(220);
            translateTransition1.play();
            translateTransition2.play();
        }
    }


    @FXML
    private void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }

    @FXML
    private void clickBackButton() throws IOException {
        General.setBackScene();
    }

    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Result"));
    }

    @FXML
    private void clickMenuLink2(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps.add("Insert.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login"));
        }
    }

    @FXML
    private void clickMenuLink3(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Login"));
    }

    @FXML
    private void clickMenuLink4(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }

    @FXML
    private void clickMenuLink5(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Review"));
    }

    @FXML
    private void clickMenuLink6(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("Favourite.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login"));
        }
    }

    @FXML
    private void clickMenuLink7(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("Fridge.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login"));
        }
    }

    @FXML
    private void clickLogin() throws IOException {
        General.changeScene(General.setSource("Login"));
    }

    @FXML
    private void clickSubscribe(ActionEvent event) throws IOException, SQLException {

        EnrollBean eb = new EnrollBean();
        eb.setUsername(username.getText());
        eb.setName(name.getText());
        eb.setCognome(lastname.getText());
        eb.setEmail(email.getText());
        eb.setPassword(pwd.getText());

        EnrollController ec = new EnrollController();
        try {
            if (ec.addUser(eb) == true && eb.getPassword().equals(pwdRepeat.getText())) {
                General.changeScene(General.setSource("Login"));
            } else {
               //
            }
        }catch (InvalidSyntaxEmailException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Inserisci un indirizzo mail valido");
            alert.show();
        }catch (FailedRegistrationException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Registrazione fallita");
            alert.show();
        }
        }
}
