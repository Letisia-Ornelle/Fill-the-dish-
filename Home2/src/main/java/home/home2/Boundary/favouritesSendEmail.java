package home.home2.Boundary;

import home.home2.Beans.favouritesBean;
import home.home2.Model.user;

import javax.mail.MessagingException;

public class favouritesSendEmail extends javaMailUtils{

    public void send(favouritesBean favbean){

        try{
            String subject = "Aggiornamento Frigo";
            String message = "Un saluto da parte dei sviluppatori di Fill The Dish! l'ingrediente : "+favbean.getRecipeName()+", è stato aggiunto correttamente nel tuo frigo virtuale!";

            javaMailUtils.sendEmail(user.getInstance().getUser().getEmail(), subject,message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
