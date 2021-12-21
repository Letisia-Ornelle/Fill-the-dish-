package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertController implements Initializable {

    @FXML
    private Button menuButton;
    @FXML
    private Pane menu, dark;

    @FXML
    private ImageView dish1, dish2, dish3, dish4, dish5, dish6;

    private int i;
    private Boolean[] clicked = {false, false, false, false, false, false};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dark.setVisible(false);
        menu.setVisible(false);

        dish1.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        dish2.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        dish3.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        dish4.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        dish5.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        dish6.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
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
    private void clickDish1(MouseEvent event) throws IOException {
        System.out.println("Primi!");
        clicked[0] = true;

        dish2.setScaleX(1);
        dish2.setScaleY(1);
        dish3.setScaleX(1);
        dish3.setScaleY(1);
        dish4.setScaleX(1);
        dish4.setScaleY(1);
        dish5.setScaleX(1);
        dish5.setScaleY(1);
        dish6.setScaleX(1);
        dish6.setScaleY(1);

        for (i = 0; i < 6; i++) {
            if (i != 0) {
                clicked[i] = false;
            }
        }
    }
    @FXML
    private void clickDish2(MouseEvent event) throws IOException {
        System.out.println("Secondi!");
        clicked[1] = true;

        dish1.setScaleX(1);
        dish1.setScaleY(1);
        dish3.setScaleX(1);
        dish3.setScaleY(1);
        dish4.setScaleX(1);
        dish4.setScaleY(1);
        dish5.setScaleX(1);
        dish5.setScaleY(1);
        dish6.setScaleX(1);
        dish6.setScaleY(1);

        for (i = 0; i < 6; i++) {
            if (i != 1) {
                clicked[i] = false;
            }
        }
    }
    @FXML
    private void clickDish3(MouseEvent event) throws IOException {
        System.out.println("Contorni!");
        clicked[2] = true;

        dish1.setScaleX(1);
        dish1.setScaleY(1);
        dish2.setScaleX(1);
        dish2.setScaleY(1);
        dish4.setScaleX(1);
        dish4.setScaleY(1);
        dish5.setScaleX(1);
        dish5.setScaleY(1);
        dish6.setScaleX(1);
        dish6.setScaleY(1);

        for (i = 0; i < 6; i++) {
            if (i != 2) {
                clicked[i] = false;
            }
        }
    }
    @FXML
    private void clickDish4(MouseEvent event) throws IOException {
        System.out.println("Primi!");
        clicked[3] = true;

        dish2.setScaleX(1);
        dish2.setScaleY(1);
        dish3.setScaleX(1);
        dish3.setScaleY(1);
        dish1.setScaleX(1);
        dish1.setScaleY(1);
        dish5.setScaleX(1);
        dish5.setScaleY(1);
        dish6.setScaleX(1);
        dish6.setScaleY(1);

        for (i = 0; i < 6; i++) {
            if (i != 3) {
                clicked[i] = false;
            }
        }
    }
    @FXML
    private void clickDish5(MouseEvent event) throws IOException {
        System.out.println("Primi!");
        clicked[4] = true;

        dish2.setScaleX(1);
        dish2.setScaleY(1);
        dish3.setScaleX(1);
        dish3.setScaleY(1);
        dish4.setScaleX(1);
        dish4.setScaleY(1);
        dish1.setScaleX(1);
        dish1.setScaleY(1);
        dish6.setScaleX(1);
        dish6.setScaleY(1);

        for (i = 0; i < 6; i++) {
            if (i != 4) {
                clicked[i] = false;
            }
        }
    }
    @FXML
    private void clickDish6(MouseEvent event) throws IOException {
        System.out.println("Primi!");
        clicked[5] = true;

        dish2.setScaleX(1);
        dish2.setScaleY(1);
        dish3.setScaleX(1);
        dish3.setScaleY(1);
        dish4.setScaleX(1);
        dish4.setScaleY(1);
        dish5.setScaleX(1);
        dish5.setScaleY(1);
        dish1.setScaleX(1);
        dish1.setScaleY(1);

        for (i = 0; i < 6; i++) {
            if (i != 5) {
                clicked[i] = false;
            }
        }
    }

    @FXML
    private void hoverDish1(MouseEvent event) throws IOException {
        dish1.setScaleX(1.5);
        dish1.setScaleY(1.5);
    }
    @FXML
    private void releaseDish1(MouseEvent event) throws IOException {
        if (!clicked[0]) {
            dish1.setScaleX(1);
            dish1.setScaleY(1);
        }

    }
    @FXML
    private void hoverDish2(MouseEvent event) throws IOException {
        dish2.setScaleX(1.5);
        dish2.setScaleY(1.5);
    }
    @FXML
    private void releaseDish2(MouseEvent event) throws IOException {
        if (!clicked[1]) {
            dish2.setScaleX(1);
            dish2.setScaleY(1);
        }

    }
    @FXML
    private void hoverDish3(MouseEvent event) throws IOException {
        dish3.setScaleX(1.5);
        dish3.setScaleY(1.5);
    }
    @FXML
    private void releaseDish3(MouseEvent event) throws IOException {
        if (!clicked[2]) {
            dish3.setScaleX(1);
            dish3.setScaleY(1);
        }

    }
    @FXML
    private void hoverDish4(MouseEvent event) throws IOException {
        dish4.setScaleX(1.5);
        dish4.setScaleY(1.5);
    }
    @FXML
    private void releaseDish4(MouseEvent event) throws IOException {
        if (!clicked[3]) {
            dish4.setScaleX(1);
            dish4.setScaleY(1);
        }

    }
    @FXML
    private void hoverDish5(MouseEvent event) throws IOException {
        dish5.setScaleX(1.5);
        dish5.setScaleY(1.5);
    }
    @FXML
    private void releaseDish5(MouseEvent event) throws IOException {
        if (!clicked[4]) {
            dish5.setScaleX(1);
            dish5.setScaleY(1);
        }

    }
    @FXML
    private void hoverDish6(MouseEvent event) throws IOException {
        dish6.setScaleX(1.5);
        dish6.setScaleY(1.5);
    }
    @FXML
    private void releaseDish6(MouseEvent event) throws IOException {
        if (!clicked[5]) {
            dish6.setScaleX(1);
            dish6.setScaleY(1);
        }

    }

    @FXML
    private void clickSubmitButton() throws IOException{

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
        General.changeScene(General.setSource("Favourite"));
    }
    @FXML
    private void clickMenuLink7(ActionEvent event) throws IOException {
        if (General.loginState) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            General.changeScene(General.setSource("Login"));
        }
    }
    @FXML
    private void clickMenuLink8(ActionEvent event) throws IOException {
        if (Home.GUI==0) {
            Home.GUI=1;
            General.changeScene(General.setSource("Home2"));
        } else {
            Home.GUI=0;
            General.changeScene(General.setSource("Home"));
        }
    }


}
