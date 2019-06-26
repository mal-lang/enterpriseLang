import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class bashHistoryTest {

  @Test
  public void linuxTestNoDefense() {
    User user = new User("user");
    Computer computer = new Computer("computer");
    Linux linux= new Linux("linux");

    user.addLinux(linux);
    computer.addLinux(linux);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    //linux.bashHistory.assertCompromisedInstantaneously();
    user.stolenCredentials.assertCompromisedInstantaneously();
    user.adminLogin.assertCompromisedInstantaneously();
  }
  
  @Test
  public void macOSTestNoDefense() {
    User user = new User("user");
    Computer computer = new Computer("computer");
    MacOS macOS= new MacOS("macOS");

    user.addMacOS(macOS);
    computer.addMacOS(macOS);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    user.stolenCredentials.assertCompromisedInstantaneously();
    user.adminLogin.assertCompromisedInstantaneously();
  }
  @Test
  public void linuxTestWithDefense() {
    User user = new User("user");
    Computer computer = new Computer("computer");
    Linux linux= new Linux("linux",true,false,false,false);

    user.addLinux(linux);
    computer.addLinux(linux);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    //linux.bashHistory.assertCompromisedInstantaneously();
    user.stolenCredentials.assertUncompromised();
    user.adminLogin.assertUncompromised();
  }
  
  @Test
  public void macOSTestwithDefense() {
    User user = new User("user");
    Computer computer = new Computer("computer");
    MacOS macOS= new MacOS("macOS",true,false,false,false);

    user.addMacOS(macOS);
    computer.addMacOS(macOS);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    user.stolenCredentials.assertUncompromised();
    user.adminLogin.assertUncompromised();
  }
}