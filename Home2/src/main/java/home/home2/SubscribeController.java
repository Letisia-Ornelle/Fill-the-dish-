package home.home2;

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
import java.util.ResourceBundle;

public class SubscribeController implements Initializable {
    private String c1, c2, c3, c4, c5, c6;

    @FXML
    private TextField name, lastname, username, email, pwd, pwdRepeat;
    @FXML
    private Label pwdAlert1, pwdAlert2, pwdAlert3, alert;
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
        alert.setVisible(false);

        menu.setVisible(false);
        dark.setVisible(false);
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
        General.changeScene(General.setSource("Favourite"));
    }
    @FXML
    private void clickMenuLink7(ActionEvent event) throws IOException {
        //General.changeScene(General.setSource("Fridge"));
    }



    @FXML
    private void clickLogin() throws IOException {
        General.changeScene(General.setSource("Login"));
    }

    @FXML
    private void clickSubscribe() throws IOException {
        c1 = name.getText();
        c2 = lastname.getText();
        c3 = username.getText();
        c4 = email.getText();
        c5 = pwd.getText();
        c6 = pwdRepeat.getText();

        if (c1 == "" || c2 == "" || c3 == "" || c4 == "" || c5 == "" || c6 == "") {
            pwdAlert1.setVisible(false);
            pwdAlert2.setVisible(false);
            alert.setVisible(true);
        } else {
            alert.setVisible(false);
            if (c5.length() < 8) {
                pwdAlert1.setVisible(true);
            } else {
                pwdAlert1.setVisible(false);
            }
            // aggiustare confronto tra stringhe
            if (c5 != c6) {
                pwdAlert2.setVisible(true);
            } else {
                pwdAlert2.setVisible(false);
            }
            // check also the email !!
        }

    }
}
