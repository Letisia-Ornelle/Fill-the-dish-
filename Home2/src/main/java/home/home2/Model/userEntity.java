package home.home2.Model;

import home.home2.Model.DAO.fridgeDAO;

import java.util.ArrayList;

public class userEntity {

    String username;
    String password;
    String name;
    String surname;
    String email;

    private fridgeSingletonEntity fridge;

    // Composizione tra utente frigo ? --> Penso di si
    // Teoricamente , chiamo la DAO per recuperare il frigo dell'utente con username username --> Trovato un'altro modo


    public userEntity(fridgeSingletonEntity fridge, String username){
        this.fridge = fridge;
        this.username = username;

    }


    // Penso che dovrebbe essere uguale all'istanza di fridge !?
    public userEntity(){
        this.fridge= fridgeSingletonEntity.getInstance();
    }

    public fridgeSingletonEntity getFridge(){
        return fridge;
    }

    public  void addIngredientIntoUserfridge(IngredientEntity ingredient){
        this.fridge.addIngredient(ingredient.getIngredient(),ingredient.getIngredientSrc());
    }

    // Costruttore

    public userEntity(String username, String password,String name,String surname,String email){
        setUsername(username);
        setPassword(password);
        setName(name);
        setSurname(surname);
        setEmail(email);

    }

    public void setUsername(String userN){
        this.username = userN;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String pass){
        this.password = pass;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String mail){
        this.email = mail;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String nome){
        this.name = nome;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surN){
        this.surname = surN;
    }

    public String getSurname(){
        return surname;
    }

}
