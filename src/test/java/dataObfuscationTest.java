import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataObfuscationTest{

    @Test
    public void test1(){
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork", true, true);
        C2Server c2Server = new C2Server("c2Server");

        externalNetwork.addC2Server(c2Server);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(c2Server.c2Connexion);
        attacker.attack();

        externalNetwork.bypassNetworkDetection.assertUncompromised();
    }
    public void test2(){
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork", false, false);
        C2Server c2Server = new C2Server("c2Server");

        externalNetwork.addC2Server(c2Server);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(c2Server.c2Connexion);
        attacker.attack();

        externalNetwork.bypassNetworkDetection.assertCompromisedInstantaneously();
    }
}