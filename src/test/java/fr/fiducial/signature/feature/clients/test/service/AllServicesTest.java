package fr.fiducial.signature.feature.clients.test.service;

import fr.fiducial.signature.feature.clients.service.RegimeMariageService;
import fr.fiducial.signature.feature.clients.service.TypeMaritalService;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class AllServicesTest {
    @RunWith(Suite.class)
    @Suite.SuiteClasses({AdresseServiceTest.class, CapaciteServiceTest.class, CauseRupturePacsServiceTest.class,
            CoordonneesServiceTest.class, DocumentServiceTest.class, LieuMariageServiceTest.class,
            PaysServiceTest.class, PersonneServiceTest.class, RegimeMariageService.class, StatutServiceTest.class,
            TypeMaritalServiceTest.class, TypePacsServiceTest.class, VilleServiceTest.class})
    public class AllServiceTests {
    }
}
