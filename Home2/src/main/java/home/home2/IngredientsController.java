package home.home2;

import home.home2.controller.CalculateRecipeController;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class IngredientsController implements Initializable {
    private static PendentScreen ps;

    private static final String LOGINSTRING = "Login";


    @FXML
    private Pane menu;
    @FXML
    private Pane dark;

    @FXML
    private GridPane grid;

    @FXML
    private Button menuButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
        dark.setVisible(false);

        int column = 0;
        int row = 1;
        try {


            for (int i = 0; i < 22; i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("dynamicCB.fxml"));
                Pane pane = fxmlLoader.load();
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
                GridPane.setMargin(pane, new Insets(50));
                grid.setAlignment(Pos.CENTER);
                GridPane.setHalignment(pane, HPos.CENTER);
                grid.setGridLinesVisible(false);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public IngredientsController()  {
        //
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
    private void clickRecipeButton() throws IOException {
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private static void clickFridgeButton() throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps = Home.getPS();
            ps.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGINSTRING));
        }
    }



    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private static void clickMenuLink2(ActionEvent event) throws IOException {
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
    private static void clickMenuLink6(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps = Home.getPS();
            ps.add("Favourite.fxml");
            General.changeScene(General.setSource(LOGINSTRING));
        }
    }
    @FXML
    private static void clickMenuLink7(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps = Home.getPS();
            ps.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGINSTRING));
        }
    }

}



