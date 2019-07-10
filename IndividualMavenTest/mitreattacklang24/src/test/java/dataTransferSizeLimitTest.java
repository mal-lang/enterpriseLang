import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataTransferSizeLimitTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        C2Server c2Server = new C2Server("c2Server", true);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true);

        internalNetwork.addC2Server(c2Server);
        computer.addC2Server(c2Server);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.dataCollected);

        attacker.attack();


        c2Server.dataExfiltrated.assertUncompromised();

    }
    public void test2(){
        Computer computer = new Computer("computer");
        C2Server c2Server = new C2Server("c2Server", false);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false);

        internalNetwork.addC2Server(c2Server);
        computer.addC2Server(c2Server);
        
        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.dataCollected);


        attacker.attack();


        c2Server.dataExfiltrated.assertCompromisedInstantaneously();

    }
}
