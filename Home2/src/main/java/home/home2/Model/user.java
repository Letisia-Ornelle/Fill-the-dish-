package home.home2.Model;

import home.home2.Model.DAO.enrollDAO;
import home.home2.Model.DAO.userDAO;

import java.sql.SQLException;

public class user {

    private static user instance = null;
    private static userEntity userE ;

    public static synchronized user getInstance(){
        if(instance == null){
            instance = new user();
        }
        return instance;
    }

    private user(){
    }


    public userEntity getUser(){
        return userE;
    }

    // Utenti loggati --> retituisce true se l'utente è loggato , false altrimenti
    // Cosi dovrebbe essere. pero non so bene quale controllo effettuare

    public static void loginUser(String userName , String passWord) throws SQLException {

        userDAO userdao = new userDAO();
        user.userE = new userEntity();
        userE.setUsername(userName);
        userE.setPassword(passWord);
        user.userE = userdao.getUserAccount(userName,passWord);

        /*userDAO.allUsers();
        if(userName.equals("username") && passWord.equals("password")){
            //user.userE.setUsername(userName);
           // user.userE.setPassword(passWord);
            user.userE = userdao.getUserAccount(userName,passWord);
        }

       // user.userE = login;

        /*if(userE.getUsername().equals(username) && userE.getPassword().equals(password)){
            System.out.println("Corrispondenza trovata!");
            return true;
        }*/

       /* else{
            return false;
        }

        return true;*/
    }

    // Mantiene gli utenti registrati

    public void registerNewUser(String username, String nome, String cognome, String email, String password ) throws SQLException {
       enrollDAO enrolldao = new enrollDAO();
       enrolldao.newUser(username,nome,cognome,email,password);
    }




}
