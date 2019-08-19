import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class clipboardDataTest {

  @Test
  public void clipboardTestNoDefens() {
    User user = new User("user");
    OS os = new OS("os");

    user.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(os.infectedOS);
    attacker.attack();

    user.userCredentials.assertCompromisedInstantaneously();
    user.adminLogin.assertCompromisedInstantaneously();
  }
}