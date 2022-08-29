package home.home2;

import home.home2.Controller.calculateRecipeController;
import home.home2.Model.Beans.calculateRecipeBean;
import home.home2.Model.DAO.calculateRecipeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.InputMethodEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

        calculateRecipeController CRCont = new calculateRecipeController();
        calculateRecipeBean CRBean = new calculateRecipeBean();

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
 /*   public calculateRecipeBean getChoiceBoxValue(ActionEvent event) throws IOException {

      ObservableList<String> SelectedIngredients = FXCollections.observableArrayList();


        String ingrediente = (String) choiceBoxD.getValue();
        if(!ingrediente.equals("Inserisci un nuovo ingrediente")){
            System.out.println(ingrediente);
           SelectedIngredients.add(ingrediente);
            // attenzione! risolvere il problema che se cambio una scelta mette nella lista anche le scelte precedenti
            System.out.println(SelectedIngredients);



        }

        calculateRecipeBean Rbean = new calculateRecipeBean();

         Rbean.setListIng(SelectedIngredients);
       return Rbean;
    }
*/

    public ArrayList<String> setData(){
        ArrayList<String> SelectedIngredients = null;
        if(!choiceBoxD.getValue().equals("Inserisci un nuovo ingrediente")){
            SelectedIngredients.add((String) choiceBoxD.getValue());
        }
        System.out.println(SelectedIngredients);
        return SelectedIngredients;
    }





}


