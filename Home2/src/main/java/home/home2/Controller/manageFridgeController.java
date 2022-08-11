package home.home2.Controller;

import home.home2.Model.Beans.fridgeBean;
import home.home2.Model.DAO.fridgeDAO;
import home.home2.Model.Exceptions.duplicateIngredientException;
import home.home2.Model.IngredientEntity;
import home.home2.Model.fridgeSingletonEntity;
import home.home2.Model.user;
import home.home2.Model.userEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class manageFridgeController {

    // Devo implementare Observer sul frigo --> Come cacchio funziona sto pattern ?

    public static void addIngredient(fridgeBean fridgebean) throws SQLException, duplicateIngredientException {

        List<IngredientEntity> ingredients;

        ingredients = fridgeDAO.ingredientUser(user.getInstance().getUser().getUsername());
        fridgeSingletonEntity fridge = fridgeSingletonEntity.createFridge(ingredients,user.getInstance().getUser().getUsername());


        for(IngredientEntity ingr : ingredients){
            if(ingr.getIngredient().equals(fridgebean.getIngredientName())){
               throw new duplicateIngredientException("This ingredient already exist !");
            }
        }
        IngredientEntity ingredient = fridge.addIngredient(fridgebean.getIngredientName(), fridgebean.getIngredientImage());
        fridgeDAO.insertInFridge(user.getInstance().getUser().getUsername(),ingredient, fridgebean.getIngredientInputStream());

    }


     public static List<fridgeBean> showFridge() throws SQLException {
        List<IngredientEntity> ingredients;
        List<fridgeBean> ingredientListBean = new ArrayList<>();

         ingredients = fridgeDAO.ingredientUser(user.getInstance().getUser().getUsername());
         fridgeSingletonEntity fridge = fridgeSingletonEntity.createFridge(ingredients,user.getInstance().getUser().getUsername());

         userEntity entity = new userEntity(fridge,user.getInstance().getUser().getUsername());

         ingredients = entity.getFridge().getIngredientList();



        for(IngredientEntity ingr : ingredients){
           ingredientListBean.add(new fridgeBean(ingr.getIngredient(), ingr.getIngredientSrc()));
        }

        return ingredientListBean;
    }



    public static boolean getImage(fridgeBean fb) throws SQLException {

        // Anche se in realtà è l'ingrediente come oggetto e non solo l'immagine
        // Nella DAO , è stata settata sia nome che immagine dell'ingrediente (immagine con quella presa dal Database)
        IngredientEntity ingredient =  fridgeDAO.ingredientImage(fb.getIngredientName());

        if(ingredient != null){

            fb.setIngredientImage(ingredient.getIngredientSrc());

            System.out.println(user.getInstance().getUser().getUsername());

            return true;
        }
        else{
            return false;
        }

    }


    public static void deleteIngredient(fridgeBean fridgebean) {

        IngredientEntity ingredient = new IngredientEntity(fridgebean.getIngredientName(), fridgebean.getIngredientImage());

        fridgeSingletonEntity.getInstance().removeIngredient(ingredient);

        fridgeSingletonEntity fridge = fridgeSingletonEntity.getInstance();

        fridgeDAO.delete(fridgebean.getIngredientName());
    }
}