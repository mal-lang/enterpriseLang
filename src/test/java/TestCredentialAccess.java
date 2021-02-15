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

        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");    
        public final OS os = new OS("os"); // We assume all defenses are disabled for OS. We can enable some of them, then the corresponding attack steps can not be reached.
        public final Windows windows = new Windows("windows");

        public AdminRightsUserCredentialAccessModel() {
            os.addUserAccount(userAccount);
            os.addAdminAccount(adminAccount);
            os.addWindows(windows);
        }
    }

    @Test // Test an adversary holds adminRights can move laterally within an environment through OS credentialDumping and passTheHash/bruteForce.
    public void testCredentialAccessWithAdminRights() {
            var model = new AdminRightsUserCredentialAccessModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.adminAccount.adminRights);
            attacker.attack();

            model.os.oSCredentialDumping.assertCompromisedInstantaneously();
            model.windows.cachedDomainCredentials.assertCompromisedInstantaneously();
            model.windows.collectHashInformation.assertCompromisedInstantaneously();
            model.windows.attemptPassTheHash.assertCompromisedInstantaneously(); 
            model.windows.passTheHash.assertCompromisedInstantaneously();
            model.windows.bypassSystemAccessControls.assertCompromisedInstantaneously();
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

        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");    
        public final Service service = new Service("service");
        public final OS os = new OS("os");
        public final Windows windows = new Windows("windows");
        public UserRightsUserCredentialAccessModel() {
            os.addService(service);
            os.addUserAccount(userAccount);
            os.addAdminAccount(adminAccount);
            os.addWindows(windows);
        }
    }

    @Test // Test an adversary holds userRights can  move laterally within an environment through ExploitationForPrivilegeEscalation, OS credentialDumping and passTheHash/bruteForce.
    public void testCredentialAccessWithUserRights() {
            var model = new UserRightsUserCredentialAccessModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.userAccount.userRights);
            attacker.attack();

            model.service.attemptExploitationForPrivilegeEscalation.assertCompromisedInstantaneously();
            model.service.exploitationForPrivilegeEscalation.assertCompromisedInstantaneously();
            model.adminAccount.adminRights.assertCompromisedInstantaneously();
            model.os.oSCredentialDumping.assertCompromisedInstantaneously();
            model.windows.cachedDomainCredentials.assertCompromisedInstantaneously();
            model.windows.collectHashInformation.assertCompromisedInstantaneously();
            model.windows.attemptPassTheHash.assertCompromisedInstantaneously();           
            model.windows.passTheHash.assertCompromisedInstantaneously();
            model.windows.bypassSystemAccessControls.assertCompromisedInstantaneously();
    } 
}



