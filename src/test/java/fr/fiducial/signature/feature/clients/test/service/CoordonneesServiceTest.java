package fr.fiducial.signature.feature.clients.test.service;

import fr.fiducial.signature.feature.clients.model.Coordonnees;
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

        suite.addTest(new AdresseServiceTest("testCreate"));
        suite.addTest(new AdresseServiceTest("testGet"));
        suite.addTest(new AdresseServiceTest("testUpdate"));
        suite.addTest(new AdresseServiceTest("testDelete"));
        return suite;
    }

    @Override
    public void setUp() {

    }

    //@After
    @Override
    public void tearDown() throws Exception {
    }

    public void testCreate() {}
    public void testDelete() {}
    public void testUpdate() {}
    public void testGet() {}
}
