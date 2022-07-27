package home.home2;

import home.home2.Model.Element;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ElementController implements Initializable {
    @FXML
    private Button name;
    @FXML
    private ImageView img, select;
    @FXML
    private Button removeRecipe;
    @FXML
    private Pane cover;
    private Image image1;

    private Element elem;
    public static ArrayList list = new ArrayList();
    //private static List<Element> elements = General.Elements;

    public void setData(Element elem) {
        this.elem = elem;
        name.setText(elem.getTitle());
        Image image = new Image(getClass().getResourceAsStream(elem.getImgSrc()));
        img.setImage(image);
    }

    @FXML
    public void clickRemoveRecipe(MouseEvent event) throws IOException {
        General.removeEl(this.elem.getTitle());
        General.changeScene(General.setSource("Favourite"));
    }

    @FXML
    public void clickSelect(MouseEvent event) throws IOException {

        //System.out.println("Selezionato ingrediente: " + name.getText());

        if (list.contains(name.getText())) {
            list.remove(name.getText());
            /*if (select.getImage() == image1){
                if (event.getSource()==select){
                    select.setImage(image2);

                }

            }
            if (select.getImage() == image2 ){
                if (event.getSource()==select ){
                    select.setImage(image1);

                }
            }


            //select.setImage(image1);

            // select.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectRelease.png"));
        } else {
           // select.setImage(image1);
            if (select.getImage() == image1){
                if (event.getSource()==select){
                    select.setImage(image2);

                }

            }
            if (select.getImage() == image2){
                if (event.getSource()==select){
                    select.setImage(image1);

                }
            }
            */

            //  select.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        image1 = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\true.png");
    }

    public void select(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == select) {
            select.setImage(image1);
        }

    }

}