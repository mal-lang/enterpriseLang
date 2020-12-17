import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class supplyChainCompromiseTest{

  @Test
  public void testNoSCRM(){
    // Section 1: Asset instantiation
    SupplyChain supplyChain = new SupplyChain("supplyChain");
    Computer computer = new Computer("computer");
    Adversary adversary = new Adversary("adversary");
    // Section 2: Asset connections and attacker creation
    adversary.addSupplyChain(supplyChain);
    computer.addSupplyChain(supplyChain);

    
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.supplyChainCompromiseAttack);
    attacker.attack();

    // Section 3: Assertions
    computer.infectedComputer.assertCompromisedInstantaneously();

  }

  public void testWithSCRM(){
    // Section 1: Asset instantiation
    SupplyChain supplyChain = new SupplyChain("supplyChain",true);
    Computer computer = new Computer("computer");
    Adversary adversary = new Adversary("adversary");
    // Section 2: Asset connections and attacker creation
    adversary.addSupplyChain(supplyChain);
    computer.addSupplyChain(supplyChain);

    
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.supplyChainCompromiseAttack);
    attacker.attack();

    // Section 3: Assertions
    computer.infectedComputer.assertUncompromised();

  }
}