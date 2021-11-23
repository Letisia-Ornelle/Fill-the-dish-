package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IngredientsController implements Initializable {
   @FXML
   private Button recipeButton, fridgeButton, menuButton;

   @FXML
   private Pane menu, dark;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        General.changeScene(General.setSource("Home"), General.setSource("Home"));
    }
    @FXML
    private void clickBackButton() throws IOException {
        //General.changeScene(General.getBackScene());
    }

   @FXML
   private void clickRecipeButton() throws IOException {
       General.changeScene(General.setSource("Ingredients"), General.setSource("ricettaOttenuta"));
   }

    @FXML
    private void clickFridgeButton() throws IOException {
        General.changeScene(General.setSource("Ingredients"), General.setSource("Fridge"));
    }



    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {

    }
    @FXML
    private void clickMenuLink2(ActionEvent event) throws IOException {
        if (General.loginState) {
            //goToHome();
        } else {
            General.changeScene(General.setSource("Home"), General.setSource("Login"));
        }
    }
    @FXML
    private void clickMenuLink3(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Home"), General.setSource("Login"));
    }
    @FXML
    private void clickMenuLink4(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Home"), General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuLink5(ActionEvent event) throws IOException {

    }

/*
    public void screen2(ActionEvent actionEvent) throws IOException {
        HelloApplication h = new HelloApplication();
        if(actionEvent.getSource()== bFridge){
            h.changeScene("Fridge.fxml");
        }
        if(actionEvent.getSource()== buttonricetta){
            h.changeScene("ricettaOttenuta.fxml");
        }

    }
 */
}