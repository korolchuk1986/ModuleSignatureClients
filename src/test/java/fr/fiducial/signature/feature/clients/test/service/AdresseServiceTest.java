package fr.fiducial.signature.feature.clients.test.service;

import fr.fiducial.signature.feature.clients.model.Adresse;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AdresseServiceTest extends TestCase {
    public AdresseServiceTest() {
    }

    public AdresseServiceTest(String testName) {
        super(testName);
    }

    public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite("Test UserServiceTest");

        suite.addTest(new AdresseServiceTest("testCreate"));
        suite.addTest(new AdresseServiceTest("testGet"));
        suite.addTest(new AdresseServiceTest("testUpdate"));
        suite.addTest(new AdresseServiceTest("testDelete"));
        return suite;
    }

    @Override
    public void setUp() {
        /* sûrement pas besoin car spring boot
        try {
            Connection connection = DataConnect.getConnection();
            userService = new UserService(connection);
            if (userExpected == null) {
                userExpected = new User("Carine", "Courbis", "ccourbis", "1234");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        */
    }
    //@After
    @Override
    public void tearDown() throws Exception {
        /* sûrement pas besoin car spring boot
        if (connection != null) {
            DataConnect.closeConnection(connection);
            connection = null;
            userService = null;
        }
        */
    }

    public void testCreate() {}
    public void testDelete() {}
    public void testUpdate() {}
    public void testGet() {}
}
