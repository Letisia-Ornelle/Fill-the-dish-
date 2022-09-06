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

   private static fridgeSingletonEntity fridge = null;
    List<IngredientEntity> ingredients;
    fridgeDAO fridgeDAO = new fridgeDAO();

    public manageFridgeController(){
        ingredients = fridgeDAO.ingredientUser(user.getInstance().getUser().getUsername());
        this.fridge = user.getInstance().getUser().getFridge().createFridge(ingredients,user.getInstance().getUser().getUsername());

    }

    public void addIngredient(fridgeBean fridgebean) throws duplicateIngredientException {

        for(IngredientEntity ingr : ingredients){
            if(ingr.getIngredient().equals(fridgebean.getIngredientName())){
               throw new duplicateIngredientException("This ingredient already exist !");
            }
        }

        IngredientEntity ingredient = fridge.addIngredient(fridgebean.getIngredientName(), fridgebean.getIngredientImage());
        fridgeDAO.insertInFridge(user.getInstance().getUser().getUsername(),ingredient, fridgebean.getIngredientInputStream());

    }


     public List<fridgeBean> showFridge(){
        List<IngredientEntity> ingredients;
        List<fridgeBean> ingredientListBean = new ArrayList<>();

        ingredients = fridge.getIngredientList();

        for(IngredientEntity ingredient : fridgeSingletonEntity.getInstance().getIngredientList()){
            System.out.println(ingredient.getIngredient());
        }

        for(IngredientEntity ingr : user.getInstance().getUser().getFridge().getIngredientList()){
           ingredientListBean.add(new fridgeBean(ingr.getIngredient(), ingr.getIngredientSrc()));
        }

        return ingredientListBean;
    }



    public  boolean getImage(fridgeBean fb) throws SQLException {

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


    public void deleteIngredient(fridgeBean fridgebean) {

        IngredientEntity ingredient = new IngredientEntity(fridgebean.getIngredientName(), fridgebean.getIngredientImage());

        fridgeSingletonEntity.getInstance().removeIngredient(ingredient);

        fridgeDAO.delete(fridgebean.getIngredientName());
    }

    public static void modifyIngredient(){}
}
