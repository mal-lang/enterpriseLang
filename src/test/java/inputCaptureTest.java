import org.junit.Test;

import core.*;
import attack.*;

public class inputCaptureTest {

  @Test
  public void test() {
    Computer computer = new Computer("computer");
    User user = new User("user");

    user.addComputer(computer);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();
    
    user.userCredentials.assertCompromisedInstantaneously();
  }
  

}