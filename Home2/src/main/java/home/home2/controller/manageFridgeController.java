package home.home2.controller;

import home.home2.beans.FridgeBean;
import home.home2.boundary.ManageFridgeSendEmailBoundary;
import home.home2.Model.DAO.fridgeDAO;
import home.home2.Model.Exceptions.duplicateIngredientException;
import home.home2.Model.IngredientEntity;
import home.home2.Model.fridgeSingletonEntity;
import home.home2.Model.user;
import java.util.ArrayList;
import java.util.List;

public class ManageFridgeController {

    private fridgeSingletonEntity fridge;
    List<IngredientEntity> ingredients;
    fridgeDAO fridgeDAO = new fridgeDAO();

    public ManageFridgeController(){
        ingredients = fridgeDAO.ingredientUser(user.getInstance().getUser().getUsername());
        this.fridge = user.getInstance().getUser().getFridge().createFridge(ingredients,user.getInstance().getUser().getUsername());

    }

    public void addIngredient(FridgeBean fridgebean) throws duplicateIngredientException {

        for(IngredientEntity ingr : ingredients){
            if(ingr.getIngredient().equals(fridgebean.getIngredientName())){
               throw new duplicateIngredientException("This ingredient already exist !");
            }
        }

        IngredientEntity ingredient = fridge.addIngredient(fridgebean.getIngredientName(), fridgebean.getIngredientImage());
        fridgeDAO.insertInFridge(user.getInstance().getUser().getUsername(),ingredient, fridgebean.getIngredientInputStream());

        ManageFridgeSendEmailBoundary email = new ManageFridgeSendEmailBoundary();
        email.send(fridgebean);

    }


     public List<FridgeBean> showFridge(){
        List<FridgeBean> ingredientListBean = new ArrayList<>();

        ingredients = fridge.getIngredientList();

        for(IngredientEntity ingr : user.getInstance().getUser().getFridge().getIngredientList()){
           ingredientListBean.add(new FridgeBean(ingr.getIngredient(), ingr.getIngredientSrc()));
        }

        return ingredientListBean;
    }



    public  boolean getImage(FridgeBean fb){

        IngredientEntity ingredient =  fridgeDAO.ingredientImage(fb.getIngredientName());

        if(ingredient != null){

            fb.setIngredientImage(ingredient.getIngredientSrc());

            return true;
        }
        else{
            return false;
        }

    }


    public void deleteIngredient(FridgeBean fridgebean) {

        IngredientEntity ingredient = new IngredientEntity(fridgebean.getIngredientName(), fridgebean.getIngredientImage());

        fridgeSingletonEntity.getInstance().removeIngredient(ingredient);

        fridgeDAO.delete(fridgebean.getIngredientName());
    }
}
