package home.home2;

import home.home2.Model.Beans.ingredientBean;
import home.home2.Model.DAO.recipeDAO;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class InsertIngredientsController implements Initializable {
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

    @FXML
    private GridPane grid;
    int column = 0 ;
    int row  = 3;


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
      /*  choiceBox1.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox2.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox3.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox4.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox5.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox6.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox7.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");
        choiceBox8.getItems().addAll("ingrediente1      ","ingrediente2      ","ingrediente3      ");


        choiceBox1.setValue("Seleziona un ingrediente");
        choiceBox2.setValue("Seleziona un ingrediente");
        choiceBox3.setValue("Seleziona un ingrediente");
        choiceBox4.setValue("Seleziona un ingrediente");
        choiceBox5.setValue("Seleziona un ingrediente");
        choiceBox6.setValue("Seleziona un ingrediente");
        choiceBox7.setValue("Seleziona un ingrediente");
        choiceBox8.setValue("Seleziona un ingrediente");*/


        try {
            popolaChoiceBox();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void popolaChoiceBox() throws SQLException {

        int column = 0 ;
        int row  = 1;

        System.out.println("Ciao1");
        ObservableList<String> list ;
        ObservableList<ingredientBean> ingredientBeans = FXCollections.observableArrayList();


        list = recipeDAO.allIngredients();
        for(String k : list){
            System.out.println(k);
        }

        int size = ingredientBeans.size();
        try {

            for(int i=0;i<22;i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("dynamicCB.fxml"));
                Pane pane = fxmlLoader.load();
                // pane = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

                DynamicCBController dynamicCBController = fxmlLoader.getController();
                System.out.println("Ciao2");

                /*for(int j=0; j<size; j++){
                    dynamicCBController.setData(list.get(j));

                }*/

                /*for(ingredientBean j : ingredientBeans){
                    ingredientBeans = calculateRecipeController.addInChooseBox(j);

                    System.out.println(j.getIngredientName());

                }
                dynamicCBController.setData(ingredientBeans);*/

                System.out.println("CISONDSOKJDN");
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
    } catch (IOException ex) {
            ex.printStackTrace();
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
    private void clickFridgeButton() throws IOException {
        if (General.loginState) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("SelectIngredients.fxml");
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
            ps.add("SelectIngredients.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login"));
        }
    }
    @FXML
    private void clickMenuLink8(ActionEvent event) throws IOException {

        Home.GUI=1;
        General.changeScene(General.setSource("Home2"));
    }





    }



