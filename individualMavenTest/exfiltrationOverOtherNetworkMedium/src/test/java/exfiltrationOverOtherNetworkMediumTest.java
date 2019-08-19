import org.junit.Test;

import core.*;
import attack.*;

public class exfiltrationOverOtherNetworkMediumTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        OtherNetworkMedium otherNetworkMedium = new OtherNetworkMedium("otherNetworkMedium");
        OS os = new OS("os", true);

        // Section 2: Asset connections and attacker creation
        otherNetworkMedium.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.dataCollected);
        attacker.attack();

        // Section 3: Assertions
        otherNetworkMedium.send.assertUncompromised();
    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        OtherNetworkMedium otherNetworkMedium = new OtherNetworkMedium("otherNetworkMedium");
        OS os = new OS("os");

        // Section 2: Asset connections and attacker creation
        otherNetworkMedium.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.dataCollected);
        attacker.attack();

        // Section 3: Assertions
        otherNetworkMedium.send.assertCompromisedInstantaneously();        
    }
}