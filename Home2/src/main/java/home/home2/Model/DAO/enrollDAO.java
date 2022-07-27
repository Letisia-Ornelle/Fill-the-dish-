package home.home2.Model.DAO;

import home.home2.Model.DAO.Queries.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class enrollDAO {

    Statement stmt = null;
    Connection conn = null;

    public void newUser(String username, String nome, String cognome, String email, String password ) throws SQLException {
        conn = DBConnection.getInstance().getConnection();
        stmt =  conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

        //int res =
                queries.enroll(stmt, username, nome,cognome,email, password);


       /* if (res == 0) {
            System.out.println("Non è stata aggiunta nessuna riga alla tabella\n");
            return false;
        }
        else {
            return true;
            // riga aggiunta correttamente
        }*/

    }
}
