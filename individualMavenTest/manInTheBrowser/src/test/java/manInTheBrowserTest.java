import org.junit.Test;

import core.*;
import attack.*;
public class manInTheBrowserTest {
  @Test
  public void test() {
    Computer computer = new Computer("computer");
    Services services = new Services("services");
    Browser browser = new Browser("browser");
    InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
    
    browser.addInternalNetwork(internalNetwork);
    computer.addInternalNetwork(internalNetwork);
    services.addComputer(computer);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(browser.manInTheBrowser);
    attacker.attack();
    
    computer.dataCollected.assertCompromisedInstantaneously();
  }
  
}