package letisiaornelle.com.fillthedish1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SearchRecipe1 {

    //private Label welcomeText;

    @FXML
    Button primi;

    @FXML
    Button secondi;

    @FXML
    Button contorni;

    @FXML
    Button spuntini;

    @FXML
    Button dolci;

    @FXML
    Button colazioni;

    @FXML
    Button backButton;

    @FXML
    Button homeButton;



    public void handleButtonAction(ActionEvent actionEvent) throws IOException {
        MainActivity h = new MainActivity();
        if(actionEvent.getSource() !=backButton && actionEvent.getSource() != homeButton) {
            h.changeScene("recipes2.fxml");
        }
        if (actionEvent.getSource() == homeButton){
                h.changeScene("recipes.fxml");

        }

    }
}