import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class commonlyUsedPortsTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer", true);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
        C2Server c2Server = new C2Server("c2Server");
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");


        externalNetwork.addComputer(computer);
        internalNetwork.addComputer(computer);
        c2Server.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.infectedComputer);
        attacker.attack();


        internalNetwork.bypassFirewall.assertUncompromised();
        internalNetwork.bypassNetworkDetection.assertUncompromised();
        externalNetwork.bypassFirewall.assertUncompromised();
        externalNetwork.bypassNetworkDetection.assertUncompromised();


    }
    @Test
    public void test2(){
        Computer computer = new Computer("computer", false);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
        C2Server c2Server = new C2Server("c2Server");
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");


        externalNetwork.addComputer(computer);
        internalNetwork.addComputer(computer);
        c2Server.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.infectedComputer);
        attacker.attack();


        internalNetwork.bypassFirewall.assertCompromisedInstantaneously();
        internalNetwork.bypassNetworkDetection.assertCompromisedInstantaneously();
        externalNetwork.bypassFirewall.assertCompromisedInstantaneously();
        externalNetwork.bypassNetworkDetection.assertCompromisedInstantaneously();


    }
}
