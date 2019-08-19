import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class bashHistoryTest {

  @Test
  public void linuxTestNoDefense() {
    User user = new User("user");
    Linux linux= new Linux("linux");
    Administrator admin = new Administrator("admin");

    user.addLinux(linux);
    admin.addLinux(linux);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(linux.infectedOS);
    attacker.attack();

    //linux.bashHistory.assertCompromisedInstantaneously();
    user.userCredentials.assertCompromisedInstantaneously();
    admin.adminCredential.assertCompromisedInstantaneously();
  }
  
  @Test
  public void macOSTestNoDefense() {
    User user = new User("user");
    MacOS macOS= new MacOS("macOS");
    Administrator admin = new Administrator("admin");

    user.addMacOS(macOS);
    admin.addMacOS(macOS);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(macOS.infectedOS);
    attacker.attack();

    user.userCredentials.assertCompromisedInstantaneously();
    admin.adminCredential.assertCompromisedInstantaneously();
  }
  @Test
  public void linuxTestWithDefense() {
    User user = new User("user");
    Linux linux= new Linux("linux",true);//turnOfBashHistory in win is the defens
    Administrator admin = new Administrator("admin");

    user.addLinux(linux);
    admin.addLinux(linux);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(linux.infectedOS);
    attacker.attack();

    //linux.bashHistory.assertCompromisedInstantaneously();
    user.userCredentials.assertUncompromised();
    admin.adminCredential.assertUncompromised();
  }
  
  @Test
  public void macOSTestwithDefense() {
    User user = new User("user");
    MacOS macOS= new MacOS("macOS",true);
    Administrator admin = new Administrator("admin");

    user.addMacOS(macOS);
    admin.addMacOS(macOS);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(macOS.infectedOS);
    attacker.attack();

    user.userCredentials.assertUncompromised();
    admin.adminCredential.assertUncompromised();
    
  }
}