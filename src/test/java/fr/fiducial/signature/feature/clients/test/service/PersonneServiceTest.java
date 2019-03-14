package fr.fiducial.signature.feature.clients.test.service;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.*;

public class PersonneServiceTest extends TestCase {
    public PersonneServiceTest() {
    }
    public PersonneServiceTest(String testName) {
        super(testName);
    }

    public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite("Test DocumentServiceTest");
        DocumentServiceTest.beforeAllTests();
        suite.addTest(new DocumentServiceTest("testGetInfoFormulaire"));
        suite.addTest(new DocumentServiceTest("testCreateClient"));
        suite.addTest(new DocumentServiceTest("testUpdateClient"));
        suite.addTest(new DocumentServiceTest("testGetClientInfo"));
        suite.addTest(new DocumentServiceTest("testGetClients"));
        DocumentServiceTest.afterAllTests();
        return suite;
    }

    public static void beforeAllTests() {}
    public static void afterAllTests() {}

    @Override
    public void setUp() {}

    @Override
    public void tearDown() {}

    public void testGetClientInfo() {
    }

    public void testGetInfoFormulaire() {
    }

    public void testCreateClient() {
    }

    public void testUpdateClient() {
    }

    public void testGetClients() {
    }

}
