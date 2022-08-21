package home.home2;

import home.home2.Controller.manageFridgeController;
import home.home2.Element;
import home.home2.Model.Beans.fridgeBean;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

        // All'inizializzazione , devo recuperare la lista di ingredienti dell'utente

        List<fridgeBean> fridgeBeans = null;
        manageFridgeController fridgeController = new manageFridgeController();

        try{
            fridgeBeans = fridgeController.showFridge();
        }catch(SQLException e){
            e.printStackTrace();
        }

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
            fridgeBean fridge = new fridgeBean();
            fridge.setIngredientName(textField.getText());

            manageFridgeController manageFridge = new manageFridgeController();


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
    public void update(fridgeBean fridgebean) {

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
        General.changeScene(General.setSource("Review2"));
    }

    public void clickFridgeButton(ActionEvent event) throws IOException {

    }

    public void clickFavouriteButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Favourite2"));
    }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Login2"));
    }

    public void clickAddButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Add2"));
    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Search2"));
    }
}
