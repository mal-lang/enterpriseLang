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

        public rootkit() {
		userAccount.addOs(os);
        }
        
    }
    
    @Test
    public void persistence(){
        var model = new rootkit();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

	model.os.rootkit.assertCompromisedInstantaneously();
    }



}

    
