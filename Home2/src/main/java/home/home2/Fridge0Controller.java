package home.home2;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import jdk.internal.org.objectweb.asm.tree.InsnList;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import java.io.IOException;

public class Fridge0Controller implements Initializable{
    private int row;

    @FXML
    private GridPane grid;

    public void clickBackButton(ActionEvent actionEvent) throws IOException {
        General.setBackScene();
    }


    public void clickHomeButton(ActionEvent actionEvent) throws IOException {
        General.changeScene(General.setSource("Home"));
    }

    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Result"));
    }
    @FXML
    private void clickMenuLink2(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Insert"));
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
        // niente
    }
    @FXML
    private void clickMenuLink8(ActionEvent event) throws IOException {
        Home.GUI=1;
        General.changeScene(General.setSource("Home2"));
    }

    private int i;
    ArrayList list = new ArrayList();



    private List<Element> elements = new ArrayList<>();

    private List<Element> getData() {
        int i;
        List<Element> elements = new ArrayList<>();
        Element elem;



        // ESEMPI PER VEDERE SE FUNZIONA

        for (i=0; i<list.size(); i++) {
            elem = new Element();
            elem.setTitle((String)list.get(i));
            elem.setImgSrc("im3.jpg");
            elements.add(elem);
        }
        return elements;
    }
    @FXML
    private Pane menu, dark;
    @FXML
    private Button recipeButton, fridgeButton, menuButton;
    public void clickMenuButton(ActionEvent actionEvent) {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
        dark.setVisible(false);

        int i;
        int column = 0, row = 1;

        list.add("Olio");
        list.add("Sale");
        list.add("Pasta");
        list.add("Zucchine");
        list.add("Parmigiano");
        list.add("Uova");
        list.add("Zucchero");
        list.add("Farina");
        list.add("Lievito");
        list.add("Acqua");

        elements.addAll(getData());

        try {
            for (i=0;i<elements.size();i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("ListElementFridge.fxml"));
                Pane anchorPane = fxmlloader.load();

                ElementController elementController = fxmlloader.getController();
                elementController.setData(elements.get(i));

                grid.add(anchorPane, column, row++);
                grid.setMargin(anchorPane, new Insets(5));
                grid.setGridLinesVisible(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
