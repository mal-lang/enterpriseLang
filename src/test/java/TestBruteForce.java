package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestBruteForce extends EnterpriseLangTest {
    private static class BruteForceAttacksModel {

        /*
        attack scenario source: https://us-cert.cisa.gov/ncas/alerts/TA18-086A

                           Service      
                              |                          
                              |               
               UerAccount -- OS -- Computer -- Router -- InternalNetwork
                              |                             
                              |
                            Windows

        Attacker's entry point: Service.attemptSpearphishingViaService
        */

        public final Service service = new Service("service");
        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
        public final OS os = new OS("os"); // We assume all defenses are disabled for OS. We can enable some of them, then the corresponding attack steps can not be reached.
        public final Windows windows = new Windows("windows");
        public final Computer computer = new Computer("computer");
        public final InternalNetwork victimNetwork = new InternalNetwork("victimNetwork");
        public final Router router = new Router("router");   

        public BruteForceAttacksModel() {
            os.addService(service);
            os.addUserAccount(userAccount);
            os.addWindows(windows);
            os.addComputer(computer);
            computer.addRouter(router);
            router.addInternalNetwork(victimNetwork);
        }
    }

    @Test // Test attack path SpearphishingViaService -> SpearphishingViaSocialMedia -> BruteForce -> UserCredentials (RDU) -> EmailCollection -> remoteEmailCollection -> RemoteDesktopProtocol -> fileTransferProtocols -> ExfiltrationOverC2Channel
    public void testBruteForceAttacksWithCyberActors() {
            var model = new BruteForceAttacksModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.service.attemptSpearphishingViaService);
            attacker.attack();

            model.service.spearphishingViaSocialMedia.assertCompromisedInstantaneously();
            model.os.bruteForce.assertCompromisedInstantaneously();
            model.userAccount.userCredentials.assertCompromisedInstantaneously();
            model.windows.emailCollection.assertCompromisedInstantaneously();
            model.windows.remoteDesktopProtocol.assertCompromisedInstantaneously();
            model.victimNetwork.exfiltrationOverC2Channel.assertCompromisedInstantaneously();
    }  
}