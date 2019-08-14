import org.junit.Test;

import core.*;
import attack.*;

public class bash_profileAndBashrcTest {

  @Test
  public void linuxTestNoDefense() {
    User user = new User("user");
    Linux linux= new Linux("linux");

    user.addLinux(linux);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userRights);
    attacker.attack();

    linux.persistence.assertCompromisedInstantaneously();
  }
  
  @Test
  public void macOSTestNoDefense() {
    User user = new User("user");
    MacOS macOS= new MacOS("macOS");

    user.addMacOS(macOS);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userRights);
    attacker.attack();

    macOS.persistence.assertCompromisedInstantaneously();
  }
  @Test
  public void linuxTestWithDefense() {
    User user = new User("user");
    Linux linux= new Linux("linux",false,false,true,false,false,false,false,false,false);

    user.addLinux(linux);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userRights);
    attacker.attack();

    linux.persistence.assertUncompromised();
  }
  
  @Test
  public void macOSTestwithDefense() {
    User user = new User("user");
    MacOS macOS= new MacOS("macOS",false,false,false,true,false,false,false,false,false);

    user.addMacOS(macOS);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userRights);
    attacker.attack();

    macOS.persistence.assertUncompromised();
  }
}