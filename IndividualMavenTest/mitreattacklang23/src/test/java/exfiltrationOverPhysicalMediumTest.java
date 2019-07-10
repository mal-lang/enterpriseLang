import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
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
        attacker.addAttackerPoint(employee.mediaInserted);
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.addAttackerPoint(computer.dataEncrypted);

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
        attacker.addAttackerPoint(employee.mediaInserted);
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.addAttackerPoint(computer.dataEncrypted);


        attacker.attack();


        removableMedia.dataExfiltrated.assertCompromisedInstantaneously();

    }
}
