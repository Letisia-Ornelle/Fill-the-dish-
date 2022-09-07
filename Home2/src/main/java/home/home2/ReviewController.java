package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReviewController implements Initializable {
    private int vote;
    private String click;
    private String address, comment;
    private static PendentScreen ps;
    private Image star, starfilled;

    @FXML
    private Label alert;
    @FXML
    private TextField email;
    @FXML
    private TextArea note;
    @FXML
    private Button menuButton;
    @FXML
    private ImageView star1, star2, star3, star4, star5;
    @FXML
    private Pane menu, dark;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
        dark.setVisible(false);
        alert.setVisible(false);

        vote = 0;
        star = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\star.png");
        starfilled = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\starfilled.png");

        star1.setImage(star);
        star2.setImage(star);
        star3.setImage(star);
        star4.setImage(star);
        star5.setImage(star);

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
        ps.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private void clickMenuLink2(ActionEvent event) throws IOException {
        if (General.LOGINSTATE) {
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
        if (General.LOGINSTATE) {
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
        if (General.LOGINSTATE) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("Fridge.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login"));
        }
    }


    public void clickStar(MouseEvent event) throws IOException {
        click = event.getPickResult().getIntersectedNode().getId();
        switch (click) {
            case "star1":
                star1.setImage(starfilled);
                vote = 1;
                break;
            case "star2":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                vote = 2;
                break;
            case "star3":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                vote = 3;
                break;
            case "star4":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                star4.setImage(starfilled);
                vote = 4;
                break;
            case "star5":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                star4.setImage(starfilled);
                star5.setImage(starfilled);
                vote = 5;
                break;
        }
    }
    public void hoverStar(MouseEvent event) throws IOException {
        click = event.getPickResult().getIntersectedNode().getId();
        switch (click) {
            case "star1":
                star1.setImage(starfilled);
                break;
            case "star2":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                break;
            case "star3":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                break;
            case "star4":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                star4.setImage(starfilled);
                break;
            case "star5":
                star1.setImage(starfilled);
                star2.setImage(starfilled);
                star3.setImage(starfilled);
                star4.setImage(starfilled);
                star5.setImage(starfilled);
                break;
        }
    }
    public void releaseStar(MouseEvent event) throws IOException {
        switch (vote) {
            case 0:
                star1.setImage(star);
                star2.setImage(star);
                star3.setImage(star);
                star4.setImage(star);
                star5.setImage(star);
                break;
            case 1:
                star2.setImage(star);
                star3.setImage(star);
                star4.setImage(star);
                star5.setImage(star);
                break;
            case 2:
                star3.setImage(star);
                star4.setImage(star);
                star5.setImage(star);
                break;
            case 3:
                star4.setImage(star);
                star5.setImage(star);
                break;
            case 4:
                star5.setImage(star);
                break;
        }
    }

    @FXML
    private void clickSubmitButton(ActionEvent event) throws IOException {
        address = email.getText();
        comment = note.getText();
        if (address != "" && comment != "" && vote != 0) {
            alert.setVisible(false);
            System.out.println("Recensione di " + address + ": \n" + comment + "\nValutazione: " + String.valueOf(vote) + "/5");
            // conferma di avvenuta sottomissione
        } else {
            alert.setVisible(true);
        }

    }

}