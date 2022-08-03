package home.home2;

import home.home2.Controller.CalculateRecipeController;
import home.home2.Model.Beans.CalculateRecipeBean;
import home.home2.Model.DAO.CalculateRecipeDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DynamicCBController implements Initializable {
    @FXML
    private ChoiceBox choiceBoxD;

    public void choiceBoxButtonPushed() {
        choiceBoxD.getValue();
    }

    //forse non potevo chiamare la DAO qui
    // CalculateRecipeDAO Cdao = new CalculateRecipeDAO();


    public void initialize(URL url, ResourceBundle resourceBundle) {

      /*  try {

                choiceBoxD.setItems(Cdao.ingredients());

        } catch (SQLException e) {
            e.printStackTrace();
        }

       */
        choiceBoxD.setValue("Inserisci un nuovo ingrediente");

       /* CalculateRecipeController CRcont = new CalculateRecipeController();

        try {
            choiceBoxD.setItems(CRcont.retList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } */
        CalculateRecipeController CRCont = new CalculateRecipeController();
        CalculateRecipeBean CRBean = new CalculateRecipeBean();

        try {
            if ( CRCont.verifyList(CRBean) == true) {
                choiceBoxD.setItems(CRBean.getListIng());
            }
            else {
                System.out.println("errore nel riempimento dei choice box");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}


