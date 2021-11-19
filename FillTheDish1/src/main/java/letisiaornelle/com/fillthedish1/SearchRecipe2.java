package letisiaornelle.com.fillthedish1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import letisiaornelle.com.fillthedish1.model.Recipe;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class SearchRecipe2 implements Initializable {

    @FXML
    private Button homeButton;

    @FXML
    private Button backButton;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    public void handleButtonAction(ActionEvent actionEvent) throws IOException {
        MainActivity h = new MainActivity();
        if(actionEvent.getSource() == homeButton || actionEvent.getSource() == backButton) {
            h.changeScene("recipes.fxml");
        }
        else{
            h.changeScene("recipes3.fxml");
        }
    }

    private List<Recipe> ricette = new ArrayList<>();

    private List<Recipe> getData(){
        List<Recipe> ricette = new ArrayList<>();
        Recipe ricetta;

        for(int i = 0; i<40;i++){
            ricetta = new Recipe();
            ricetta.setName("Carbonara");
            ricetta.setImgSrc("Carbonara.png");

            ricette.add(ricetta);

       }
        return ricette;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ricette.addAll(getData());
        int column = 0;
        int row = 1;
        try {
            for(int i=0; i<ricette.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                //fxmlLoader.setController(new SearchRecipe2());
                fxmlLoader.setLocation(getClass().getResource("items.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();

                /*ItemsController itemController = fxmlLoader.getController();
                itemController.setData(ricette.get(i));*/

                if(column == 5){
                    column = 0;
                    row++;
                }

                // set grid width
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                // set grid height
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                grid.add(anchorPane,column++, row);
                GridPane.setMargin(anchorPane, new Insets(13));
            }
        }catch(IOException e){
                e.printStackTrace();

        }
    }
}
