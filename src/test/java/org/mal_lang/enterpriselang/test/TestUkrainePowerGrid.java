package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestUkrainePowerGrid extends EnterpriseLangTest {
    private static class UkrainePowerGridShutdownModel {

        /*
                Browser  ------ Service 
                                  |  
                                  |
                Windows  -------  OS -----  UserAccount
                                  |              |              
                                  |              |
    Firewall ---- Router ----- Computer ------ User
      
        Attacker's entry point: Browser.spearphishingAttachment
        */

        public final User user = new User("user",false); // userTraining is set to false; if is set to true, then spearphishingAttachmentDownload.assertUncompromised();
        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
        public final Browser browser = new Browser("browser",false);
        public final Computer computer = new Computer("computer");
        public final Service service = new Service("service");
        public final OS os = new OS("os");
        public final Windows windows = new Windows("windows");
        public final Router router = new Router("router");
        public final Firewall firewall = new Firewall("firewall");

        public UkrainePowerGridShutdownModel() {
            browser.addService(service);
            os.addService(service);
            os.addComputer(computer);
            os.addUserAccount(userAccount);
            os.addWindows(windows);
            computer.addUser(user);
            computer.addRouter(router);
            router.addFirewall(firewall);
        }
    }

    @Test // Test an adversary conduct fileDeletion and shutdown the SCADA system.
    public void testSystemShutdown() {
            var model = new UkrainePowerGridShutdownModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.browser.spearphishingAttachment);
            attacker.attack();

            model.user.attemptMaliciousFile.assertCompromisedInstantaneously();
            model.user.maliciousFile.assertCompromisedInstantaneously();
            model.os.executeCode.assertCompromisedInstantaneously();         
            model.computer.infectedComputer.assertCompromisedInstantaneously();
            model.os.fileDeletion.assertCompromisedInstantaneously(); // fileDeletion reached
            model.os.validAccounts.assertCompromisedInstantaneously();
            model.os.domainAccounts.assertCompromisedInstantaneously();
            model.service.externalRemoteServices.assertCompromisedInstantaneously();
            model.windows.attemptSystemFirmware.assertCompromisedInstantaneously();
            model.windows.systemFirmware.assertCompromisedInstantaneously();
            model.windows.systemShutdownOrReboot.assertCompromisedInstantaneously(); // systemShutdown reached
    } 

    private static class UkrainePowerGridServiceStopModel {

        /*
                  OS ------ Service
      
        Attacker's entry point: OS.endpointDenialOfService
        */

        public final Service service = new Service("service");
        public final OS os = new OS("os");
        public final Windows windows = new Windows("windows");

        public UkrainePowerGridServiceStopModel() {
            os.addService(service);
            os.addWindows(windows);
        }
    }

    @Test // Test an adversary conduct endpointDenialOfService to stop the service.
    public void testServiceStop() {
            var model = new UkrainePowerGridServiceStopModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.os.endpointDenialOfService);
            attacker.attack();

            model.os.serviceExhaustionFlood.assertCompromisedInstantaneously();
            model.windows.serviceStop.assertCompromisedInstantaneously();
    } 
}



