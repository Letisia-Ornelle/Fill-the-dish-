package home.home2;

import home.home2.Controller.calculateRecipeController;
import home.home2.Controller.favouritesController;
import home.home2.Beans.calculateRecipeBean;
import home.home2.Beans.favouritesBean;
import home.home2.Beans.ingredientBean;
import home.home2.Model.Exceptions.duplicateRecipeException;
import home.home2.Model.Exceptions.provideLoginException;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RecipeController implements Initializable {
    Boolean inFavourite;
    private static PendentScreen ps;
    Image heart = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\heart.png");
    Image check = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\true.png");

    @FXML
    Button menuButton, homeButton, backButton;
    @FXML
    private Pane menu, dark;
    @FXML
    private ImageView favButton;

    @FXML
    private ImageView recipeImg;
    @FXML
    private Label recipeName;

    @FXML
    private Text recipeDescription;

    @FXML
    private VBox verticalBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
        dark.setVisible(false);
        favButton.setImage(heart);
        inFavourite = false;

        Home m = new Home();
        ps = m.getPS();

        recipeName.setText(ps.getName());
        recipeImg.setImage(ps.getImage());
        recipeDescription.setText(ps.getDescription());
        System.out.println(ps.getDescription());
        System.out.println(ps.getType());

        // A questo punto , chiamo la bean e poi il controller applicativo passando la bean come parametro
        // Recuperando cosi la lista di ingredienti

        calculateRecipeBean recipeBean = new calculateRecipeBean();
        recipeBean.setName(recipeName.getText());


        calculateRecipeController recipeController = new calculateRecipeController();
        List<ingredientBean> ingredientBeanList = recipeController.getIngredients(recipeBean);

        // Ok devo iterare su questa lista e aggiungere in modo progressivo il coso nel verticalBox

        for(int i=0; i<ingredientBeanList.size();i++){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ingredient.fxml"));

                Pane anchorPane = fxmlLoader.load();

                IngredientController ingredientController = fxmlLoader.getController();
                ingredientController.setData(ingredientBeanList.get(i));

                verticalBox.getChildren().add(anchorPane);
                verticalBox.setMargin(anchorPane, new Insets(2));

            }catch(IOException e){
                e.printStackTrace();
            }

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


    @FXML
    private void clickFavButton(MouseEvent event) throws IOException {

        favouritesBean favBean = new favouritesBean();
        favBean.setRecipeName(recipeName.getText());
        favouritesController favController;
        try{
            favController = new favouritesController();

                if (General.loginState) {

                    favController.addToFavourites(favBean);

                }
            } catch (duplicateRecipeException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Attenzione, questa ricetta è già presente nella lista dei preferiti");
                alert.show();
            }catch(provideLoginException e1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Attenzione, devi prima fare il login");
                alert.show();
            }finally {
                if(!General.loginState){
                    Home m = new Home();
                    ps = m.getPS();
                    ps.add("Recipe.fxml");
                    General.changeScene(General.setSource("Login"));
                }
        }

    }

    @FXML
    private void hoveredButton(MouseEvent event) throws IOException {
        favButton.setScaleX(1.2);
        favButton.setScaleY(1.2);
    }
    @FXML
    private void ReleaseButton(MouseEvent event) throws IOException {
        favButton.setScaleX(1);
        favButton.setScaleY(1);
    }


}