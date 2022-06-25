package home.home2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Review2Controller implements Initializable {
    @FXML
    private ImageView star1, star2, star3, star4, star5;
    @FXML
    private TextField textTitle;
    @FXML
    private TextArea textDesc;

    private static int vote=0;

    private Image star = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\star.png");
    private Image starfilled = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\starfilled.png");

    private String click, title, description;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        star1.setImage(star);
        star2.setImage(star);
        star3.setImage(star);
        star4.setImage(star);
        star5.setImage(star);
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

    public void clickSubmit(ActionEvent event) throws IOException {
        title = textTitle.getText();
        description = textDesc.getText();

        System.out.println(title + "\n" + vote + "/5\n" + description);
    }
}
