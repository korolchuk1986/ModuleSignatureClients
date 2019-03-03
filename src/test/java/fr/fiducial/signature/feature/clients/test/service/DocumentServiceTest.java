package fr.fiducial.signature.feature.clients.test.service;

import fr.fiducial.signature.feature.clients.model.Document;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

public class DocumentServiceTest extends TestCase {
    public DocumentServiceTest() {
    }

    public DocumentServiceTest(String testName) {
        super(testName);
    }

    public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite("Test DocumentServiceTest");
        DocumentServiceTest.beforeAllTests();
        suite.addTest(new DocumentServiceTest("testCreate"));
        suite.addTest(new DocumentServiceTest("testGet"));
        suite.addTest(new DocumentServiceTest("testUpdate"));
        suite.addTest(new DocumentServiceTest("testDelete"));
        DocumentServiceTest.afterAllTests();
        return suite;
    }

    public static void beforeAllTests() {}
    public static void afterAllTests() {}

    @Override
    public void setUp() {
    }

    @Override
    public void tearDown() throws Exception {
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
