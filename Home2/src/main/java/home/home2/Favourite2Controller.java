package home.home2;

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
}
