package fr.fiducial.signature.feature.clients.test.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class AllServicesTest {
    @RunWith(Suite.class)
    @Suite.SuiteClasses({AdresseServiceTest.class, CapaciteTest.class, CauseRupturePacsServiceTest.class,
            DocumentServiceTest.class, PersonneServiceTest.class, VilleServiceTest.class})
    public class AllServiceTests {
    }
}
