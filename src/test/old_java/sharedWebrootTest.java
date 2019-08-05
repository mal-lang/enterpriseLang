import org.junit.Test;

import core.*;
import attack.*;
public class sharedWebrootTest {

  @Test
  public void sharedWebrootTestNoDefens() {
    Server server = new Server("server");
    InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
    Browser browser = new Browser("browser");

    server.addBrowser(browser);
    server.addInternalNetwork(internalNetwork);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(browser.accessWebServer);
    attacker.addAttackPoint(server.infectedServer);
    attacker.attack();
    
    internalNetwork.connectedToNetwork.assertCompromisedInstantaneouslyFrom(server.sharedWebroot);
  }
  @Test
  public void sharedWebrootTestWhiteDefens() {
    Server server = new Server("server",false,true);
    InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
    Browser browser = new Browser("browser");

    server.addBrowser(browser);
    server.addInternalNetwork(internalNetwork);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(browser.accessWebServer);
    attacker.addAttackPoint(server.infectedServer);
    attacker.attack();
    
    internalNetwork.connectedToNetwork.assertUncompromisedFrom(server.sharedWebroot);
  }
}