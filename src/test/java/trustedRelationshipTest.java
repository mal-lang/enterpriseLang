import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class  trustedRelationshipTest{

  @Test
  public void test1(){
    // Section 1: Asset instantiation
    Adversary adversary = new Adversary("adversary");
    NetworkUnitThirdParty networkUnitThirdParty = new NetworkUnitThirdParty("networkUnitThirdParty");
    PrivateNetwork privateNetwork = new PrivateNetwork("privateNetwork");

    // Section 2: Asset connections and attacker creation

    adversary.addNetworkUnitThirdParty(networkUnitThirdParty);
    networkUnitThirdParty.addPrivateNetwork(privateNetwork);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.thirdPartySystemAccess);
    attacker.attack();

    // Section 3: Assertions
    privateNetwork.connectedToNetwork.assertCompromisedInstantaneously();

  }


  @Test
  public void test2(){
    // Section 1: Asset instantiation
    EmployeeThirdParty employeeThirdParty = new EmployeeThirdParty ("employeeThirdParty");
    Computer computer = new Computer("computer");
    RemovableMedia removableMedia = new RemovableMedia("removableMedia");
    Adversary adversary = new Adversary("adversary");
    Linux linux= new Linux("linux",false,false);


    // Section 2: Asset connections and attacker creation

    //employeeThirdParty.addComputer(computer);
    adversary.addRemovableMedia(removableMedia);
    adversary.addEmployeeThirdParty(employeeThirdParty);
    computer.addRemovableMedia(removableMedia);
    computer.addOs(linux);
    linux.addRemovableMedia(removableMedia);
    employeeThirdParty.addRemovableMedia(removableMedia);



    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.insertInfectedMedia);
    attacker.attack();

    // Section 3: Assertions
    computer.infectedComputer.assertCompromisedInstantaneously();

  }
}
