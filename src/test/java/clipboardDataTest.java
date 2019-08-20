import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class clipboardDataTest {

  @Test
  public void clipboardTestNoDefens() {
    User user = new User("user");
    Administrator administrator = new Administrator("administrator");
    OS os = new OS("os");

    user.addOs(os);
    administrator.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(os.infectedOS);
    attacker.attack();

    user.userCredentials.assertCompromisedInstantaneously();
    administrator.adminCredentials.assertCompromisedInstantaneously();
  }
}