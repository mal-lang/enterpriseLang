package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class  TestAccountManipulation extends EnterpriseLangTest{
    /*
      
		Windows ---- Computer
		  |
		  |
		  |----- UserAccunt
		  |
		WindowsAdmin


        Attacker's entry point: computer.infectedComputer
    */
    
    
    // trunsted relationship no defens aktiv.
    private static class trustedRelationshipNoDefens{
	public final UserAccount userAccount = new UserAccount("userAccount");
	public final Computer computer = new Computer("computer");
	public final Windows win = new Windows("win");
	public final WindowsAdmin winAdmin = new WindowsAdmin("winAdmin");	
	public final OS os = new OS("internalSystems");

	public trustedRelationshipNoDefens() {
	    win.addAdminAccount(winAdmin);
	    win.addUserAccount(userAccount);
	    win.addComputer(computer);
	    win.addOs(os);
	    computer.addOs(os);
	}
        
    }
    
    @Test
    public void runNoDefensInfectedComputer(){
	var model = new trustedRelationshipNoDefens();

	Attacker attacker = new Attacker();
	attacker.addAttackPoint(model.computer.infectedComputer);
	attacker.attack();


	model.win.accountManipulation.assertCompromisedInstantaneously();
	model.win.persistence.assertCompromisedInstantaneously();
	model.userAccount.userCredentials.assertCompromisedInstantaneously();
    }
    @Test
    public void runNoDefensUserRights(){
	var model = new trustedRelationshipNoDefens();

	Attacker attacker = new Attacker();
	attacker.addAttackPoint(model.userAccount.userRights);
	attacker.attack();


	model.win.accountManipulation.assertCompromisedInstantaneously();
	model.win.persistence.assertCompromisedInstantaneouslyFrom(model.win.accountManipulation);
	model.userAccount.userCredentials.assertCompromisedInstantaneouslyFrom(model.win.accountManipulation);
    }


    
    // trunsted relationship with defens aktiv.
    private static class trustedRelationshipDefens{
    
	public final UserAccount userAccount = new UserAccount("userAccount");
	public final AdminAccount adminAccount = new AdminAccount("adminAccount");
	public final Computer computer = new Computer("computer");
	public final Windows win = new Windows("win");
	public final WindowsAdmin winAdmin = new WindowsAdmin("winAdmin");	
	public final OS os = new OS("internalSystems");
	
	public trustedRelationshipDefens() {
	    //win.addAdminAccount(winAdmin);
	    win.addAdminAccount(adminAccount);
	    winAdmin.addAdminAccount(adminAccount);
	    win.addUserAccount(userAccount);
	    win.addComputer(computer);
	    win.addOs(os);
	    computer.addOs(os);
	}

    }
    //trustedRelationship -> _validAccounts -> service.userRemoteServicesLogin,
    @Test
    public void runWithDefens(){
        var model = new trustedRelationshipDefens();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

	//model.win.persistence.assertUncompromisedFrom(model.win.accountManipulation);
	//model.userAccount.userCredentials.assertUncompromisedFrom(model.win.accountManipulation);
	model.win.accountManipulation.assertCompromisedInstantaneously();
	//model.win.accountManipulation.assertUncompromised();
    }
  		

}
