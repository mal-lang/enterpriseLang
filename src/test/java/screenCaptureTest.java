import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class screenCaptureTest {

  @Test
  public void screenCaptureNoDefens() {
    Computer computer = new Computer("computer");
    OS os = new OS("os");

    computer.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    os.screenCapture.assertCompromisedInstantaneously();
  }

  @Test
  public void screenCaptureWithDefens() {
    Computer computer = new Computer("computer");
    OS os = new OS("os",false,false,true);

    computer.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();

    os.screenCapture.assertUncompromised();
  }
}