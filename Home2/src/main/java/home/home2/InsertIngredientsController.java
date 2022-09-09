package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.model.Ingredient;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InsertIngredientsController implements Initializable {

    @FXML
    private GridPane grid;


    private static DynamicCBController choiceBoxController ;


    private static final String LOGIN = "Login";

    @FXML
    private Button  menuButton;

    @FXML
    private Pane menu;
    @FXML
    private Pane dark;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        menu.setVisible(false);
        dark.setVisible(false);



        int column = 0 ;
        int row  = 1;
        try {

            for(int i=0;i<22;i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("dynamicCB.fxml"));


                if (column == 2) {
                    column = 0;
                    row++;
                }
                Pane pane = fxmlLoader.load();
                getContr(fxmlLoader.getController());

                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                grid.setMaxHeight(Region.USE_PREF_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(50));
                grid.setAlignment(Pos.CENTER);
                GridPane.setHalignment(pane, HPos.CENTER);
                grid.setGridLinesVisible(false);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getContr(Object controller) {
        choiceBoxController = (DynamicCBController) controller;
    }

    @FXML
    private void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }
    @FXML
    private void clickBackButton() throws IOException {
        General.setBackScene();
    }

    private static List<CalculateRecipeBean> recipeBeans = new ArrayList<>() ;

    public  List<CalculateRecipeBean> getRecipes(){
        return recipeBeans;
    }


    @FXML
    private void clickRecipeButton() throws IOException {
        PendentScreen ps1;
        ps1 = Home.getPS();

        ps1.setScreen("2");
             // no
        ObservableList<Ingredient> ingredients = choiceBoxController.getValues();

        CalculateRecipeBean recipeBean = new CalculateRecipeBean();
        recipeBean.setListIng(ingredients);

        CalculateRecipeController recipeController = new CalculateRecipeController();

        for(CalculateRecipeBean i : recipeController.checkIngredients(recipeBean)){
            recipeBeans.add(i);
        }

        General.changeScene(General.setSource("Result"));

    }




    @FXML
    private void clickFridgeButton() throws IOException {
        PendentScreen ps2;
        ps2 = Home.getPS();
        if (Boolean.TRUE.equals(General.LOGINSTATE)) {
            General.changeScene(General.setSource("SelectIngredients"));
        } else {
            ps2.add("SelectIngredients.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
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
        PendentScreen ps1 ;
        if (Boolean.TRUE.equals(General.LOGINSTATE)) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps1 = Home.getPS();
            ps1.add("Favourite.fxml");

            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink7() throws IOException {
        PendentScreen ps5;
        ps5 = Home.getPS();
        if (Boolean.TRUE.equals(General.LOGINSTATE)) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps5.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink8() throws IOException {
        General.changeScene(General.setSource("Home2"));
    }


    @FXML
    private void clickMenuButton(){
        if (Boolean.TRUE.equals(menu.isVisible())) {

            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), menuButton);

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menu);

            translateTransition1.setByX(-320);
            translateTransition.setByX(-220);
            translateTransition1.play();
            translateTransition.play();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), dark);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            fadeTransition.setOnFinished(event -> {
                menu.setVisible(false);
                dark.setVisible(false);
            });

        } else {
            dark.setVisible(true);
            menu.setVisible(true);


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


}