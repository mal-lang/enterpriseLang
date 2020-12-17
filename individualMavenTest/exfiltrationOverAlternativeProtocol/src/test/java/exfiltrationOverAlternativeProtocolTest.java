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
        internalNetwork.addExternalNetwork(externalNetwork);
        firewall.addInternalNetwork(internalNetwork);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.dataCollected);
        attacker.addAttackPoint(computer.dataCompressed);
        attacker.addAttackPoint(computer.dataEncrypted);

        attacker.attack();


        externalNetwork.dataExfiltrated.assertUncompromised();

    }
    public void test2(){
        Computer computer = new Computer("computer");
        ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true);
        
        computer.addInternalNetwork(internalNetwork);
        internalNetwork.addExternalNetwork(externalNetwork);

        
        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.dataCollected);
        attacker.addAttackPoint(computer.dataCompressed);
        attacker.addAttackPoint(computer.dataEncrypted);

        attacker.attack();


        externalNetwork.dataExfiltrated.assertCompromisedInstantaneously();

    }
}
