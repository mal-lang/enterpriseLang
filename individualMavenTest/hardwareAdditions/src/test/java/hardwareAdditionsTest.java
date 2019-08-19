import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class hardwareAdditionsTest {

  @Test
  public void testHardwareAdditions() {
    // Section 1: Asset instantiation
    Adversary adversary = new Adversary("adversary");
    ExternalNetwork externalNetwork = new ExternalNetwork("Network");
    AdversaryHardwareTool adversaryHardwareTool = new AdversaryHardwareTool("attackTool");

    // Section 2: Asset connections and attacker creation

    //adversaryHardwareTool.addExternalNetwork(externalNetwork);
    adversary.addAdversaryHardwareTool(adversaryHardwareTool);
    externalNetwork.addAdversaryHardwareTool(adversaryHardwareTool);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.useHardwareTool);
    attacker.attack();
    // Section 3: Assertions

    
    externalNetwork.wirelessAccessAndPassiveNetworkTapping.assertCompromisedInstantaneously();

  }
}