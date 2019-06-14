import org.junit.Test;

import core.*;
import attack.*;

public class replicationThroughRemovableMediaTest{

  @Test
  public void test1(){
    // Section 1: Asset instantiation
    OS os = new OS("os",false,false);
    User user = new User("user",false);
    Computer computer = new Computer("computer");
    RemovableMedia removableMedia = new RemovableMedia("removableMedia");


    // Section 2: Asset connections and attacker creation
    computer.addOs(os);
    user.addComputer(computer);

    removableMedia.addComputer(computer);
    removableMedia.addOs(os);
    
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(removableMedia.connected);
    attacker.attack();

    // Section 3: Assertions
    computer.infectedComputer.assertCompromisedInstantaneously();
  }

  @Test
  public void test2() {
    OS os = new OS("os",false,true);
    User user = new User("user",false);
    Computer computer = new Computer("computer");
    RemovableMedia removableMedia = new RemovableMedia("removableMedia");


    computer.addOs(os);
    user.addComputer(computer);

    removableMedia.addComputer(computer);
    removableMedia.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(removableMedia.connected);
    attacker.attack();

    computer.infectedComputer.assertUncompromised();
  }
}