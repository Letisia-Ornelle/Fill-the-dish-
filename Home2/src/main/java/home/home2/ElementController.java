package home.home2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ElementController {
    @FXML
    private Button name;
    @FXML
    private ImageView img, select;
    @FXML
    private Button removeRecipe;
    @FXML
    private Pane cover;

    private Element elem;
    public static ArrayList list = new ArrayList();

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

    @FXML
    public void clickSelect(MouseEvent event) throws IOException {

        //System.out.println("Selezionato ingrediente: " + name.getText());

        if (list.contains(name.getText())) {
            list.remove(name.getText());
            select.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectRelease.png"));
        } else {
            select.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
            list.add(name.getText());
        }

        /*
        // verifico la correttezza
        int i;
        for (i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        */
    }



}
