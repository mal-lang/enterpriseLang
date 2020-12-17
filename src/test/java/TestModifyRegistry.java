package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class  TestModifyRegistry extends EnterpriseLangTest{
    /*
        Windows -----   UserAccount
      
        Attacker's entry point: userAccount.userRights
    */
    
    
    //  Modify Registry no defens aktiv.
    private static class ModifyRegistryNoDefens {
        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
	public final Windows win = new Windows("win");

        public ModifyRegistryNoDefens() {
		win.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void persistence(){
        var model = new ModifyRegistryNoDefens();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

	model.win.modifyRegistry.assertCompromisedInstantaneously();
    }
    
    
    
    
    
    //  Modify Registry with defens aktiv.
    private static class ModifyRegistryWithDefens {
        public final UserAccount userAccount = new UserAccount("userAccount",false,false);
	//public final Windows win = new Windows("win",true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);
	public final Windows win = new Windows("win",true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);

        public ModifyRegistryWithDefens() {
		win.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void persistence2(){
        var model = new ModifyRegistryWithDefens();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

	model.win.modifyRegistry.assertUncompromised();
    }

}
