package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IngredientsController implements Initializable {
    private static PendentScreen ps;

    //these items are for the chooseBox
    @FXML
    private ChoiceBox choiceBox1;
    @FXML
    private ChoiceBox choiceBox2;
    @FXML
    private ChoiceBox choiceBox3;
    @FXML
    private ChoiceBox choiceBox4;
    @FXML
    private ChoiceBox choiceBox5;
    @FXML
    private ChoiceBox choiceBox6;
    @FXML
    private ChoiceBox choiceBox7;
    @FXML
    private ChoiceBox choiceBox8;
    @FXML
    private ChoiceBox choiceBoxN;



    public void choiceBoxButtonPushed(){
        choiceBox1.getValue();
        choiceBox2.getValue();
        choiceBox3.getValue();
        choiceBox4.getValue();
        choiceBox5.getValue();
        choiceBox6.getValue();
        choiceBox7.getValue();
        choiceBox8.getValue();
        choiceBoxN.getValue();
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
   private Button recipeButton, fridgeButton, menuButton;

    @FXML
    private Pane menu, dark;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
        dark.setVisible(false);

        //configuring the choiceboxs
        choiceBox1.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox2.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox3.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox4.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox5.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox6.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox7.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox8.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");


        choiceBox1.setValue("Inserisci il primo ingrediente");
        choiceBox2.setValue("Inserisci l'ottavo ingrediente");
        choiceBox3.setValue("Inserisci il settimo ingrediente");
        choiceBox4.setValue("Inserisci il sesto ingrediente");
        choiceBox5.setValue("Inserisci il quinto ingrediente");
        choiceBox6.setValue("Inserisci il quarto ingrediente");
        choiceBox7.setValue("Inserisci il secondo ingrediente");
        choiceBox8.setValue("Inserisci il terzo ingrediente");



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
    private void clickRecipeButton() throws IOException {
           General.changeScene(General.setSource("Result"));
       }
    @FXML
    private void clickFridgeButton() throws IOException {
        if (General.loginState) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("Fridge.fxml");
            General.changeScene(General.setSource("Login"));
        }
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
            Home m = new Home();
            ps = m.getPS();
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
    private void clickMenuLink8(ActionEvent event) throws IOException {

            Home.GUI=1;
            General.changeScene(General.setSource("Home2"));
    }

    @FXML
    private void clickPlus(ActionEvent event) throws IOException{

        choiceBoxN.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBoxN.setValue("Inserisci un ulteriore ingrediente ingrediente");
    }
}