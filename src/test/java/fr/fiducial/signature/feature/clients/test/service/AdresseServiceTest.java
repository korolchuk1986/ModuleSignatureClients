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
        TestSuite suite = new TestSuite("Test Adresse ServiceTest");
        AdresseServiceTest.beforeAllTests();
        suite.addTest(new AdresseServiceTest("testCreate"));
        suite.addTest(new AdresseServiceTest("testGet"));
        suite.addTest(new AdresseServiceTest("testUpdate"));
        suite.addTest(new AdresseServiceTest("testDelete"));
        AdresseServiceTest.afterAllTests();
        return suite;
    }

    public static void beforeAllTests() {}
    public static void afterAllTests() {}

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
    public void tearDown(){
        /* sûrement pas besoin car spring boot
        if (connection != null) {
            DataConnect.closeConnection(connection);
            connection = null;
            userService = null;
        }
        */
    }

    public void testCreate() {
        //TODO
    }
    public void testDelete() {
        //TODO
    }
    public void testUpdate() {
        //TODO
    }
    public void testGet() {
        //TODO
    }
}
