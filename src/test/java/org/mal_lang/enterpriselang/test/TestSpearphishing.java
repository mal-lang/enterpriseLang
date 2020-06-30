package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestSpearphishing extends EnterpriseLangTest {
    private static class SpearphishingAttachmentModel {

        /*
            Browser ------ Service
                              |  
                              |  
                              |
                              OS -----   UserAccount
                              |               |              
                              |               |
                            Computer ------  User
      
        Attacker's entry point: Browser.spearphishingAttachment
        */

        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
        public final Browser browser = new Browser("browser",false);
        public final Computer computer = new Computer("computer");
        public final Service service = new Service("service");
        public final OS os = new OS("os");

        public SpearphishingAttachmentModel() {
            browser.addService(service);
            os.addService(service);
            os.addComputer(computer);
            os.addUserAccount(userAccount);
            computer.addUser(user);
        }
    }

    @Test
    public void testwithSpearphishingAttachment() {
            var model = new SpearphishingAttachmentModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.browser.spearphishingAttachment);
            attacker.attack();

            model.user.spearphishingAttachmentDownload.assertCompromisedInstantaneously();
            model.user.attemptUserExecution.assertCompromisedInstantaneously();
            model.userAccount.userExecution.assertCompromisedInstantaneously();
            model.computer.infectedComputer.assertCompromisedInstantaneously();
    }  

    private static class SpearphishingLinkModel {

        /*
            Browser ------ Service
                              |  
                              |  
                              |
                              OS -----   UserAccount
                              |               |              
                              |               |
                            Computer ------  User
      
        Attacker's entry point: Browser.spearphishingLink
        */

        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
        public final Browser browser = new Browser("browser",false);
        public final Computer computer = new Computer("computer");
        public final Service service = new Service("service");
        public final OS os = new OS("os");

        public SpearphishingLinkModel() {
            browser.addService(service);
            os.addService(service);
            os.addComputer(computer);
            os.addUserAccount(userAccount);
            computer.addUser(user);
        }
    }

    @Test
    public void testwithSpearphishingLink() {
            var model = new SpearphishingLinkModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.browser.spearphishingLink);
            attacker.attack();

            //model.browser.spearphishingLink.assertCompromisedInstantaneously();
            model.user.spearphishingLinkClicked.assertCompromisedInstantaneously();
            model.user.attemptUserExecution.assertCompromisedInstantaneously();
            model.userAccount.userExecution.assertCompromisedInstantaneously();
            model.computer.infectedComputer.assertCompromisedInstantaneously();
    }  


    private static class SpearphishingViaServiceModel {

        /*
                           Service
                              |  
                              |  
                              |
                              OS -----   UserAccount
                              |               |              
                              |               |
                            Computer ------  User
      
        Attacker's entry point: Service.attemptSpearphishingViaService
        */

        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
        public final Browser browser = new Browser("browser",false);
        public final Computer computer = new Computer("computer");
        public final Service service = new Service("service",false,false,false,false,false,false);
        public final OS os = new OS("os",false,false,false,false,false,false,false,false,false,false,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);

        public SpearphishingViaServiceModel() {
            browser.addService(service);
            os.addService(service);
            os.addComputer(computer);
            os.addUserAccount(userAccount);
            computer.addUser(user);
        }
    }

    @Test
    public void testwithSpearphishingViaService() {
            var model = new SpearphishingViaServiceModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.service.spearphishingViaService);
            attacker.attack();

            model.service.spearphishingViaPersonalEmail.assertCompromisedInstantaneously();
            model.service.spearphishingViaSocialMedia.assertCompromisedInstantaneously();
            model.browser.attemptSpearphishingAttachment.assertCompromisedInstantaneously();
            model.browser.attemptSpearphishingLink.assertCompromisedInstantaneously();    
            model.user.attemptUserExecution.assertCompromisedInstantaneously();
            model.userAccount.userExecution.assertUncompromised();
            model.computer.infectedComputer.assertUncompromised();
    }  

}
