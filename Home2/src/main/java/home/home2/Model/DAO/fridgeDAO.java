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

    // Devo fare un metodo che mi restituisce l'imagine presa dal DB ....

    // Devo fare un metodo che mi restituisce l'ingrediente ( Come oggetto , e settare l'immagine corrispondente al nome inserito)

    // Ad un certo punto avrò Ingredient ingrediente = new Ingredient () , ingrediente.setImageSrc(imagine presa dal DB)

    public static IngredientEntity ingredientImage(String ingredient) throws SQLException {

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

    // Metodo per l'inserimento in frigo dell'ingrediente username + ingrediente + immagine ????

    /*public static void insertInFridge(String username, String ingredient, Image image) throws SQLException {

        conn = DBConnection.getInstance().getConnection();
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


       queries.insertIntoFridge(stmt,username,ingredient,image);

    }*/

    public static void insertInFridge(String username, IngredientEntity ingredient, InputStream ingredientInputStream) throws SQLException {

        try{
            conn = DBConnection.getInstance().getConnection();
            queries.insertIntoFridge(conn,username,ingredient,ingredientInputStream);

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public static IngredientEntity createIngredient(ResultSet resultSet) throws SQLException {

        Image image = null;
        String ingredientName = resultSet.getString("ingrediente");


        Blob bl = resultSet.getBlob("immagine");
        if (bl != null) {
            InputStream inputStream = bl.getBinaryStream();
            image = new Image(inputStream);


        }

        return new IngredientEntity(ingredientName, image);
    }


    // Forse devo ritornare la lista di ingredienti come lista di stringhe e recuperare l'immagine dal dataBase come ho fatto prima ????
    public static List<IngredientEntity> ingredientUser(String username) throws SQLException {

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

    public static void delete(String ingredient){

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            queries.deleteFromFridge(stmt, user.getInstance().getUser().getUsername(), ingredient);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
