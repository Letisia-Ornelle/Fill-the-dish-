/*
package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ResultController implements Initializable {

    //private Label welcomeText;

    @FXML
    GridPane grid;

    @FXML
    Button backButton;

    @FXML
    Button homeButton;
    @FXML
    private Button menuButton;
    @FXML
    private Pane menu, dark;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dark.setVisible(false);
        menu.setVisible(false);


        ricette.addAll(getData());
        int column = 0;
        int row = 1;
        try {
            for(int i=0; i<ricette.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                //fxmlLoader.setController(new SearchRecipe2());
                fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                Pane anchorPane = fxmlLoader.load();

                ItemsController itemController = fxmlLoader.getController();
                itemController.setData(ricette.get(i));

                if(column == 3){
                    column = 0;
                    row++;
                }

                // set grid width
               grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                // set grid height
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                grid.add(anchorPane,column++, row);
                GridPane.setMargin(anchorPane, new Insets(55));
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
    private void clickRecipeButton() throws IOException {
        General.changeScene(General.setSource("Recipe"));
    }


    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {

    }
    @FXML
    private void clickMenuLink2(ActionEvent event) throws IOException {
        if (General.loginState) {
            General.changeScene(General.setSource("Insert"));
        } else {
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
    private List<Recipe> ricette = new ArrayList<>();

    private List<Recipe> getData(){
        List<Recipe> ricette = new ArrayList<>();
        Recipe ricetta;

        for(int i = 0; i<40;i++){
            ricetta = new Recipe();
            ricetta.setName("Carbonara");
            ricetta.setImgSrc("Carbonara.png");

            ricette.add(ricetta);

            ricetta = new Recipe();
            ricetta.setName("Panna");
            ricetta.setImgSrc("im2.jpg");

            ricette.add(ricetta);

            ricetta = new Recipe();
            ricetta.setName("Pasta");
            ricetta.setImgSrc("im1.png");

            ricette.add(ricetta);


            ricetta = new Recipe();
            ricetta.setName("carne");
            ricetta.setImgSrc("carne.jpg");

            ricette.add(ricetta);

        }
        return ricette;
    }

}
*/