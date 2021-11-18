package home.home2;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class HomeController implements Initializable {

    @FXML
    private Pane menu;

    @FXML
    private static Pane rightpane;

    @FXML
    private static Pane leftpane;

    @FXML
    private static Button homeLeftButton;

    @FXML
    private static Button homeRightButton;

    @FXML
    private Button menuButton;

    @FXML
    private static Button menuLink1;
    private static Button menuLink2;
    private static Button menuLink3;
    private static Button menuLink4;
    private static Button menuLink5;


/*
    @FXML
    private void clickMenuButton1(ActionEvent event) throws IOException {
        //goToMenu();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BackgroundMenu.fxml")));
        Scene scene = menuButton.getScene();

        root.translateXProperty().set(scene.getHeight());
        pane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
    }

    @FXML
    private void clickMenuButton() throws IOException {
        if (menu.isVisible()) {
            menu.setVisible(false);
            menuButton.setLayoutX(15);
        } else {
            menu.setVisible(true);
            menuButton.setLayoutX(255);
        }
    }

    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {

    }

    @FXML
    private void clickMenuLink2(ActionEvent event) throws IOException {
        if (General.loginState) {
            //goToHome();
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

    }
}