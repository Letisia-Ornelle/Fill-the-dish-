package home.home2;

import home.home2.controller.AllRecipesController;
import home.home2.beans.CalculateRecipeBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home2.ps;

public class Result2Controller implements Initializable {

    @FXML
    private GridPane grid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        PendentScreen2 ps = Home2.getPS2();


        int column = 0;
        int row = 1;
        switch (ps.getScreen2()) {
            case "1":
                System.out.println("entro nel 1");
                AllRecipesController recipe = new AllRecipesController();
                List<CalculateRecipeBean> recipeBeans = new ArrayList<>();

                try {
                    recipeBeans = recipe.allRecipes();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    for (int j = 0; j < recipeBeans.size(); j++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("items2.fxml"));

                        Pane anchorPane = fxmlLoader.load();

                        Items2Controller item2Controller = fxmlLoader.getController();
                        item2Controller.setData(recipeBeans.get(j));

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
                InsertIngredients2Controller InsertIng2Controller = new InsertIngredients2Controller();

                try {
                    for (int j = 0; j < InsertIng2Controller.getRecipes().size(); j++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("items2.fxml"));

                        Pane anchorPane = fxmlLoader.load();

                        Items2Controller item2Controller = fxmlLoader.getController();
                        item2Controller.setData(InsertIng2Controller.getRecipes().get(j));

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
                SelectIngredients2Controller select2Controller = new SelectIngredients2Controller();
                try {
                    for (int j = 0; j < select2Controller.getRecipesBeans().size(); j++) {
                        FXMLLoader fxmlLoader = new FXMLLoader();

                        fxmlLoader.setLocation(getClass().getResource("items2.fxml"));

                        Pane anchorPane = fxmlLoader.load();

                        Items2Controller item2Controller = fxmlLoader.getController();
                        item2Controller.setData(select2Controller.getRecipesBeans().get(j));

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


    public void clickReviewButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Review2"));

    }

    public void clickFridgeButton(ActionEvent event) throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Fridge2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }

    }

    public void clickFavouriteButton(ActionEvent event) throws IOException {
        PendentScreen2 ps = Home2.getPS2();
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }

    }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Login2"));

    }

    public void clickAddButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Add2"));

    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Search2"));

    }

    public void clickHomeButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickBackButton(ActionEvent event) {
    }

    public void clickInsertIngredients(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }


}
