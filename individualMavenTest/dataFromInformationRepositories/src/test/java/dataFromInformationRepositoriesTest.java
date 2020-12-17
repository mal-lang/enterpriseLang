import org.junit.Test;

import core.*;
import attack.*;

public class dataFromInformationRepositoriesTest {

  @Test
  public void test() {
    OS os = new OS("os");
    Services services = new Services("services");
 
    services.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(os.infectedOS);
    attacker.attack();
    
    os.dataCollected.assertCompromisedInstantaneously();
  }
}