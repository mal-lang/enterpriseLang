import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class commonlyUsedPortsTest{

    @Test
    public void test1(){
        OS os = new OS("os");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork",true,true);
        C2Server c2Server = new C2Server("c2Server");
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");


        externalNetwork.addOs(os);
        internalNetwork.addOs(os);
        c2Server.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.infectedOS);
        attacker.attack();


        internalNetwork.bypassFirewall.assertUncompromised();
        internalNetwork.bypassNetworkDetection.assertUncompromised();
        externalNetwork.bypassFirewall.assertUncompromised();
        externalNetwork.bypassNetworkDetection.assertUncompromised();


    }
    @Test
    public void test2(){
        OS os = new OS("os");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
        C2Server c2Server = new C2Server("c2Server");
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");


        externalNetwork.addOs(os);
        internalNetwork.addOs(os);
        c2Server.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.infectedOS);
        attacker.attack();


        internalNetwork.bypassFirewall.assertCompromisedInstantaneously();
        internalNetwork.bypassNetworkDetection.assertCompromisedInstantaneously();
        externalNetwork.bypassFirewall.assertCompromisedInstantaneously();
        externalNetwork.bypassNetworkDetection.assertCompromisedInstantaneously();


    }
}
