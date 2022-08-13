package home.home2.Controller;

import home.home2.Model.Beans.calculateRecipeBean;
import home.home2.Model.Beans.calculateRecipeBean;
import home.home2.Model.DAO.calculateRecipeDAO;
import home.home2.Model.DAO.calculateRecipeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class calculateRecipeController {



    calculateRecipeDAO Rdao = new calculateRecipeDAO();


  /*  public void fillChoiceBox(CalculateRecipeBean CRbean) throws SQLException {

        // Forse ci va ingredientBean come parametro ;

        final ObservableList options = FXCollections.observableArrayList();

      /*  while( Rdao.ingredients(CRbean.getName(), CRbean.getImage()).next() ){

           // CRbean.setName(("nome"));
            options.add(Rdao.ingredients(CRbean.getName(), CRbean.getImage()).getString("nome"));
        }
    }

 }}
*/

    /*  public ObservableList<String> retList() throws SQLException {
      return Rdao.ingredients();

      } */
    public boolean verifyList( calculateRecipeBean CRbean ) throws SQLException {
        ObservableList<String> IngredientList = Rdao.ingredients();

        ObservableList<String> ingredienti = CRbean.setListIng(IngredientList);

        if( ingredienti.equals(null)){
            return false;
        }
        else{
            return true;
        }
    }
}

