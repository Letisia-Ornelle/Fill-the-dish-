package home.home2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class DynamicCBController implements Initializable {
    @FXML
    private ChoiceBox choiceBoxD;

    public void choiceBoxButtonPushed() {
        choiceBoxD.getValue();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxD.getItems().addAll("ingrediente1      ", "ingrediente2      ", "ingrediente3      ");
        choiceBoxD.setValue("Inserisci un nuovo ingrediente");
    }
}

