package home.home2;

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
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    String usernameContent, pwdContent;
    private static PendentScreen ps;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label alert;
    @FXML
    private Button menuButton;
    @FXML
    private Pane menu, dark;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
        dark.setVisible(false);
        alert.setVisible(false);

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
        ps.clear();
        General.changeScene(General.setSource("Home"));
    }

    @FXML
    private void clickBackButton() throws IOException {
        ps.clear();
        General.setBackScene();
    }


    @FXML
    private void clickLoginButton() throws IOException {
        /*
        usernameContent = username.getText();
        pwdContent = password.getText();

        if (usernameContent == "" || pwdContent == "") {
            alert.setVisible(true);
        } else {
            alert.setVisible(false);
            System.out.println("email: " + usernameContent + "\npassword: " + pwdContent);
        */

        General.loginState = true;
        if (ps.isNull()) {
            General.changeScene(General.setSource("Home"));
        } else {
            General.changeScene(ps.get());
        }
            /*
            Login log = new Login();
            if (log.login(usernameContent, pwdContent)) {
                alert.setVisible(false);
                if (PendentInterface.isNull()) {
                    General.changeScene(General.setSource("Home"));
                } else {
                    General.changeScene(PendentInterface.get());
                }

            } else {
                alert.setText("Login Fallito");
                alert.setVisible(true);
            }
            */


    }

    @FXML
    private void clickSubscribe() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }

    // login tramite facebook & google


    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {
        ps.clear();
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
        // niente
    }

    @FXML
    private void clickMenuLink4(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }

    @FXML
    private void clickMenuLink5(ActionEvent event) throws IOException {
        ps.clear();
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
        ps.clear();
        Home.GUI = 1;
        General.changeScene(General.setSource("Home2"));
    }

}