package junit;
import home.home2.beans.EnrollBean;
import home.home2.controller.EnrollController;
import home.home2.model.exceptions.InvalidSyntaxEmailException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
class TestEnrollController {

    private static final String USERNAME = "newAccount";
    private static final String NAME = "Elisa";
    private static final String SURNAME = "Ferrari";
    private static final String PASSWORD = "newAccountPass";
    @Test
    void testEnrollInvalidSyntaxEmail(){

        EnrollBean enrollBean = new EnrollBean();
        EnrollController enrollController = new EnrollController();
        enrollBean.setUsername(USERNAME);
        enrollBean.setName(NAME);
        enrollBean.setCognome(SURNAME);
        enrollBean.setEmail("emailsbagliata.com");
        enrollBean.setPassword(PASSWORD);
        assertThrows(InvalidSyntaxEmailException.class, ()->enrollController.addUser(enrollBean));
    }
}