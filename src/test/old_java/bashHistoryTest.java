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
    user.userCredentials.assertCompromisedInstantaneously();
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

    user.userCredentials.assertCompromisedInstantaneously();
    user.adminLogin.assertCompromisedInstantaneously();
  }
  @Test
  public void linuxTestWithDefense() {
    User user = new User("user");
    Computer computer = new Computer("computer");
    Linux linux= new Linux("linux",false,true,false,false,false);//turnOfBashHistory in win is the defens

    user.addLinux(linux);
    computer.addLinux(linux);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    //linux.bashHistory.assertCompromisedInstantaneously();
    user.userCredentials.assertUncompromised();
    user.adminLogin.assertUncompromised();
  }
  
  @Test
  public void macOSTestwithDefense() {
    User user = new User("user");
    Computer computer = new Computer("computer");
    MacOS macOS= new MacOS("macOS",true,false,false,false,false);

    user.addMacOS(macOS);
    computer.addMacOS(macOS);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    user.userCredentials.assertUncompromised();
    user.adminLogin.assertUncompromised();
  }
}