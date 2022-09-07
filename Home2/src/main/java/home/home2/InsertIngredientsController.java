package home.home2;

import home.home2.controller.CalculateRecipeController;
import home.home2.beans.CalculateRecipeBean;
import home.home2.model.Ingredient;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    private static PendentScreen ps;

    @FXML
    private Pane pane;

    @FXML
    private GridPane grid;
    int column = 0 ;
    int row  = 3;


    private static DynamicCBController choiceBoxController ;

    @FXML
    private void clickMenuButton(){
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

        Home m = new Home();
        ps = m.getPS();



        int column = 0 ;
        int row  = 1;
        try {

            for(int i=0;i<22;i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("dynamicCB.fxml"));

                Pane pane = fxmlLoader.load();
                choiceBoxController = fxmlLoader.getController();
                System.out.println(choiceBoxController);


                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                // set grid height
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                grid.add(pane, column++, row);
                grid.setMargin(pane, new Insets(50));
                grid.setAlignment(Pos.CENTER);
                grid.setHalignment(pane, HPos.CENTER);
                grid.setGridLinesVisible(false);
            }

        } catch (IOException e) {
            e.printStackTrace();
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

    private static List<CalculateRecipeBean> recipeBeans = new ArrayList<>();

    public List<CalculateRecipeBean> getRecipes(){
        return recipeBeans;
    }



    @FXML
    private void clickRecipeButton() throws IOException {

        ps.setScreen("2");
             // no
        ObservableList<Ingredient> ingredients = choiceBoxController.getValues();

        CalculateRecipeBean recipeBean = new CalculateRecipeBean();
        recipeBean.setListIng(ingredients);

        CalculateRecipeController recipeController = new CalculateRecipeController();

        recipeBeans = recipeController.checkIngredients(recipeBean);

        General.changeScene(General.setSource("Result"));

    }




    @FXML
    private void clickFridgeButton() throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("SelectIngredients"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("SelectIngredients.fxml");
            General.changeScene(General.setSource("Login"));
        }
    }



    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {
        ps.setScreen("1");
        //ps.setScreen("2");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private void clickMenuLink2(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
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
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("Favourite.fxml");

            General.changeScene(General.setSource("Login"));
        }
    }
    @FXML
    private void clickMenuLink7(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
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
        General.changeScene(General.setSource("Home2"));
    }






}