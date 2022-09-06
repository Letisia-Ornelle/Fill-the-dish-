package home.home2;

import home.home2.Controller.calculateRecipeController;
import home.home2.Controller.manageFridgeController;
import home.home2.Beans.calculateRecipeBean;
import home.home2.Beans.fridgeBean;
import home.home2.Model.Ingredient;
import home.home2.Model.fridgeObserver;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home.ps;

public class SelectIngredientsController implements  Initializable, fridgeObserver {
    @FXML
    Button backButton;
    @FXML
    Button homeButton;
    @FXML
    Button calcolaRicetta;

    @FXML
    private Button menuButton;
    @FXML
    private Pane menu, dark;
    @FXML
    private VBox verticalBox;

    private static PendentScreen pendent ;

    // Devo semplicemente inizializzare la schermata con gli elementi presenti nella lista restituita nel controller di managefridge

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Home h = new Home();
        pendent = h.getPS();

        menu.setVisible(false);
        dark.setVisible(false);

        manageFridgeController manageFridge = new manageFridgeController();
        List<fridgeBean> fridgeBeans ;

        fridgeBeans = manageFridge.showFridge();

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

    private static List<calculateRecipeBean> recipeBeans = new ArrayList<>();

    @FXML
    private void recipesFridge(ActionEvent event) throws IOException {
        System.out.println("ciao!!!!");
        pendent.setScreen("3");
        ElementSelectionController elementController = new ElementSelectionController();

        calculateRecipeController recipeController = new calculateRecipeController();
        calculateRecipeBean recipeBean = new calculateRecipeBean();

        ObservableList<Ingredient> FridgeIngredients = elementController.getFridgeIngredients();

        recipeBean.setListIng(FridgeIngredients);

        recipeBeans =  recipeController.checkIngredients(recipeBean);


        General.changeScene(General.setSource("Result"));
    }

    public List<calculateRecipeBean> getRecipesBeans(){
        return recipeBeans;
    }

    @Override
    public void update(fridgeBean fridgebean) {
    }

    public void clickMenuLink1(ActionEvent actionEvent) throws IOException {
        pendent.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
}