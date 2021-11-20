package home.home2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertController implements Initializable {

    @FXML
    private Button menuButton;

    @FXML
    private Pane menu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menu.setVisible(false);
    }

    @FXML
    private void clickMenuButton() throws IOException {
        if (menu.isVisible()) {
            menu.setVisible(false);
            menuButton.setLayoutX(15);
        } else {
            menu.setVisible(true);
            menuButton.setLayoutX(255);
        }
    }

    @FXML
    private void clickHomeButton() throws IOException {
        General.changeScene(General.setSource("Home"));
    }

    @FXML
    private void clickBackButton() throws IOException {
        //General.changeScene(General.getBackScene());
    }

    @FXML
    private void clickSubmitButton() throws IOException{

    }

    @FXML
    private void clickMenuLink1(ActionEvent event) throws IOException {

    }

    @FXML
    private void clickMenuLink2(ActionEvent event) throws IOException {
        if (General.loginState) {
            General.changeScene(General.setSource("Insert"));
        } else {
            General.changeScene(General.setSource("Login"));
        }
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

    }


}