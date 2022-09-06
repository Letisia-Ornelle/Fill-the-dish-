package home.home2;

import home.home2.controller.ManageFridgeController;
import home.home2.beans.FridgeBean;
import home.home2.Model.Exceptions.duplicateIngredientException;
import home.home2.Model.fridgeObserver;
import home.home2.Model.fridgeSubject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home2.ps;

public class Fridge2Controller implements Initializable, fridgeObserver {

    @FXML
    private VBox verticalBox;

    @FXML
    private Button aggiungi;

    @FXML
    private TextField textField;

    // Manca il login !

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i;

        fridgeSubject.attach(this);

        List<FridgeBean> fridgeBeans ;
        ManageFridgeController fridgeController = new ManageFridgeController();

        fridgeBeans = fridgeController.showFridge();

        for(i = 0; i<fridgeBeans.size();i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ElementFridge2.fxml"));

            try {
                Pane anchorPane = fxmlLoader.load();
                ElementController2 elementController2 = fxmlLoader.getController();

                elementController2.setData(fridgeBeans.get(i));

                verticalBox.getChildren().add(anchorPane);
                verticalBox.setMargin(anchorPane, new Insets(5));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void AddToFridge(ActionEvent event) throws SQLException, duplicateIngredientException {

        if(textField.getText() != "") {
            FridgeBean fridge = new FridgeBean();
            fridge.setIngredientName(textField.getText());

            ManageFridgeController manageFridge = new ManageFridgeController();


                if (manageFridge.getImage(fridge) == true) {
                    System.out.println("Qui bisogna inserire l'immagine presa dal dataBase");
                }
                else{
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.jpg,*.png", "*.jpg", "*.png"));
                    File file = fileChooser.showOpenDialog(null);
                    if(file != null){
                        String imagePath = file.getAbsolutePath();
                        InputStream inputStream = null;
                        try{
                            inputStream = new FileInputStream(imagePath);
                            fridge.setIngredientInputStream(new FileInputStream(imagePath));
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }
                        Image image = new Image(inputStream);
                        fridge.setIngredientImage(image);
                    }
                }

                manageFridge.addIngredient(fridge);
                textField.setText("");

            }
        }

    @Override
    public void update(FridgeBean fridgebean) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ElementFridge2.fxml"));
        try{
            Pane anchorPane = fxmlLoader.load();

            ElementController2 elementController2 = fxmlLoader.getController();
            elementController2.setData(fridgebean);

            verticalBox.getChildren().add(anchorPane);
            verticalBox.setMargin(anchorPane, new Insets(5));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void clickInterfaceButton(ActionEvent event) {
    }

    public void clickReviewButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }

    public void clickFridgeButton(ActionEvent event) throws IOException {

    }

    public void clickFavouriteButton(ActionEvent event) throws IOException {
        if (General2.loginState) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }      }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Login2"));
    }

    public void clickAddButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Add2"));
    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Search2"));
    }

    public void clickBackButton(ActionEvent actionEvent) {


    }

    public void clickHomeButton(ActionEvent actionEvent) throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickInsertIngredients(ActionEvent event) {
    }

    public void clickRecipesButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Result2"));
    }
}
