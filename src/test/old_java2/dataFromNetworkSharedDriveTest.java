import org.junit.Test;

import core.*;
import attack.*;

public class dataFromNetworkSharedDriveTest {
  @Test
  public void dataFromNetworkSharedDriveTestNoDefense() {
    C2Server c2Server = new C2Server("c2Server");
    InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
    NetworkSharedDrive networkSharedDrive = new NetworkSharedDrive("networkSharedDrive");

    networkSharedDrive.addC2Server(c2Server);
    networkSharedDrive.addInternalNetwork(internalNetwork);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(internalNetwork.connectedToNetwork);
    attacker.attack();

    c2Server.obfuscatedData.assertCompromisedInstantaneously();
  }
  
}