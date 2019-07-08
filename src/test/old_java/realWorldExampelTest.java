import org.junit.Test;

import core.*;
import attack.*;

public class realWorldExampelTest{
  User user = new User("user");
  Adversary adversary = new Adversary("adversary");
  Computer computer = new Computer("computer");
  ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
  Browser browser = new Browser("browser");
  Windows windows= new Windows("windows");


  @Test
  public void step1(){
    
    // Section 2: Asset connections and attacker creation
    adversary.addBrowser(browser);
    adversary.addUser(user);
    adversary.addExternalNetwork(externalNetwork);
    adversary.addComputer(computer);

    computer.addOs(windows);
    computer.addExternalNetwork(externalNetwork);
    computer.addUser(user);

    user.addBrowser(browser);
    user.addComputer(computer);

    windows.addBrowser(browser);



    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.linkClicked);
    attacker.attack();

    // Section 3: Assertions
    computer.infectedComputer.assertCompromisedInstantaneously();

  }
  @Test
  public void step2(){
    
    // Section 2: Asset connections and attacker creation
    adversary.addBrowser(browser);
    adversary.addUser(user);
    adversary.addExternalNetwork(externalNetwork);
    adversary.addComputer(computer);

    computer.addOs(windows);
    computer.addExternalNetwork(externalNetwork);
    computer.addUser(user);

    user.addBrowser(browser);
    user.addComputer(computer);

    windows.addBrowser(browser);



    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    // Section 3: Assertions
    adversary.obfuscateData.assertCompromisedInstantaneously();

  }
  @Test
  public void step3(){
    
    // Section 2: Asset connections and attacker creation
    adversary.addBrowser(browser);
    adversary.addUser(user);
    adversary.addExternalNetwork(externalNetwork);
    adversary.addComputer(computer);


    computer.addOs(windows);
    computer.addExternalNetwork(externalNetwork);
    computer.addUser(user);

    user.addBrowser(browser);
    user.addComputer(computer);

    windows.addBrowser(browser);



    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.obfuscateData);
    attacker.attack();

    // Section 3: Assertions
    externalNetwork.upload.assertCompromisedInstantaneously();

  }
}