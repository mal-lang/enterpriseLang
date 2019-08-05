import org.junit.Test;

import core.*;
import attack.*;

public class webShellTest {
  @Test
  public void test() {
    Server server = new Server("server");
    C2Server c2Server = new C2Server("c2Server");
    InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");

    server.addC2Server(c2Server);
    server.addInternalNetwork(internalNetwork);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(internalNetwork.connectedToNetwork);
    attacker.attack();

    //c2Server.obfuscatedData.assertUncompromised();
    c2Server.obfuscatedData.assertCompromisedInstantaneously();
  }
}