package home.home2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReviewController implements Initializable {
    private int vote;
    private String click;
    private Image star;
    private Image starfilled;

    @FXML
    private Label alert;
    @FXML
    private TextField email;
    @FXML
    private TextArea note;
    @FXML
    private Button menuButton;
    @FXML
    private ImageView star1;
    @FXML
    private ImageView star2;
    @FXML
    private ImageView star3;
    @FXML
    private ImageView star4;
    @FXML
    private ImageView star5;
    @FXML
    private Pane menu;
    @FXML
    private Pane dark;
    private static final String LOGIN = "Login";


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
    private void clickMenuButton() {
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
    private void clickMenuLink1() throws IOException {
        PendentScreen ps3;
        ps3 = Home.getPS();
        ps3.setScreen("1");
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private void clickMenuLink2() throws IOException {
        PendentScreen ps4;
        ps4 = Home.getPS();
        if (Boolean.TRUE.equals(General.LOGINSTATE)) {
            General.changeScene(General.setSource("Insert"));
        } else {
            ps4.add("Insert.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink3() throws IOException {
        General.changeScene(General.setSource(LOGIN));
    }
    @FXML
    private void clickMenuLink4() throws IOException {
        General.changeScene(General.setSource("Subscribe"));
    }
    @FXML
    private void clickMenuLink5() throws IOException {
        General.changeScene(General.setSource("Review"));
    }
    @FXML
    private void clickMenuLink6() throws IOException {
        PendentScreen ps5 ;
        if (Boolean.TRUE.equals(General.LOGINSTATE)) {
            General.changeScene(General.setSource("Favourite"));
        } else {
            ps5 = Home.getPS();
            ps5.add("Favourite.fxml");

            General.changeScene(General.setSource(LOGIN));
        }
    }
    @FXML
    private void clickMenuLink7() throws IOException {
        PendentScreen ps6;
        ps6 = Home.getPS();
        if (Boolean.TRUE.equals(General.LOGINSTATE)) {
            General.changeScene(General.setSource("Fridge"));
        } else {
            ps6.add("Fridge.fxml");
            General.changeScene(General.setSource(LOGIN));
        }
    }


    public void clickStar(MouseEvent event) {
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
            default:
                break;
        }
    }
    public void hoverStar(MouseEvent event)  {
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
            default:
                break;
        }
    }
    public void releaseStar()  {
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
            default :
                break;
        }
    }

    @FXML
    private void clickSubmitButton() {
        String address = email.getText();
        String comment = note.getText();
        alert.setVisible(address.equals("") || comment.equals("") || vote == 0);

    }

}