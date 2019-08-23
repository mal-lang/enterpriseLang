import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class commonlyUsedPortsTest{

    @Test
    public void test1(){
        OS os = new OS("os");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork",false,false,false,false,true,true,false);
        C2Server c2Server = new C2Server("c2Server");
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");


        externalNetwork.addOs(os);
        internalNetwork.addOs(os);
        c2Server.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.infectedOS);
        attacker.attack();


        internalNetwork.bypassFirewall.assertUncompromisedFrom(os.commonlyUsedPortsConnection);
        internalNetwork.bypassNetworkDetection.assertUncompromisedFrom(os.commonlyUsedPortsConnection);
        externalNetwork.bypassFirewall.assertUncompromisedFrom(os.commonlyUsedPortsConnection);
        externalNetwork.bypassNetworkDetection.assertUncompromisedFrom(os.commonlyUsedPortsConnection);


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


        internalNetwork.bypassFirewall.assertCompromisedInstantaneouslyFrom(os.commonlyUsedPortsConnection);
        internalNetwork.bypassNetworkDetection.assertCompromisedInstantaneouslyFrom(os.commonlyUsedPortsConnection);
        externalNetwork.bypassFirewall.assertCompromisedInstantaneouslyFrom(os.commonlyUsedPortsConnection);
        externalNetwork.bypassNetworkDetection.assertCompromisedInstantaneouslyFrom(os.commonlyUsedPortsConnection);


    }
}
