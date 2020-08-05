package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class  TestFileDeletion extends EnterpriseLangTest{ /*
                              OS -----   UserAccount
      
        Attacker's entry point: userAccount.userRights 
    */
    
    
    //  rootkit no defens aktiv.
    private static class fileDeletion{
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        public final Computer computer = new Computer("computer");

        public fileDeletion() {
		userAccount.addOs(os);
		computer.addOs(os);
        }
        
    }
    
    @Test
    public void userRights(){
        var model = new fileDeletion();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

	model.os.fileDeletion.assertCompromisedInstantaneously();
	model.os.bypassHostForensicAnalysis.assertCompromisedInstantaneously();
    }


    @Test
    public void infectedComputer(){
        var model = new fileDeletion();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.computer.infectedComputer);
        attacker.attack();

	model.os.fileDeletion.assertCompromisedInstantaneously();
	model.os.bypassHostForensicAnalysis.assertCompromisedInstantaneously();
    }

    @Test
    public void indicatorRemovalOnHost(){
        var model = new fileDeletion();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.indicatorRemovalOnHost);
        attacker.attack();

	model.os.fileDeletion.assertCompromisedInstantaneously();
	model.os.bypassHostForensicAnalysis.assertCompromisedInstantaneously();
    }
}

    
