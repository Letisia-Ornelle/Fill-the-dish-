package home.home2.Boundary;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class javaMailUtils {

    public static void sendEmail(String recipient, String subject,String msg) throws MessagingException {

        Properties properties = new Properties();

        // Bisogna settare le proprietà per il server di posta ( SMTP)
        // mail.smtp.auth
        // mail.smtp.startttls.enable
        // mail.smtp.host --> smtp.gmail.com
        // mail.smtp.port -> 587

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");


        // Ora vogliamo le credenziali dell'account mittente ( cioe di sistema)
        String myAccountEmail = "fillthedish@gmail.com";
        String myAccountPassword = "zhaxvvjadjpkjqda";


        // Ora vogliamo accedere usando l'API di posta elettronica in modo da usare la sessione

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,myAccountPassword);
            }

        });



        // ora devo preparare il messaggio che voglio inviare
      Message message = prepareMessage(session,myAccountEmail,recipient,subject,msg);
        System.out.println(msg);

        Transport.send(message);
      System.out.println("Message sent successfully");

    }

    private static Message prepareMessage(Session session, String myAccountEmail,String recipient, String subject,String msg) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(msg);

            return message;
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
