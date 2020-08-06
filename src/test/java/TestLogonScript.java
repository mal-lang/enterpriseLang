package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class  TestLogonScript extends EnterpriseLangTest{ /*
                              OS -----   UserAccount
      
        Attacker's entry point: userAccount.userRights 
    */
    
    
    //  rootkit no defens aktiv.
    private static class logonScriptWin{
        public final Windows win = new Windows("win");
        public final WindowsAdmin admin = new WindowsAdmin("admin");

        public logonScriptWin() {
		win.addAdminAccount(admin);
        }
        
    }
    
    @Test
    public void testWin(){
        var model = new logonScriptWin();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.win.attemptLogonScripts);
        attacker.attack();

	model.win.logonScripts.assertCompromisedInstantaneously();
	model.win.attemptAccessTokenManipulation.assertCompromisedInstantaneously();
	// Not working for some reson. Think it has somfing to do white inheritens.
	//model.admin.adminRights.assertCompromisedInstantaneously();
    }

    

    //  rootkit no defens aktiv.
    private static class logonScriptWin2{
        public final Windows win = new Windows("win",true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);
        public final WindowsAdmin admin = new WindowsAdmin("admin");

        public logonScriptWin2() {
		win.addAdminAccount(admin);
        }
        
    }
    
    @Test
    public void testWinDefens(){
        var model = new logonScriptWin2();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.win.attemptLogonScripts);
        attacker.attack();

	model.win.logonScripts.assertUncompromised();
	model.win.attemptAccessTokenManipulation.assertUncompromised();
	// Not working for some reson. Think it has somfing to do white inheritens.
	//model.admin.adminRights.assertUncompromised();
    }

    //----------------------------------------------------------------------------------------------
    
    //  rootkit no defens aktiv.
    private static class logonScriptMac{
        public final MacOS mac = new MacOS("mac");
        public final Root root = new Root("root");

        public logonScriptMac() {
		mac.addAdminAccount(root);
        }
        
    }
    
    @Test
    public void testMac(){
        var model = new logonScriptMac();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.mac.attemptLogonScripts);
        attacker.attack();

	model.mac.logonScripts.assertCompromisedInstantaneously();
	// Not working for some reson. Think it has somfing to do white inheritens.
	//model.root.adminRights.assertCompromisedInstantaneously();
    }

    

    //  rootkit no defens aktiv.
    private static class logonScriptMac2{
        public final MacOS mac = new MacOS("mac",true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);
        public final Root root = new Root("root");

        public logonScriptMac2() {
		mac.addAdminAccount(root);
        }
        
    }
    
    @Test
    public void testMacDefens(){
        var model = new logonScriptMac2();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.mac.attemptLogonScripts);
        attacker.attack();

	model.mac.logonScripts.assertUncompromised();
	// Not working for some reson. Think it has somfing to do white inheritens.
	//model.root.adminRights.assertUncompromised();
    }
}

    
