package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.controller.ManageFridgeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.beans.FridgeBean;
import home.home2.model.Ingredient;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SelectIngredientsController implements  Initializable {
    @FXML
    Button backButton;
    @FXML
    Button homeButton;


    @FXML
    private Button menuButton;
    @FXML
    private Pane menu;
    @FXML
    private Pane dark;
    @FXML
    private VBox verticalBox;

    private static final String LOGIN = "Login";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        menu.setVisible(false);
        dark.setVisible(false);

        ManageFridgeController manageFridge = new ManageFridgeController();
        List<FridgeBean> fridgeBeans ;

        fridgeBeans = manageFridge.showFridge();

        try{
            for (FridgeBean fridgeBean : fridgeBeans) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ElementFridgeSelection.fxml"));
                Pane pane = fxmlLoader.load();

                ElementSelectionController elementSelectionController = fxmlLoader.getController();
                elementSelectionController.setData(fridgeBean);

                verticalBox.getChildren().add(pane);
                VBox.setMargin(pane, new Insets(5));
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void clickMenuButton()  {
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
    private void clickMenuLink1() throws IOException {
        PendentScreen ps3;
        ps3 = Home.getPS();
        ps3.setScreen("1");
        General.changeScene(General.setSource("Result"));
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
    private void clickMenuLink3() throws IOException {
        General.changeScene(General.setSource(LOGIN));
    }
    @FXML
    private void clickMenuLink4() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuLink5() throws IOException {
        General.changeScene(General.setSource("Review"));
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


    private static List<CalculateRecipeBean> recipeBeans = new ArrayList<>();

    @FXML
    private void recipesFridge() throws IOException {
        PendentScreen ps7;
        ps7 = Home.getPS();
        ps7.setScreen("3");
        ElementSelectionController elementController = new ElementSelectionController();

        CalculateRecipeController recipeController = new CalculateRecipeController();
        CalculateRecipeBean recipeBean = new CalculateRecipeBean();

        ObservableList<Ingredient> fridgeIngredients = elementController.getFridgeIngredients();

        recipeBean.setListIng(fridgeIngredients);

        for(CalculateRecipeBean i : recipeController.checkIngredients(recipeBean)){
            recipeBeans.add(i);
        }


        General.changeScene(General.setSource("Result"));
    }

    public List<CalculateRecipeBean> getRecipesBeans(){
        return recipeBeans;
    }

}