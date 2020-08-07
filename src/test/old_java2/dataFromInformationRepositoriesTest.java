import org.junit.Test;

import core.*;
import attack.*;

public class dataFromInformationRepositoriesTest {

  @Test
  public void test() {
    OS os = new OS("os");
    Service service = new Service("service");
 
    service.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(os.infectedOS);
    attacker.attack();
    
    os.dataCollected.assertCompromisedInstantaneously();
  }
}