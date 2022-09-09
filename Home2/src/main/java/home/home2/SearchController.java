package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    private static final String LOGIN = "Login";
    private static final String RESULT = "Result";
    @FXML
    private TextField search;
    @FXML
    private Button primi;
    @FXML
    private Button secondi;
    @FXML
    private Button contorni;
    @FXML
    private Button antipasti;
    @FXML
    private Button dessert;
    @FXML
    private Pane dark;
    @FXML
    private Button colazioni;
    @FXML
    private Button menuButton;
    @FXML
    private Pane menu;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dark.setVisible(false);
        menu.setVisible(false);
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
    private void clickMenuLink3() throws IOException {
        General.changeScene(General.setSource(LOGIN));
    }

    @FXML
    private void clickMenuLink1() throws IOException {
        PendentScreen ps3;
        ps3 = Home.getPS();
        ps3.setScreen("1");
        General.changeScene(General.setSource(RESULT));
    }
    @FXML
    private void clickMenuLink2() throws IOException {
        PendentScreen ps4;
        ps4 = Home.getPS();
        if (Boolean.TRUE.equals(General.LOGINSTATE)) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps4.add("Insert.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }


    @FXML
    private void clickMenuLink5() throws IOException {
        General.changeScene(General.setSource("Review"));
    }
    @FXML
    private void clickMenuLink4() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }


    @FXML
    private void clickMenuLink7() throws IOException {
        PendentScreen ps6;
        ps6 = Home.getPS();
        if (Boolean.TRUE.equals(General.LOGINSTATE)) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps6.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }

    @FXML
    public void clickPortata(MouseEvent event) throws IOException {
        PendentScreen ps = Home.getPS();
        Button  click ;
        click = (Button)event.getSource();
        switch (click.getId()) {
            case "primi":
                ps.setLabel(primi.getText());
                break;
            case "secondi":
                ps.setLabel(secondi.getText());
                break;
            case "contorni":
                ps.setLabel(contorni.getText());
                break;
            case "colazioni":
                ps.setLabel(colazioni.getText());
                break;
            case "dessert":
                ps.setLabel(dessert.getText());
                break;
            case "antipasti":
                ps.setLabel(antipasti.getText());
                break;
            default:
                break;
        }
        ps.setScreen("1");
        General.changeScene(General.setSource(RESULT));
    }
    @FXML
    private void clickIngredientsButton() throws IOException {
        General.changeScene(General.setSource("Ingredients"));
    }
    @FXML
    private void clickSearchButton() throws IOException {
        General.changeScene(General.setSource(RESULT));
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
    private void clickMenuLink6() throws IOException {
        PendentScreen ps5 ;
        if (Boolean.TRUE.equals(General.LOGINSTATE)) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps5 = Home.getPS();
            ps5.add("Favourite.fxml");

            General.changeScene(General.setSource(LOGIN));
        }
    }


}