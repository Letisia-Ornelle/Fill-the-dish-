package home.home2;

import home.home2.Controller.manageFridgeController;
import home.home2.Model.Beans.fridgeBean;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SelectIngredientsController implements  Initializable {
    @FXML
    Button backButton;
    @FXML
    Button homeButton;
    @FXML
    Button buttonricetta;

    @FXML
    private Button menuButton;
    @FXML
    private Pane menu, dark;
    @FXML
    private VBox verticalBox;

    // Devo semplicemente inizializzare la schermata con gli elementi presenti nella lista restituita nel controller di managefridge

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        menu.setVisible(false);
        dark.setVisible(false);

      manageFridgeController manageFridge = new manageFridgeController();
       List<fridgeBean> fridgeBeans = null;

       try{
           fridgeBeans = manageFridge.showFridge();
       }catch (SQLException e){
           e.printStackTrace();
       }

       try{
           for(int i =0; i<fridgeBeans.size();i++){
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("ElementFridgeSelection.fxml"));
               Pane pane = fxmlLoader.load();

               ElementSelectionController elementSelectionController = fxmlLoader.getController();
               elementSelectionController.setData(fridgeBeans.get(i));

               verticalBox.getChildren().add(pane);
               verticalBox.setMargin(pane,new Insets(5));
           }
       }catch(IOException e){
           e.printStackTrace();
       }

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
        General.changeScene(General.setSource("Insert"));
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
        // niente
    }
    @FXML
    private void clickMenuLink8(ActionEvent event) throws IOException {
        Home.GUI=1;
        General.changeScene(General.setSource("Home2"));
    }

    @FXML
    private void clickComputeRecipe(ActionEvent event) throws IOException {
        int i;
        for (i=0;i<ElementController.list.size();i++) {
            System.out.println(ElementController.list.get(i));
        }

    }



}
