package home.home2.Boundary;

import home.home2.Beans.fridgeBean;
import home.home2.Model.fridgeObserver;
import home.home2.Model.fridgeSubject;
import home.home2.Model.user;

import javax.mail.MessagingException;

public class manageFridgeSendEmail extends javaMailUtils{

  public void send(fridgeBean fridgeBean){

      try{
          String subject = "Aggiornamento Frigo";
          String message = "Un saluto da parte dei sviluppatori di Fill The Dish! l'ingrediente : "+fridgeBean.getIngredientName()+", è stato aggiunto correttamente nel tuo frigo virtuale!";

          javaMailUtils.sendEmail(user.getInstance().getUser().getEmail(), subject,message);
      } catch (MessagingException e) {
          e.printStackTrace();
      }

  }
}
