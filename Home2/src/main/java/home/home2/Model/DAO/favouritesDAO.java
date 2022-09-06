package home.home2.Model.DAO;

import home.home2.Model.DAO.Queries.queries;
import home.home2.Model.RecipeEntity;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class favouritesDAO {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static Statement stmt1 = null;

    public  void insertIntoFavourites(String username, RecipeEntity recipeEntity){

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            queries.insertIntoFavourites(stmt, username,recipeEntity.getRecipe());
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public static  List<RecipeEntity> userFavourites(String username){

        List<RecipeEntity> recipes = new ArrayList<>();
        String recipeName;
        Image image = null;

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = queries.favouritesRecipes(stmt, username);

            if(!resultSet.first()){
                return recipes;
            }

            resultSet.first();
            do{
                recipeName = resultSet.getString("ricetta");
                ResultSet res = queries.getRecipeImage(stmt1,recipeName);

                res.first();

                Blob bl = res.getBlob("immagine");
                    if(bl!=null){
                        InputStream inputStream = bl.getBinaryStream();
                        image = new Image(inputStream);
                    }
                    String description = res.getString("descrizione");
                    String type = res.getString("tipo");

                recipes.add( new RecipeEntity(recipeName,image,description,type));

            }while(resultSet.next());

        }catch(SQLException e){
            e.printStackTrace();
        }
        return recipes;
    }

    public  void deleteFromFavourites(String username, String recipename){
        try{
            conn = DBConnection.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            queries.deleteFromFavourites(stmt, username, recipename);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
