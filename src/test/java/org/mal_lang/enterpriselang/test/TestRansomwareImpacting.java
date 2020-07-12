package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestRansomwareImpacting extends EnterpriseLangTest {
    private static class RansomwareImpactingModel {

        /*
        attack scenario source: https://us-cert.cisa.gov/ncas/alerts/aa20-049a
         
                            UserAccount ---  User
                                  |           |           
                                  |           |          
        Browser ---- Service ---- OS ----- Computer ----- Router  
                                                          /    \
                                                         /     \
                                           ExternalNetwork   InternalNetwork
                                            (OT network)      (IT network)

        Attacker's entry point: Service.attemptSpearphishingLink
        */

        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",false,false);      
        public final Browser browser = new Browser("browser");
        public final Service service = new Service("service");
        public final OS os = new OS("os",false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false); // We assume all defenses are disabled for OS. We can enable some of them, then the corresponding attack steps can not be reached.
        public final Computer computer = new Computer("computer");
        public final InternalNetwork itNetwork = new InternalNetwork("ITNetwork");
        public final ExternalNetwork otNetwork = new ExternalNetwork("OTNetwork");
        public final Router router = new Router("router");         

        public RansomwareImpactingModel() {
            browser.addService(service);
            os.addService(service);
            os.addComputer(computer);
            os.addUserAccount(userAccount);
            computer.addUser(user);
            computer.addRouter(router);
            router.addInternalNetwork(itNetwork);
            router.addExternalNetwork(otNetwork);
        }
    }

    @Test // Test attack path Spearphishing Link -> User Execution -> Infected Computer -> Encrypt Data for Impact on both OT and IT networks
    public void testPipelineOperationsWithRansomware() {
            var model = new RansomwareImpactingModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.browser.attemptSpearphishingLink);
            attacker.attack();

            model.user.spearphishingLinkClicked.assertCompromisedInstantaneously();
            model.user.attemptUserExecution.assertCompromisedInstantaneously();
            model.userAccount.userExecution.assertCompromisedInstantaneously();
            model.computer.infectedComputer.assertCompromisedInstantaneously();
            model.itNetwork.dataEncryptedForImpact.assertCompromisedInstantaneously();
            model.otNetwork.dataEncryptedForImpact.assertCompromisedInstantaneously();
    }  
}