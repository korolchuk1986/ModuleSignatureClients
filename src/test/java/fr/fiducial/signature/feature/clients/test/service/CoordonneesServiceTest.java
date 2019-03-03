package fr.fiducial.signature.feature.clients.test.service;

import fr.fiducial.signature.feature.clients.model.Coordonnees;
import fr.fiducial.signature.feature.clients.service.CoordonnesService;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CoordonneesServiceTest extends TestCase {
    public CoordonneesServiceTest() {
    }

    public CoordonneesServiceTest(String testName) {
        super(testName);
    }

    public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite("Test CoordonneesServiceTest");
        CoordonneesServiceTest.beforeAllTests();
        suite.addTest(new CoordonneesServiceTest("testCreate"));
        suite.addTest(new CoordonneesServiceTest("testGet"));
        suite.addTest(new CoordonneesServiceTest("testUpdate"));
        suite.addTest(new CoordonneesServiceTest("testDelete"));
        CoordonneesServiceTest.afterAllTests();
        return suite;
    }

    public static void beforeAllTests() {}
    public static void afterAllTests() {}

    @Override
    public void setUp() {

    }

    //@After
    @Override
    public void tearDown() {
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
