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
        suite.addTest(new DocumentServiceTest("testGetPath"));
        suite.addTest(new DocumentServiceTest("testGetDocumentsByClient"));
        suite.addTest(new DocumentServiceTest("testUploadDocumentForClient"));
        suite.addTest(new DocumentServiceTest("testUpdateDocumentByClient"));
        suite.addTest(new DocumentServiceTest("deleteDocument"));
        DocumentServiceTest.afterAllTests();
        return suite;
    }

    public static void beforeAllTests() {}
    public static void afterAllTests() {}

    @Override
    public void setUp() {
    }

    @Override
    public void tearDown() {
    }

    public void testGetPath() {

    }
    public void testGetDocumentsByClient() {

    }
    public void testUploadDocumentForClient() {

    }
    public void testUpdateDocumentByClient() {

    }
    public void testDeleteDocument() {

    }
}
