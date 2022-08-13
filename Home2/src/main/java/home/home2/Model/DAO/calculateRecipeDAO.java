package home.home2.Model.DAO;

import home.home2.Model.DAO.Queries.queries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class  calculateRecipeDAO {

    Statement stmt = null;
    Connection conn = null;


    public ObservableList<String> ingredients() throws SQLException {
        conn = DBConnection.getInstance().getConnection();
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ObservableList<String> listaIng = FXCollections.observableArrayList();
        ResultSet res = queries.takeIngredientsDB(stmt);

        if (res.first() == false) {
            System.out.println("ResultSetIngredienti vuoto\n");
            return null;

        } else {
            while (res.next()) {
                String ingredientName = res.getString("nome");
                listaIng.add(ingredientName);
            }
            return listaIng;

        }


    }



}