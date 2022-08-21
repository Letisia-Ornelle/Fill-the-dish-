package home.home2;

import home.home2.Element;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static home.home2.Home.ps;

public class Favourite2Controller implements Initializable {

    @FXML
    private GridPane grid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i;
        int column = 0, row = 1;

        elements.addAll(getData());

        try {
            for (i=0;i<elements.size();i++) {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("ListElement.fxml"));
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

    private List<Element> elements = new ArrayList<>();

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
    }

    public void clickInterfaceButton(ActionEvent event) {
        // No
    }

    public void clickReviewButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Review2"));

    }

    public void clickFridgeButton(ActionEvent event) throws IOException {
        if (General.loginState) {
            General.changeScene(General.setSource("Fridge2"));
        } else {
            Home m = new Home();
            ps = m.getPS();
            ps.add("Fridge2.fxml");
            //System.out.println();
            General.changeScene(General.setSource("Login2"));
        }

    }

    public void clickFavouriteButton(ActionEvent event) {
        // No
    }

    public void clickLoginButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Login2"));

    }

    public void clickAddButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Add2"));

    }

    public void clickSearchButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Home2"));

    }

    public void clickHomeButton(ActionEvent event) throws IOException {
        General.changeScene(General.setSource("Home2"));

    }

    public void clickBackButton(ActionEvent event) {
    }
}
