package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class  TestBrowserExtensions extends EnterpriseLangTest{
    /*
            Browser ------ Service
                              |  
                              |  
                              |
                              OS -----   UserAccount
                                              |              
                                              |
                                              User
      
        Attacker's entry point: Browser.spearphishingAttachment
    */
    
    
    // persistence no defens aktiv.
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
        attacker.addAttackPoint(model.browser.installExtensions);
        attacker.attack();

	model.os.persistence.assertCompromisedInstantaneously();
    }

    // persistence white defens aktiv.
    private static class browserExtensionsPresistensDefens{
        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",true,false); // userTraining defens 
        public final Browser browser = new Browser("browser",false);
        public final Service service = new Service("service");
        public final OS os = new OS("os");

        public browserExtensionsPresistensDefens() {
            browser.addService(service);
            os.addService(service);
            os.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void persistenceDefens(){
        var model = new browserExtensionsPresistensDefens();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.browser.installExtensions);
        attacker.attack();

       //model.os.persistence.assertUncompromised();
       
    }



//-----------------------------------------------------

    // User information white defens aktiv.
    private static class browserExtensionsUserInformation{
        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",false,false); // userTraining defens 
        public final Browser browser = new Browser("browser",false);
        public final Service service = new Service("service");
        public final OS os = new OS("os");

        public browserExtensionsUserInformation() {
            browser.addService(service);
            os.addService(service);
            os.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void userAccount(){
        var model = new browserExtensionsUserInformation();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.browser.installExtensions);
        attacker.attack();

       model.userAccount.userInformation.assertCompromisedInstantaneously();
       
    }

    // User information white userTraining defens aktiv.
    private static class browserExtensionsUserInformationDefens{
        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",true,false); // userTraining defens 
        public final Browser browser = new Browser("browser",false);
        public final Service service = new Service("service");
        public final OS os = new OS("os");

        public browserExtensionsUserInformationDefens() {
            browser.addService(service);
            os.addService(service);
            os.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void userAccountDefens(){
        var model = new browserExtensionsUserInformationDefens();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.browser.installExtensions);
        attacker.attack();

       //model.userAccount.userInformation.assertUncompromised();
       
    }


//-----------------------------------------------------


    // User credentiols white no defens aktiv.
    private static class browserExtensionsUserCredentials{
        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",false,false); // userTraining defens 
        public final Browser browser = new Browser("browser",false);
        public final Service service = new Service("service");
        public final OS os = new OS("os");

        public browserExtensionsUserCredentials() {
            browser.addService(service);
            os.addService(service);
            os.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void userCredentials(){
        var model = new browserExtensionsUserInformation();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.browser.installExtensions);
        attacker.attack();

       model.userAccount.userCredentials.assertCompromisedInstantaneously();
       
    }


    
    // User credentiols white userTraining defens aktiv.
    private static class browserExtensionsUserCredentialsDefens{
        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",true,false); // userTraining defens is aktiv 
        public final Browser browser = new Browser("browser",false);
        public final Service service = new Service("service");
        public final OS os = new OS("os");

        public browserExtensionsUserCredentialsDefens() {
            browser.addService(service);
            os.addService(service);
            os.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void userCredentialsDefens(){
        var model = new browserExtensionsUserCredentialsDefens();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.browser.installExtensions);
        attacker.attack();

      //model.userAccount.userCredentials.assertUncompromised();
       
    }
    // User credentiols white userTraining defens aktiv.
    private static class browserExtensionsUserCredentialsDefens2{
        public final User user = new User("user");
        public final UserAccount userAccount = new UserAccount("userAccount",true,false); 
        public final Browser browser = new Browser("browser",false);
        public final Service service = new Service("service");
        public final OS os = new OS("os",true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);
	//limitSoftwareInstallation defens is true
        public browserExtensionsUserCredentialsDefens2() {
            browser.addService(service);
            os.addService(service);
            os.addUserAccount(userAccount);
        }
        
    }
    @Test
    public void userCredentialsDefens2(){
        var model = new browserExtensionsUserCredentialsDefens2();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.browser.installExtensions);
        attacker.attack();

       model.userAccount.userCredentials.assertUncompromised();
       
    }
}

    
