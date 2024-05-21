import org.davidkhala.Raw;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class ConnectTest {
    @Test
    void AivenCloud() throws SQLException, ClassNotFoundException {
        String password = System.getenv("AIVEN_PASSWORD");
        String username = "avnadmin";
        String aiven = "mysql://" + username + ":" + password + "@mysql-davidkhala.d.aivencloud.com:22013/defaultdb?ssl-mode=REQUIRED";
        Raw db = new Raw(aiven, username, password);
        db.connect();
        db.disconnect();


    }
}
