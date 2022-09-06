package home.home2.Model.DAO;

import home.home2.Model.DAO.Queries.queries;
import home.home2.Model.IngredientEntity;
import home.home2.Model.user;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class fridgeDAO {

    static Statement stmt = null;
    static Connection conn = null;

    public  IngredientEntity ingredientImage(String ingredient) {

        IngredientEntity insertIngredient = null;

        try{

            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = queries.getImageFromIng(stmt, ingredient);

            if (!resultSet.first()) {
                return insertIngredient;
            }

            resultSet.first();
            insertIngredient = new IngredientEntity();
            insertIngredient.setIngredient(resultSet.getString("nome"));

            Blob b = resultSet.getBlob("immagine");
            if (b != null) {
                InputStream inputStream = b.getBinaryStream();
                Image image = new Image(inputStream);
                insertIngredient.setIngredientSrc(image);
            }

        }catch(Exception e){
            e.printStackTrace();
        }


        return insertIngredient;
    }


    public  void insertInFridge(String username, IngredientEntity ingredient, InputStream ingredientInputStream){

        try{
            conn = DBConnection.getInstance().getConnection();
            queries.insertIntoFridge(conn,username,ingredient,ingredientInputStream);

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public  IngredientEntity createIngredient(ResultSet resultSet) throws SQLException {

        Image image = null;
        String ingredientName = resultSet.getString("ingrediente");


        Blob bl = resultSet.getBlob("immagine");
        if (bl != null) {
            InputStream inputStream = bl.getBinaryStream();
            image = new Image(inputStream);


        }

        return new IngredientEntity(ingredientName, image);
    }


    public  List<IngredientEntity> ingredientUser(String username) {

        List<IngredientEntity> ingredients = new ArrayList<>() ;

        try{
            conn = DBConnection.getInstance().getConnection();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = queries.getIngredientsFromFridge(stmt, username);

            if(!resultSet.first()){
                return ingredients;
            }

            resultSet.first();

            do{
                ingredients.add(createIngredient(resultSet));
            }while(resultSet.next());

        }catch(Exception e){
            e.printStackTrace();
        }

        return ingredients;
    }

    public  void delete(String ingredient){

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            queries.deleteFromFridge(stmt, user.getInstance().getUser().getUsername(), ingredient);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
