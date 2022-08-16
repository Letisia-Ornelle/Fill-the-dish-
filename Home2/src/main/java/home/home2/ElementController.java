package home.home2;

import home.home2.Controller.manageFridgeController;
import home.home2.Model.Beans.fridgeBean;
import home.home2.Model.Beans.ingredientBean;
import home.home2.Model.Element;
import home.home2.Model.Exceptions.duplicateIngredientException;
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
import java.util.List;
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

    private Element elem;
    private fridgeBean fridgebean;
    public static ArrayList list = new ArrayList();
    private   Image image;
    //private static List<Element> elements = General.Elements;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        image1 = new Image("C:\\Users\\letis\\OneDrive\\Bureau\\Fill-the-dish-.git\\trunk\\Home2\\src\\main\\resources\\home\\home2\\true.png");
    }

    public void removeIngredient(ActionEvent event) throws SQLException {

        // Devo rimuovere l'emento grafico, sia dalla lista che dalla View !!!!

        fridgeBean fridgebean = new fridgeBean();
        fridgebean.setIngredientName(name.getText());
        manageFridgeController fridgeController = new manageFridgeController();
        fridgeController.deleteIngredient(fridgebean);

        cover.setVisible(false);

        // Pensavo di recuperare la lista e trovare qualche algoritmo che mi consente di rimuovere proprio l'elemento dal
        // VerticalBox, non solo di giocare con la visibilià ( Settanto a false come ho fatto io)
        // Però vabbè.....


        List<fridgeBean> fridgeBeans = fridgeController.showFridge();




    }

    // Non serve a niente....
    public void setData(Element elem) {
        this.elem = elem;
        name.setText(elem.getTitle());
        Image image = new Image(getClass().getResourceAsStream(elem.getImgSrc()));
        img.setImage(image);
    }

    public void setData3(ingredientBean ingredientbean){
        name.setText(ingredientbean.getIngredientName());
        img.setImage(ingredientbean.getIngredientImage());
    }


    public void setData1(String ingredient, Image image) {
        name.setText(ingredient);
        img.setImage(image);
    }

    public void setData2(fridgeBean fridgebean) {
        this.fridgebean = fridgebean;
        name.setText(fridgebean.getIngredientName());
        img.setImage(fridgebean.getIngredientImage());

    }


    // Ok fa inserire l'ingrediente all'utente, ma devo fare in modo che tale ingrediente venga inserita sul dataBase
    public void addImage(MouseEvent mouseEvent) throws SQLException {
      // addToIngredient();
    }

    private Image addToIngredient() throws SQLException , duplicateIngredientException {

        fridgeBean f = new fridgeBean();
        manageFridgeController m = new manageFridgeController();

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
    public void clickRemoveRecipe(MouseEvent event) throws IOException {
        General.removeEl(this.elem.getTitle());
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