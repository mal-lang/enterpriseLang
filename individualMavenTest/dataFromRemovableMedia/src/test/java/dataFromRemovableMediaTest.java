import org.junit.Test;

import core.*;
import attack.*;

public class dataFromRemovableMediaTest {
  @Test
  public void ddataFromRemovableMediaTestNoDefense() {
    Computer computer = new Computer("computer");
    RemovableMedia removableMedia = new RemovableMedia("removableMedia");
 
    removableMedia.addComputer(computer);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(computer.infectedComputer);
    attacker.attack();


    removableMedia.data.assertCompromisedInstantaneously();
  }
  
}