package home.home2.Model;

public class userEntity {

    String username;
    String password;
    String name;
    String surname;
    String email;

    // Costruttore
    public userEntity(String username, String password,String name,String surname,String email){
        setUsername(username);
        setPassword(password);
        setName(name);
        setSurname(surname);
        setEmail(email);

    }

    public userEntity(){}


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
