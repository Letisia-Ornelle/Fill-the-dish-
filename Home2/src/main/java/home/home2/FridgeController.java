package home.home2;


import home.home2.Controller.manageFridgeController;
import home.home2.Model.Beans.fridgeBean;
import home.home2.Model.Exceptions.duplicateIngredientException;
import home.home2.Model.fridgeObserver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FridgeController implements Initializable, fridgeObserver {
    private int row;

    @FXML
    private VBox verticalBox;

    @FXML
    private Button aggiungi;

    private String imageURL = "C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\basilico.jpg";

    @FXML
    private TextField textField;

    @FXML
    private Pane menu, dark;
    @FXML
    private Button recipeButton, fridgeButton, menuButton;

    public void clickBackButton(ActionEvent actionEvent) throws IOException {
        General.setBackScene();
    }


    public void clickHomeButton(ActionEvent actionEvent) throws IOException {
        General.changeScene(General.setSource("Home"));
    }

    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Result"));
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
        // niente
    }
    @FXML
    private void clickMenuLink8(ActionEvent event) throws IOException {
        Home.GUI=1;
        General.changeScene(General.setSource("Home2"));
    }


    public void clickMenuButton(ActionEvent actionEvent) {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
        dark.setVisible(false);

        manageFridgeController fridge = new manageFridgeController();
        List<fridgeBean> fridgeBeans = new ArrayList<>();
        try {
            fridgeBeans = fridge.showFridge();
            System.out.println("Lista mantenuta?");
            for(fridgeBean j : fridgeBeans){
                System.out.println(j.getIngredientImage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for(int i=0; i<fridgeBeans.size();i++){
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("ElementFridge.fxml"));
            try{
                Pane anchorPane = fxmlloader.load();
                ElementController elementController = fxmlloader.getController();

                elementController.setData2(fridgeBeans.get(i));

                verticalBox.getChildren().add(anchorPane);
                verticalBox.setMargin(anchorPane, new Insets(5));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void addImageToIngredient(fridgeBean fridgebean){

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.jpg,*.png","*.jpg","*.png"));
        File file = fileChooser.showOpenDialog(null);
        if(file!=null) {
            String imagePath = file.getAbsolutePath();
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(imagePath);
                fridgebean.setIngredientInputStream(new FileInputStream(imagePath));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Image image = new Image(inputStream);
            fridgebean.setIngredientImage(image);
        }

    }

    public VBox getResults(){
        return this.verticalBox;
    }

    public void AddToFridge(ActionEvent event) throws IOException, SQLException, duplicateIngredientException {


        if(textField.getText() != "") {
            fridgeBean f = new fridgeBean();

            f.setIngredientName(textField.getText());
            //  f.setIngredientInputStream(new FileInputStream(imageURL));

            manageFridgeController fridge = new manageFridgeController();


            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("ElementFridge.fxml"));
            Pane anchorPane = fxmlloader.load();

            ElementController elementController = fxmlloader.getController();

            //fridge.getImage(f);

            if (fridge.getImage(f) == true) {
                System.out.println("Ehi sono qui 1");
                // Devo convertire l'immagine recuperata dal DATABASE in inputStream in modo da reinserirla ( In frigo)
                // Quindi recupero il path dell'immagine restituita
                elementController.setData2(f);
            } else {

               // anchorPane.setOnMouseClicked(event1 -> addImageToIngredient(f));

                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.jpg,*.png", "*.jpg", "*.png"));
                File file = fileChooser.showOpenDialog(null);
                if (file != null) {
                    String imagePath = file.getAbsolutePath();
                    InputStream inputStream = null;
                    try {
                        inputStream = new FileInputStream(imagePath);
                        f.setIngredientInputStream(new FileInputStream(imagePath));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Image image = new Image(inputStream);
                    f.setIngredientImage(image);


                    elementController.setData2(f);
                }

            }
            fridge.addIngredient(f);
                verticalBox.getChildren().add(anchorPane);
                verticalBox.setMargin(anchorPane, new Insets(5));

                textField.setText("");
            }




            // Devo settare pure l'immagine di f prima di aggiungere

            // Posso fare tipo else ... metto un alert ????


    }

    @Override
    public void update(fridgeBean fridgebean) {
        // Ahahahahahahha bella merda -- > in che modo voglio fare l'update ? i don't knowwwwwwwwwwww
        // Teoricamente voglio aggiungere l'ingrediente alla lista ogni volta che l'utente sceglie
        // L'immagine --> Come ? forse a l'onClick devo solo recuperare l'immagine
        // e poi su update, devo aggiungere le diverse componenti al VBox????....
        // cioè fare l'update della lista, ma come ?
    }
}
