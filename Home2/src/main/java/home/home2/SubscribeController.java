package home.home2;

import home.home2.Controller.enrollController;
import home.home2.Model.Beans.enrollBean;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static home.home2.Model.Beans.enrollBean.verifyEmail;

public class SubscribeController implements Initializable {
    private String c1, c2, c3, c4, c5, c6;
    private static PendentScreen ps;

    @FXML
    private TextField name, lastname, username, email, pwd, pwdRepeat;
    @FXML
    private Label pwdAlert1, pwdAlert2, pwdAlert3, pwdAlert4, alert, alertfail;
    @FXML
    private Hyperlink login;
    @FXML
    private Pane menu, dark;
    @FXML
    private Button menuButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pwdAlert1.setVisible(false);
        pwdAlert2.setVisible(false);
        pwdAlert3.setVisible(false);
        pwdAlert4.setVisible(false);
        alert.setVisible(false);

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
        if (General.loginState) {
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
        if (General.loginState) {
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
        if (General.loginState) {
            General.changeScene(General.setSource("Fridge0"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("Fridge0.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login"));
        }
    }

    @FXML
    private void clickMenuLink8(ActionEvent event) throws IOException {
        Home.GUI = 1;
        General.changeScene(General.setSource("Home2"));
    }


    @FXML
    private void clickLogin() throws IOException {
        General.changeScene(General.setSource("Login"));
    }

    @FXML
    private void clickSubscribe() throws IOException, SQLException {
        int i;
       /* c1 = name.getText();
        c2 = lastname.getText();
        c3 = username.getText();
        c4 = email.getText();
        c5 = pwd.getText();
        c6 = pwdRepeat.getText();

        // controllo non corretto
        if (c1 == "" || c2 == "" || c3 == "" || c4 == "" || c5 == "" || c6 == "") {
            pwdAlert1.setVisible(false);
            pwdAlert2.setVisible(false);
            alert.setVisible(true);
        } else {
            alert.setVisible(false);
            if (c5.length() != 8) {
                pwdAlert1.setVisible(true);
            } else {
                pwdAlert1.setVisible(false);
            }


            if (c5.equals(c6)) {
                pwdAlert2.setVisible(false);
            } else {
                pwdAlert2.setVisible(true);
            }

            // check also the email !!
        }

    } */

        enrollBean eb = new enrollBean();
        eb.setUsername(username.getText());
        eb.setName(name.getText());
        eb.setCognome(lastname.getText());
        eb.setEmail(email.getText());
        eb.setPassword(pwd.getText());


        enrollController ec = new enrollController();
        if (ec.addUser(eb) == true) {
            alert.setVisible(true);
        } else {
            if ((verifyEmail(eb.getEmail())) == false) {

                pwdAlert3.setVisible(true);


            } else {
                //if (eb.getPassword().equals(pwdRepeat.getText())) non funziona
                //    pwdAlert2.setVisible(true);

                if (eb.getPassword().length() < 8){
                    pwdAlert1.setVisible(true);
                }
                else {
                    pwdAlert4.setVisible(true);
                }

            }


        }
    }
}
