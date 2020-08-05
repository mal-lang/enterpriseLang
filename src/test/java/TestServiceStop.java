package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class  TestServiceStop extends EnterpriseLangTest{
    /*
        Windows ----- UserAccount
      
        Attacker's entry point: win.attemptServiceStop 
    */
    
    
    //  Service Stop no defens aktiv.
    private static class ServiceStop {
        public final UserAccount userAccount = new UserAccount("userAccount");
	public final Windows win = new Windows("win");

        public ServiceStop () {
		win.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void attack1(){
        var model = new ServiceStop();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.win.attemptServiceStop);
        attacker.attack();

	model.win.serviceStop.assertCompromisedInstantaneously();
    }

    // Service Stop with defens aktiv.
    private static class ServiceStopDefens {
        public final UserAccount userAccount = new UserAccount("userAccount");
	public final Windows win = new Windows("win",true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);
	//public final Windows win = new Windows("win",true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);

        public  ServiceStopDefens () {
		win.addUserAccount(userAccount);
        }
        
    }
    
    @Test
    public void attack2(){
        var model = new ServiceStopDefens();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.win.attemptServiceStop);
        attacker.attack();

	model.win.serviceStop.assertUncompromised();
    }


}

    
