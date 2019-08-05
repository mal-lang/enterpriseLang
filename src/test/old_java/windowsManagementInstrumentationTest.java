import org.junit.Test;

import core.*;
import attack.*;

public class windowsManagementInstrumentationTest {

  @Test
  public void TestNoDefense() {
    User user = new User("user");
    Computer computer = new Computer("computer");
    Windows win = new Windows("win");

    user.addWindows(win);
    computer.addWindows(win);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.windowsAdminShares);
    attacker.attack();

    user.userRights.assertCompromisedInstantaneously();
  }
  
  
}