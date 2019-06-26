import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class simpleTest{

  @Test
  public void test1(){
    // Section 1: Asset instantiation
    User user1 = new User("user1");
    Administrator administrator = new Administrator("admin");
    Adversary adversary = new Adversary("adversary");
    Employee employee1 = new Employee("employee1");

    Computer computer = new Computer("computer");
    ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
    PrivateNetwork privateNetwork = new PrivateNetwork("privateNetwork");
    RemovableMedia removableMedia = new RemovableMedia("removableMedia");

    Browser browser = new Browser("browser");
    Linux linux = new Linux("linux");

    // Section 2: Asset connections and attacker creation

    adversary.addBrowser(browser);
    adversary.addExternalNetwork(externalNetwork);
    adversary.addUser(user1);

    computer.addOs(linux);
    computer.addExternalNetwork(externalNetwork);
    computer.addUser(user1);

    user1.addBrowser(browser);
    user1.addOs(linux);
    linux.addBrowser(browser);
    externalNetwork.addOs(linux);

    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.spearphishingLinkAttack);
    attacker.attack();

    // Section 3: Assertions
    user1.stolenCredentials.assertCompromisedInstantaneously();
    computer.infectedComputer.assertCompromisedInstantaneously();

  }
}