package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class  TestBrowserBookmarkDiscovery extends EnterpriseLangTest{
    /*
            Browser ------ Service
                              |  
                              |  
                              |
                              OS -----   UserAccount
                                              |              
                                              |
                                              User
      
        Attacker's entry point: Browser.browserBookmark
    */
    
    
    // Attack no defens aktiv.
    private static class browserExtensionsPresistens{
        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
        public final Browser browser = new Browser("browser",false);
        public final Service service = new Service("service");
        public final OS os = new OS("os");

        public browserExtensionsPresistens() {
            browser.addService(service);
            os.addService(service);
            os.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void persistence(){
        var model = new browserExtensionsPresistens();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

	model.userAccount.userInformation.assertCompromisedInstantaneously();
    }


}

    
