import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class exfiltrationOverCommandAndControlChannelTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        C2Server c2server = new C2Server("c2server", true);

        computer.addC2Server(c2server);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.addAttackerPoint(computer.dataEncrypted);

        attacker.attack();


        c2server.dataExfiltrated.assertUncompromised();

    }
    public void test2(){
        Computer computer = new Computer("computer");
        C2Server c2server = new C2Server("c2server", true);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.addAttackerPoint(computer.dataEncrypted);

        attacker.attack();


        c2server.dataExfiltrated.assertCompromisedInstantaneously();

    }
}
