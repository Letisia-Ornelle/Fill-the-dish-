package home.home2.Model.DAO;
import home.home2.Model.DAO.Queries.queries;
import home.home2.Model.RecipeEntity;
import javafx.scene.image.Image;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class allRecipesDAO {

    static Statement stmt = null;
    static Connection conn = null;
    public static List<RecipeEntity> getAllRecipes() throws SQLException {

        List<RecipeEntity> allRecipes = new ArrayList<>();
        String RecipeName;
        Image RecipeIm = null;
        String Description;
        String Tipo;
        conn = DBConnection.getInstance().getConnection();
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = queries.getRecipesName(stmt);
        while(rs.next()) {
            RecipeName = rs.getString("id_ricetta");
            Blob bl = rs.getBlob("immagine");
            if (bl != null) {
                InputStream inputStream = bl.getBinaryStream();
                RecipeIm = new Image(inputStream);
            }
            Description = rs.getString("descrizione");
            Tipo = rs.getString("tipo");
            allRecipes.add(new RecipeEntity(RecipeName, RecipeIm, Description, Tipo));
        }
        return allRecipes;
    }

}