import org.junit.Test;

import core.*;
import attack.*;

public class appleScriptTest {

  @Test
  public void appleScriptTestTestNoDefens() {
    MacOS mac = new MacOS("mac");
    User user = new User("user");

    user.addMacOS(mac);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userRights);
    attacker.attack();
    
    mac.runCode.assertCompromisedInstantaneously();
  }

  @Test
  public void appleScriptTestTestWithDefens() {
    MacOS mac = new MacOS("mac",false,true,false,false,false);
    User user = new User("user");

    user.addMacOS(mac);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userRights);
    attacker.attack();
    
    mac.runCode.assertUncompromised();
  }
}