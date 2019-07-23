import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class externalRemoteServicesTest{

  @Test
  public void testWithoutMultiFactorAuthentication() {
    // Section 1: Asset instantiation
    User user = new User("user");
    ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
    InternalNetwork privateNetwork = new InternalNetwork("privateNetwork");


    // Section 2: Asset connections and attacker creation
    user.addExternalNetwork(externalNetwork);
    externalNetwork.addInternalNetwork(privateNetwork);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.connectToVpn);
    attacker.attack();

    // Section 3: Assertions
    privateNetwork.vpnInternalConnection.assertCompromisedInstantaneously();
  }

  @Test
  public void testWithMultiFactorAuthentication() {
    // Section 1: Asset instantiation
    User user = new User("user");
    ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork",true);
    InternalNetwork privateNetwork = new InternalNetwork("privateNetwork");


    // Section 2: Asset connections and attacker creation
    user.addExternalNetwork(externalNetwork);
    externalNetwork.addInternalNetwork(privateNetwork);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.connectToVpn);
    attacker.attack();

    // Section 3: Assertions
    privateNetwork.vpnInternalConnection.assertUncompromised();
  }
}
