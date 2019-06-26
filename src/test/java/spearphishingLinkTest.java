import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class spearphishingLinkTest{

  
  @Test
  public void testNoDefens() {
    User user = new User("user");
    Adversary adversary = new Adversary("adversary");
    Computer computer = new Computer("computer");
    ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
    Browser browser = new Browser("browser");
    Linux linux= new Linux("linux");

    // Section 2: Asset connections and attacker creation
    adversary.addBrowser(browser);
    adversary.addUser(user);
    adversary.addExternalNetwork(externalNetwork);

    computer.addOs(linux);
    computer.addExternalNetwork(externalNetwork);
    computer.addUser(user);

    user.addBrowser(browser);
    user.addComputer(computer);

    linux.addBrowser(browser);



    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.linkClicked);
    attacker.attack();

    // Section 3: Assertions
    user.stolenCredentials.assertCompromisedInstantaneously();
    computer.infectedComputer.assertCompromisedInstantaneously();
  }

  @Test
  public void testAllDefenses() {
    User user = new User("user");
    Adversary adversary = new Adversary("adversary");
    Computer computer = new Computer("computer");
    ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
    Browser browser = new Browser("browser",true);
    Linux linux= new Linux("linux",false,true,false);

    // Section 2: Asset connections and attacker creation
    adversary.addBrowser(browser);
    adversary.addUser(user);
    adversary.addExternalNetwork(externalNetwork);

    computer.addOs(linux);
    computer.addExternalNetwork(externalNetwork);
    computer.addUser(user);

    user.addBrowser(browser);
    user.addComputer(computer);

    linux.addBrowser(browser);


    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.linkClicked);
    attacker.attack();

    // Section 3: Assertions
    user.stolenCredentials.assertUncompromised();
    computer.infectedComputer.assertUncompromised();
  }

  @Test
  public void testWithAntivirus() {
    User user = new User("user");
    Adversary adversary = new Adversary("adversary");
    Computer computer = new Computer("computer");
    ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
    Browser browser = new Browser("browser");
    Linux linux= new Linux("linux",false,true,false);

    // Section 2: Asset connections and attacker creation
    adversary.addBrowser(browser);
    adversary.addUser(user);
    adversary.addExternalNetwork(externalNetwork);

    computer.addOs(linux);
    computer.addExternalNetwork(externalNetwork);
    computer.addUser(user);

    user.addBrowser(browser);
    user.addComputer(computer);

    linux.addBrowser(browser);


    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.linkClicked);
    attacker.attack();

    // Section 3: Assertions
    user.stolenCredentials.assertCompromisedInstantaneously();
    computer.infectedComputer.assertUncompromised();
  }

  @Test
  public void testWithPhishingDetection() {
    User user = new User("user");
    Adversary adversary = new Adversary("adversary");
    Computer computer = new Computer("computer");
    ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
    Browser browser = new Browser("browser",true);
    Linux linux= new Linux("linux");

    // Section 2: Asset connections and attacker creation
    adversary.addBrowser(browser);
    adversary.addUser(user);
    adversary.addExternalNetwork(externalNetwork);

    computer.addOs(linux);
    computer.addExternalNetwork(externalNetwork);
    computer.addUser(user);

    user.addBrowser(browser);
    user.addComputer(computer);

    linux.addBrowser(browser);


    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.linkClicked);
    attacker.attack();

    // Section 3: Assertions
    user.stolenCredentials.assertUncompromised();
    computer.infectedComputer.assertUncompromised();
  }
  
}