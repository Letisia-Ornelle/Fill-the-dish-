package home.home2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Search2Controller implements Initializable {
    Boolean[] portata = new Boolean[6];
    @FXML
    private ImageView primi, secondi, contorni, colazioni, dessert, antipasti;
    @FXML
    private GridPane grid;

    private PendentScreen2 ps;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i;
        int column = 0, row = 1;

        for (i=0;i<6;i++) {
            portata[i] = false;
        }
        primi.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        primi.setScaleX(0.5);
        primi.setScaleY(0.5);

        secondi.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        secondi.setScaleX(0.5);
        secondi.setScaleY(0.5);

        contorni.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        contorni.setScaleX(0.5);
        contorni.setScaleY(0.5);

        colazioni.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        colazioni.setScaleX(0.5);
        colazioni.setScaleY(0.5);

        dessert.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        dessert.setScaleX(0.5);
        dessert.setScaleY(0.5);

        antipasti.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        antipasti.setScaleX(0.5);
        antipasti.setScaleY(0.5);


    }

    public void clickSearch(ActionEvent event) throws IOException {
        // niente per ora
    }

    // utente seleziona un filtro
    public void selectPrimi(MouseEvent event) {
        if (portata[0] == true) {
            portata[0] = false;
            primi.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        } else {
            portata[0] = true;
            primi.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        }
    }
    public void selectSecondi(MouseEvent event) {
        if (portata[1] == true) {
            portata[1] = false;
            secondi.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        } else {
            portata[1] = true;
            secondi.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        }
    }
    public void selectContorni(MouseEvent event) {
        if (portata[2] == true) {
            portata[2] = false;
            contorni.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        } else {
            portata[2] = true;
            contorni.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        }
    }
    public void selectColazioni(MouseEvent event) {
        if (portata[3] == true) {
            portata[3] = false;
            colazioni.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        } else {
            portata[3] = true;
            colazioni.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        }
    }
    public void selectDessert(MouseEvent event) {
        if (portata[4] == true) {
            portata[4] = false;
            dessert.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        } else {
            portata[4] = true;
            dessert.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        }
    }
    public void selectAntipasti(MouseEvent event) {
        if (portata[5] == true) {
            portata[5] = false;
            antipasti.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        } else {
            portata[5] = true;
            antipasti.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
        }
    }

    // utente passa il mouse su un filtro
    public void hoverPrimi(MouseEvent event) throws IOException {
        primi.setScaleX(1.5);
        primi.setScaleY(1.5);
    }
    public void hoverSecondi(MouseEvent event) throws IOException {
        secondi.setScaleX(1.5);
        secondi.setScaleY(1.5);
    }
    public void hoverContorni(MouseEvent event) throws IOException {
        contorni.setScaleX(1.5);
        contorni.setScaleY(1.5);
    }
    public void hoverColazioni(MouseEvent event) throws IOException {
        colazioni.setScaleX(1.5);
        colazioni.setScaleY(1.5);
    }
    public void hoverDessert(MouseEvent event) throws IOException {
        dessert.setScaleX(1.5);
        dessert.setScaleY(1.5);
    }
    public void hoverAntipasti(MouseEvent event) throws IOException  {
        antipasti.setScaleX(1.5);
        antipasti.setScaleY(1.5);
    }

    // utente toglie il mouse dal filtro
    public void releasePrimi(MouseEvent event) throws IOException {
        primi.setScaleX(0.5);
        primi.setScaleY(0.5);
    }
    public void releaseSecondi(MouseEvent event) throws IOException {
        secondi.setScaleX(0.5);
        secondi.setScaleY(0.5);
    }
    public void releaseContorni(MouseEvent event) throws IOException {
        contorni.setScaleX(0.5);
        contorni.setScaleY(0.5);
    }
    public void releaseColazioni(MouseEvent event) throws IOException {
        colazioni.setScaleX(0.5);
        colazioni.setScaleY(0.5);
    }
    public void releaseDessert(MouseEvent event) throws IOException {
        dessert.setScaleX(0.5);
        dessert.setScaleY(0.5);
    }
    public void releaseAntipasti(MouseEvent event) throws IOException {
        antipasti.setScaleX(0.5);
        antipasti.setScaleY(0.5);
    }

    // utente rimuove un filtro
    public void removeFilter() {
        int i;
        for (i=0;i<6;i++) {
            portata[i] = false;
        }

        primi.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        secondi.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        contorni.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        colazioni.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        dessert.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));
        antipasti.setImage(new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\sfondo_home2.png"));


    }

    /*private List<Element> elements = new ArrayList<>();

    private List<Element> getData() {
        int i;
        List<Element> elements = new ArrayList<>();
        Element elem;

        for (i=0;i<10;i++) {
            elem = new Element();
            elem.setTitle("Pasta Alla Carbonara");
            elem.setImgSrc("im3.jpg");
            elements.add(elem);
        }
        return elements;
    }*/

    public void clickInterfaceButton(ActionEvent event) {
        // No
    }

    public void clickReviewButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Review2"));
    }

    public void clickFridgeButton(ActionEvent event) throws IOException {
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Fridge2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Fridge2.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login2"));
        }
    }

    public void clickFavouriteButton(ActionEvent event) throws IOException {
        if (General2.LOGINSTATE) {
            General2.changeScene(General2.setSource("Favourite2"));
        } else {
            Home2 m = new Home2();
            ps = m.getPS2();
            ps.add("Favourite2.fxml");
            General2.changeScene(General2.setSource("Login2"));
        }
    }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General2.changeScene(General.setSource("Login2"));
    }

    public void clickAddButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Add2"));
    }

    public void clickSearchButton(ActionEvent event) throws IOException {
     // General2.changeScene(General2.setSource("Search2"));
    }

    public void clickHomeButton(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Home2"));
    }

    public void clickBackButton(ActionEvent event) throws IOException {
    }

    public void clickInsertIngredients(ActionEvent event) throws IOException {
        General2.changeScene(General2.setSource("Ingredients2"));
    }

    public void clickRecipesButton(ActionEvent event) throws IOException {
        ps.setScreen2("1");
        General2.changeScene(General2.setSource("Result2"));
    }
}
