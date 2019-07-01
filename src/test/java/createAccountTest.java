import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class createAccountTest {

  @Test 
  public void createAccountTestNoDefens() {
    Administrator admin = new Administrator("admin");
    OS os = new OS("os");

    admin.addOs(os);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(admin.adminRights);
    attacker.attack();

    os.persistance.assertCompromisedInstantaneously();
  }

  public void createAccountTestWithDefens() {
    Administrator admin = new Administrator("admin",true);
    OS os = new OS("os");

    admin.addOs(os);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(admin.adminRights);
    attacker.attack();

    os.persistance.assertUncompromised();
  }
  
}