import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class standardApplicationLayerProtocolTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true);
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
        C2Server c2Server = new C2Server("c2server");

        internalNetwork.addComputer(computer);
        internalNetwork.addC2Server(c2Server);
        internalNetwork.addExternalNetwork(externalNetwork);


        administrator.addComputer(computer);
        internalNetwork.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.infectedComputer);
        attacker.attack();


        c2Server.c2Connexion.assertUncompromised();
        internalNetwork.bypassNetworkDetection.assertUncompromised();
        externalNetwork.bypassNetworkDetection.assertUncompromised();

    }
    @Test
    public void test2(){
        Computer computer = new Computer("computer");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false);
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
        C2Server c2Server = new C2Server("c2server");

        internalNetwork.addComputer(computer);
        internalNetwork.addC2Server(c2Server);
        internalNetwork.addExternalNetwork(externalNetwork);


        administrator.addComputer(computer);
        internalNetwork.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.infectedComputer);
        attacker.attack();


        c2Server.c2Connexion.assertCompromisedInstantaneously();
        internalNetwork.bypassNetworkDetection.assertCompromisedInstantaneously();
        externalNetwork.bypassNetworkDetection.assertCompromisedInstantaneously();

    }
}
