import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class exfiltrationOverAlternativeProtocolTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true);
        Firewall firewall = new Firewall("firewall");

        computer.addInternalNetwork(internalNetwork);
        internalNetwork.addExternalNetwork(externalnetwork);
        firewall.addInternalNetwork(internalNetwork)


        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.addAttackerPoint(computer.dataEncrypted);

        attacker.attack();


        externalNetwork.dataExfiltrated.assertUncompromised();

    }
    public void test2(){
        Computer computer = new Computer("computer");
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true);
        
        computer.addInternalNetwork(internalNetwork);
        internalNetwork.addExternalNetwork(externalnetwork);

        
        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.addAttackerPoint(computer.dataEncrypted);

        attacker.attack();


        externalNetwork.dataExfiltrated.assertCompromisedInstantaneously();

    }
}
