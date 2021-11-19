package letisiaornelle.com.fillthedish1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SearchRecipe3 {

    @FXML
    Button backButton;

    @FXML
    Button homeButton;

    public void handleButtonAction(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource() == backButton){
            MainActivity h = new MainActivity();
            h.changeScene("recipes2.fxml");
        }

        if(actionEvent.getSource() == homeButton){
            MainActivity h = new MainActivity();
            h.changeScene("recipes.fxml");
        }

    }
}
