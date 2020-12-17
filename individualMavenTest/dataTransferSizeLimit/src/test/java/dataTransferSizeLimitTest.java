import org.junit.Test;

import core.*;
import attack.*;

public class dataTransferSizeLimitTest{

    @Test
    public void test1(){
        OS os = new OS("os");
        C2Server c2Server = new C2Server("c2Server");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true);

        internalNetwork.addC2Server(c2Server);
        os.addC2Server(c2Server);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.dataCollected);

        attacker.attack();


        c2Server.dataExfiltrated.assertUncompromised();

    }
    public void test2(){
        OS os = new OS("os");
        C2Server c2Server = new C2Server("c2Server");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false);

        internalNetwork.addC2Server(c2Server);
        os.addC2Server(c2Server);
        
        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.dataCollected);


        attacker.attack();


        c2Server.dataExfiltrated.assertCompromisedInstantaneously();

    }
}
