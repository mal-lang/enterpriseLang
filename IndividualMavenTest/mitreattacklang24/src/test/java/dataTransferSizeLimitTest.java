import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataTransferSizeLimitTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        C2Server c2Server = new C2Server("c2Server", true);

        computer.addC2Server(c2Server);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);

        attacker.attack();


        c2Server.dataExfiltrated.assertUncompromised();

    }
    public void test2(){
        Computer computer = new Computer("computer");
        C2Server c2Server = new C2Server("c2Server", false);

        computer.addC2Server(c2Server);
        
        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);


        attacker.attack();


        c2Server.dataExfiltrated.assertCompromisedInstantaneously();

    }
}
