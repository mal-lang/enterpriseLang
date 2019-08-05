import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class  trustedRelationshipTest{

  @Test
  public void testNetworkUnitThirdParty(){
    // Section 1: Asset instantiation
    Adversary adversary = new Adversary("adversary");
    NetworkUnitThirdParty networkUnitThirdParty = new NetworkUnitThirdParty("networkUnitThirdParty");
    InternalNetwork privateNetwork = new InternalNetwork("privateNetwork");

    // Section 2: Asset connections and attacker creation

    adversary.addNetworkUnitThirdParty(networkUnitThirdParty);
    networkUnitThirdParty.addInternalNetwork(privateNetwork);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.thirdPartySystemAccess);
    attacker.attack();

    // Section 3: Assertions
    privateNetwork.connectedToNetwork.assertCompromisedInstantaneously();

  }


  @Test
  public void testEmployeeThirdPartyRemovableMedia(){
    // Section 1: Asset instantiation
    EmployeeThirdParty employeeThirdParty = new EmployeeThirdParty ("employeeThirdParty");
    RemovableMedia removableMedia = new RemovableMedia("removableMedia");
    Employee employee = new Employee("employee");
    Computer computer = new Computer("computer");
    User user = new User("user");

    removableMedia.addEmployee(employee);
    employee.addComputer(computer);
    employee.addUser(user);
    employeeThirdParty.addRemovableMedia(removableMedia);



    Attacker attacker = new Attacker();
    attacker.addAttackPoint(employeeThirdParty.infectedMedia);
    attacker.attack();

    // Section 3: Assertions
    computer.infectedComputer.assertCompromisedInstantaneously();

  }
}
