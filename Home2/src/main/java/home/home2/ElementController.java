package home.home2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class ElementController {
    @FXML
    private Button name;
    @FXML
    private ImageView img, select;
    @FXML
    private Button removeRecipe;

    private Element elem;

    public void setData(Element elem) {
        this.elem = elem;
        name.setText(elem.getTitle());
        Image image = new Image(getClass().getResourceAsStream(elem.getImgSrc()));
        img.setImage(image);
    }

    @FXML
    public void clickRemoveRecipe(ActionEvent event) throws IOException {
        // rimuovere elemento dalla lista
    }
}
