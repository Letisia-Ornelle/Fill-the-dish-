package home.home2;

import home.home2.controller.ManageFridgeController;
import home.home2.beans.FridgeBean;
import home.home2.model.exceptions.DuplicateIngredientException;
import home.home2.model.FridgeObserver;
import home.home2.model.FridgeSubject;
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
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home2.ps;


public class Fridge2Controller implements Initializable, FridgeObserver {



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

        FridgeSubject.attach(this);

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
                VBox.setMargin(anchorPane, new Insets(5));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void addToFridge() throws  DuplicateIngredientException {

        if(!textField.getText().equals("")) {
            FridgeBean fridge = new FridgeBean();
            fridge.setIngredientName(textField.getText());

            ManageFridgeController manageFridge = new ManageFridgeController();


                if (manageFridge.getImage(fridge)) {
                    //
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
            VBox.setMargin(anchorPane, new Insets(5));
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public void clickReviewButton() throws IOException {
        General2.changeScene(General2.setSource("Review2"));
    }

    public void clickFridgeButton() throws IOException {
        //
    }

    public  void clickFavouriteButton() throws IOException {
        PendentScreen2 ps;

        if (Boolean.TRUE.equals(General2.LOGINSTATE)) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            ps = Home2.getPS2();
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }      }

    public void clickLoginButton() throws IOException {
        General2.changeScene(General2.setSource("Login2"));
    }

    public void clickAddButton() throws IOException {
        General2.changeScene(General2.setSource("Add2"));
    }

    public void clickSearchButton() throws IOException {
        General2.changeScene(General2.setSource("Search2"));
    }

    public void clickBackButton() {
        //
    }

    public void clickHomeButton() throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickInsertIngredients() throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButton() throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
}
