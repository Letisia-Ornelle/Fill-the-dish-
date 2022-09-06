package home.home2;

import home.home2.Controller.allRecipesController;
import home.home2.Model.Beans.calculateRecipeBean;
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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ResultController implements Initializable {
    @FXML
    GridPane grid;
    @FXML
    Button homeButton, menuButton, backButton;
    @FXML
    private Pane menu, dark;

    @FXML
    Label category;

    private static PendentScreen ps;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dark.setVisible(false);
        menu.setVisible(false);

        Home m = new Home();
        ps = m.getPS();


        int column = 0;
        int row = 1;


        switch (ps.getScreen()) {
            case "1":
                System.out.println("entro nel 1");
                allRecipesController recipe = new allRecipesController();
                List<calculateRecipeBean> recipeBeans = new ArrayList<>();

                try {
                    recipeBeans = recipe.allRecipes();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    for (int j = 0; j < recipeBeans.size(); j++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                        Pane anchorPane = fxmlLoader.load();

                        ItemsController itemController = fxmlLoader.getController();
                        itemController.setData(recipeBeans.get(j));

                        if (column == 2) {
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

                        grid.add(anchorPane, column++, row);
                        grid.setMargin(anchorPane, new Insets(100));
                        grid.setAlignment(Pos.CENTER);
                        grid.setHalignment(anchorPane, HPos.LEFT);
                        grid.setGridLinesVisible(false);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;


            case "2":

                System.out.println("entro nel 2");
                InsertIngredientsController InsertIngController = new InsertIngredientsController();

                try {
                    for (int j = 0; j < InsertIngController.getRecipes().size(); j++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                        Pane anchorPane = fxmlLoader.load();

                        ItemsController itemController = fxmlLoader.getController();
                        itemController.setData(InsertIngController.getRecipes().get(j));

                        if (column == 2) {
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

                        grid.add(anchorPane, column++, row);
                        grid.setMargin(anchorPane, new Insets(100));
                        grid.setAlignment(Pos.CENTER);
                        grid.setHalignment(anchorPane, HPos.LEFT);
                        grid.setGridLinesVisible(false);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "3":

                System.out.println("entro nel 3");
                SelectIngredientsController selectController = new SelectIngredientsController();
                try {
                    for (int j = 0; j < selectController.getRecipesBeans().size(); j++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                        Pane anchorPane = fxmlLoader.load();

                        ItemsController itemController = fxmlLoader.getController();
                        itemController.setData(selectController.getRecipesBeans().get(j));

                        if (column == 2) {
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

                        grid.add(anchorPane, column++, row);
                        grid.setMargin(anchorPane, new Insets(100));
                        grid.setAlignment(Pos.CENTER);
                        grid.setHalignment(anchorPane, HPos.LEFT);
                        grid.setGridLinesVisible(false);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;


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

    // forse c'è già un altro metodo identico in itemsController
    private void clickRecipeButton() throws IOException {
      ///  General.changeScene(General.setSource("Recipe"));
    }


    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {
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
        Home.GUI = 1;
        General.changeScene(General.setSource("Home2"));

    }

}


