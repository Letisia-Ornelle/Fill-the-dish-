package home.home2;

import home.home2.controller.FavouritesController;
import home.home2.controller.ManageFridgeController;
import home.home2.beans.FavouritesBean;
import home.home2.beans.FridgeBean;
import home.home2.beans.IngredientBean;
import home.home2.Model.Exceptions.duplicateIngredientException;
import home.home2.Model.Exceptions.provideLoginException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ElementController implements Initializable {
    @FXML
    private Button name;
    @FXML
    private ImageView img, select;
    @FXML
    private Button removeRecipe;

    String imagePath;
    @FXML
    private Pane cover;

    private Image image1;

    private FridgeBean fridgebean;
    public static ArrayList list = new ArrayList();
    private   Image image;
    private FavouritesBean favBean;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void removeIngredient(ActionEvent event) throws SQLException, IOException {

        FridgeBean fridgebean = new FridgeBean();
        fridgebean.setIngredientName(name.getText());
        ManageFridgeController fridgeController = new ManageFridgeController();
        fridgeController.deleteIngredient(fridgebean);

       // cover.setVisible(false);
        General.changeScene(General.setSource("Fridge"));

    }

    public void setData(FavouritesBean favBean) {
        this.favBean = favBean;
        name.setText(favBean.getRecipeName());
        img.setImage(favBean.getRecipeImage());
    }

    public void setData3(IngredientBean ingredientbean){
        name.setText(ingredientbean.getIngredientName());
        img.setImage(ingredientbean.getIngredientImage());
    }


    public void setData1(String ingredient, Image image) {
        name.setText(ingredient);
        img.setImage(image);
    }

    public void setData2(FridgeBean fridgebean) {
        this.fridgebean = fridgebean;
        name.setText(fridgebean.getIngredientName());
        img.setImage(fridgebean.getIngredientImage());

    }


    // Ok fa inserire l'ingrediente all'utente, ma devo fare in modo che tale ingrediente venga inserita sul dataBase
    // Necessaria per la modifica !
    public void addImage(MouseEvent mouseEvent) throws SQLException {
      // addToIngredient();
    }

    private Image addToIngredient() throws SQLException , duplicateIngredientException {

        FridgeBean f = new FridgeBean();
        ManageFridgeController m = new ManageFridgeController();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.jpg,*.png","*.jpg","*.png"));
        File file = fileChooser.showOpenDialog(null);
        if(file!=null){
            imagePath = file.getAbsolutePath();
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(imagePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
           image = new Image(inputStream);
            img.setImage(image);

            f.setIngredientImage(image);
            m.addIngredient(f);
        }
        return image;
    }


    @FXML
    public void clickRemoveRecipe(MouseEvent event) throws IOException, provideLoginException {

        FavouritesBean favBean = new FavouritesBean();
        favBean.setRecipeName(name.getText());
        favBean.setRecipeImage(img.getImage());

        FavouritesController favController = new FavouritesController();
        favController.deleteFromFavourites(favBean);

        General.changeScene(General.setSource("Favourite"));
    }


    @FXML
    public void clickSelect(MouseEvent event) throws IOException {

        //System.out.println("Selezionato ingrediente: " + name.getText());

        if (list.contains(name.getText())) {
            list.remove(name.getText());
            /*if (select.getImage() == image1){
                if (event.getSource()==select){
                    select.setImage(image2);

                }

            }
            if (select.getImage() == image2 ){
                if (event.getSource()==select ){
                    select.setImage(image1);

                }
            }


            //select.setImage(image1);

            // select.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectRelease.png"));
        } else {
           // select.setImage(image1);
            if (select.getImage() == image1){
                if (event.getSource()==select){
                    select.setImage(image2);

                }

            }
            if (select.getImage() == image2){
                if (event.getSource()==select){
                    select.setImage(image1);

                }
            }
            */

            //  select.setImage(new Image("C:\\Users\\Matteo\\IdeaProjects\\Fill-the-dish-\\trunk\\Home2\\src\\main\\resources\\home\\home2\\selectClick.png"));
            list.add(name.getText());
        }
        /*
        // verifico la correttezza
        int i;
        for (i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
        */


    }




    public void select(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == select) {
            select.setImage(image1);
        }

    }



}