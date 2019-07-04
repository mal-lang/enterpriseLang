import org.junit.Test;

import core.*;
import attack.*;

public class exfiltrationOverPhysicalMediumTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        Employee employee = new Employee("employee", true);
        RemovableMedia removableMedia = new RemovableMedia("removableMedia");

        computer.addRemovableMedia(removableMedia);
        employee.addRemovableMedia(removableMedia);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(employee.mediaInserted);
        attacker.addAttackPoint(computer.dataCollected);
        attacker.addAttackPoint(computer.dataCompressed);
        attacker.addAttackPoint(computer.dataEncrypted);
        attacker.attack();


        removableMedia.dataExfiltrated.assertUncompromised();

    }
    public void test2(){
        Computer computer = new Computer("computer");
        Employee employee = new Employee("employee", false);
        RemovableMedia removableMedia = new RemovableMedia("removableMedia");

        computer.addRemovableMedia(removableMedia);
        employee.addRemovableMedia(removableMedia);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(employee.mediaInserted);
        attacker.addAttackPoint(computer.dataCollected);
        attacker.addAttackPoint(computer.dataCompressed);
        attacker.addAttackPoint(computer.dataEncrypted);
  

        attacker.attack();


        removableMedia.dataExfiltrated.assertCompromisedInstantaneously();

    }
}
