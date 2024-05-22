package dbconnecrion;

import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.fail;

public class DbConnectionTest {

    @Test
    public void testGetConnection() {
        Connection connection = DbConnection.getConnection();
        assertNotNull(connection, "La connexion ne doit pas être nulle");

        try {
            assertFalse(connection.isClosed(), "La connexion ne doit pas être fermée");
        } catch (SQLException e) {
            fail("Erreur lors de la vérification de l'état de la connexion : " + e.getMessage());
        }
    }
}

