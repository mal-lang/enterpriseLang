package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class  TestRootkit extends EnterpriseLangTest{
    /*
                              OS -----   UserAccount
      
        Attacker's entry point: userAccount.userRights 
    */
    
    
    //  rootkit no defens aktiv.
    private static class rootkit{
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        public final Windows win = new Windows("win");

        public rootkit() {
		userAccount.addOs(os);
		userAccount.addOs(win);
		win.addOs(os);
        }
        
    }
    
    @Test
    public void persistence(){
        var model = new rootkit();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

	model.os.rootkit.assertCompromisedInstantaneously();
	model.os.modifyAPICalls.assertCompromisedInstantaneously();
	model.os.bypassAntivirus.assertCompromisedInstantaneously();
	model.os.bypassFileMonitoring.assertCompromisedInstantaneously();
	model.os.bypassProcessWhitelisting.assertCompromisedInstantaneously();
	model.os.bypassSignatureBasedDetection.assertCompromisedInstantaneously();
	model.os.bypassProcessWhitelisting.assertCompromisedInstantaneously();
	model.os.bypassHostIntrusionPrevention.assertCompromisedInstantaneously();
	model.os.bypassSystemAccessControls.assertCompromisedInstantaneously();
	
	model.win.rootkit.assertCompromisedInstantaneously();
	model.win.modifyAPICalls.assertCompromisedInstantaneously();
	model.win.bypassAntivirus.assertCompromisedInstantaneously();
	model.win.bypassFileMonitoring.assertCompromisedInstantaneously();
	model.win.bypassProcessWhitelisting.assertCompromisedInstantaneously();
	model.win.bypassSignatureBasedDetection.assertCompromisedInstantaneously();
	model.win.bypassProcessWhitelisting.assertCompromisedInstantaneously();
	model.win.bypassHostIntrusionPrevention.assertCompromisedInstantaneously();
	model.win.bypassSystemAccessControls.assertCompromisedInstantaneously();
	model.win.credentialAPIHooking.assertCompromisedInstantaneously();
	model.win.attemptSystemFirmware.assertCompromisedInstantaneously();
            //->  modifyAPICalls, 
                //bypassAntivirus,
                //bypassFileMonitoring,
                //bypassProcessWhitelisting,
                //bypassSignatureBasedDetection, 
                //bypassHostIntrusionPrevention,
                //bypassSystemAccessControls,
                //bypassFileOrPathWhitelisting,
                //windows.credentialAPIHooking, // leads to hooking attack
                //windows.attemptSystemFirmware // leads to system firmware attack
    }



}

    
