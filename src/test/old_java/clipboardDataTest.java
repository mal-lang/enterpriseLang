import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class clipboardDataTest {

  @Test
  public void clipboardTestNoDefens() {
    User user = new User("user");
    Computer computer = new Computer("computer");
    OS os = new OS("os");

    user.addOs(os);
    computer.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    // linux.bashHistory.assertCompromisedInstantaneously();
    user.userCredentials.assertCompromisedInstantaneously();
    user.adminLogin.assertCompromisedInstantaneously();
  }

  @Test
  public void clipboardTestWithDefens() {
    User user = new User("user");
    Computer computer = new Computer("computer");
    OS os = new OS("os",true,false,false);

    user.addOs(os);
    computer.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    // linux.bashHistory.assertCompromisedInstantaneously();
    user.userCredentials.assertUncompromised();
    user.adminLogin.assertUncompromised();
  }
}