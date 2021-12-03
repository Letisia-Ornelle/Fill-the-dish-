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

public class ReviewController implements Initializable {
    private int starValue=0;
    private String address, comment;

    @FXML
    private Label alert;
    @FXML
    private TextField email;
    @FXML
    private TextArea note;
    @FXML
    private Button menuButton;
    @FXML
    private Pane menu, dark;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
        dark.setVisible(false);
        alert.setVisible(false);
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
        //General.changeScene(General.setSource("Favourites"));
    }
    @FXML
    private void clickMenuLink7(ActionEvent event) throws IOException {
        //General.changeScene(General.setSource("Fridge"));
    }

    @FXML
    private void clickStar1(ActionEvent event) throws IOException {
        starValue = 1;
    }
    @FXML
    private void clickStar2(ActionEvent event) throws IOException {
        starValue = 2;
    }
    @FXML
    private void clickStar3(ActionEvent event) throws IOException {
        starValue = 3;
    }
    @FXML
    private void clickStar4(ActionEvent event) throws IOException {
        starValue = 4;
    }
    @FXML
    private void clickStar5(ActionEvent event) throws IOException {
        starValue = 5;
    }

    @FXML
    private void clickSubmitButton(ActionEvent event) throws IOException {
        address = email.getText();
        comment = note.getText();
        if (address != null && comment != null && starValue != 0) {
            alert.setVisible(false);
            System.out.println("Recensione di " + address + ": \n" + comment + "\nValutazione: " + String.valueOf(starValue) + "/5");
        } else {
            alert.setVisible(true);
        }

    }

}