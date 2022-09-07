package home.home2;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class HomeController implements Initializable {
    @FXML
    private Button menuButton;
    @FXML
    private Pane menu;
    @FXML
    private Pane dark;

    private static PendentScreen ps;

    private static final String LOGINSTRING = "Login";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        menu.setVisible(false);
        dark.setVisible(false);

    }
    @FXML
    private void clickMenuButton() {
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
    private void clickSearchButton() throws IOException {
        General.changeScene(General.setSource("Search"));
    }
    @FXML
    private void clickIngredientsButton() throws IOException {
        General.changeScene(General.setSource("Ingredients"));
    }


    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {
        ps.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private  void clickMenuLink2(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps = Home.getPS();
            ps.add("Insert.fxml");
            General.changeScene(General.setSource(LOGINSTRING));
        }
    }
    @FXML
    private void clickMenuLink3(ActionEvent event) throws IOException {
        General.changeScene(General.setSource(LOGINSTRING));
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
    private  void clickMenuLink6(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps = Home.getPS();
            ps.add("Favourite.fxml");
            General.changeScene(General.setSource(LOGINSTRING));
        }
    }
    @FXML
    private void clickMenuLink7(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Fridge"));
      } else {
            ps = Home.getPS();
            ps.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGINSTRING));
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


}
