package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestCredentialAccess extends EnterpriseLangTest {
    private static class AdminRightsUserCredentialAccessModel {

        /*                                               
                                       --- UserAccount---    
                                       |        |       |
            Windows -------- OS -------|        |       | 
                                       |        |       |       
                                       --- AdminAccount--   

        Attacker's entry point: AdminAccount.adminRights
        */

        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
        public final AdminAccount adminAccount = new AdminAccount("adminAccount",false,false);    
        public final OS os = new OS("os",false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false); // We assume all defenses are disabled for OS. We can enable some of them, then the corresponding attack steps can not be reached.
        //public final OS os = OS os = new OS("os");
        //os.limitSoftwareInstallation.defaultValue = true;
        public final Windows windows = new Windows("windows");

        public AdminRightsUserCredentialAccessModel() {
            os.addUserAccount(userAccount);
            os.addAdminAccount(adminAccount);
            os.addWindows(windows);
        }
    }

    @Test // Test an adversary holds adminRights can access userCredentials through credentialDumping and passTheHash/bruteForce.
    public void testCredentialAccessWithAdminRights() {
            var model = new AdminRightsUserCredentialAccessModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.adminAccount.adminRights);
            attacker.attack();

            model.os.attemptCredentialDumping.assertCompromisedInstantaneously();
            model.os.credentialDumping.assertCompromisedInstantaneously();
            model.os.collectHashInformation.assertCompromisedInstantaneously();
            model.os.attemptBruteForce.assertCompromisedInstantaneously();
            model.os.bruteForce.assertCompromisedInstantaneously();
            model.windows.passTheHash.assertCompromisedInstantaneously();
            model.userAccount.userCredentials.assertCompromisedInstantaneously();
    } 


    private static class UserRightsUserCredentialAccessModel {
        /*
                           Service                     
                              |        -- UserAccount---     
                              |        |      |        |
            Windows -------- OS -------|      |        |
                                       |      |        |                       
                                       --AdminAccount---
      

        Attacker's entry point: UserAccount.userRights
        */

        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
        public final AdminAccount adminAccount = new AdminAccount("adminAccount",false,false);    
        public final Service service = new Service("service");
        public final OS os = new OS("os",false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);
        public final Windows windows = new Windows("windows");

        public UserRightsUserCredentialAccessModel() {
            os.addService(service);
            os.addUserAccount(userAccount);
            os.addAdminAccount(adminAccount);
            os.addWindows(windows);
        }
    }

    @Test // Test an adversary holds userRights can access userCredentials through ExploitationForPrivilegeEscalation, credentialDumping and passTheHash/bruteForce.
    public void testCredentialAccessWithUserRights() {
            var model = new UserRightsUserCredentialAccessModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.userAccount.userRights);
            attacker.attack();

            model.service.attemptExploitationForPrivilegeEscalation.assertCompromisedInstantaneously();
            model.service.exploitationForPrivilegeEscalation.assertCompromisedInstantaneously();
            model.adminAccount.adminRights.assertCompromisedInstantaneously();
            model.os.attemptCredentialDumping.assertCompromisedInstantaneously();
            model.os.credentialDumping.assertCompromisedInstantaneously();
            model.os.collectHashInformation.assertCompromisedInstantaneously();
            model.os.attemptBruteForce.assertCompromisedInstantaneously();
            model.os.bruteForce.assertCompromisedInstantaneously();
            model.windows.passTheHash.assertCompromisedInstantaneously();
            model.userAccount.userCredentials.assertCompromisedInstantaneously();
    } 
}



