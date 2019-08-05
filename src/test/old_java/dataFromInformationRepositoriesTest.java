import org.junit.Test;

import core.*;
import attack.*;

public class dataFromInformationRepositoriesTest {

  @Test
  public void test() {
    Computer computer = new Computer("computer");
    Services services = new Services("services");
 
    services.addComputer(computer);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();
    
    computer.dataCollected.assertCompromisedInstantaneously();
  }
}