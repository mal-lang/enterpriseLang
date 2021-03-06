import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class passwordPolicyDiscoveryTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        OS os = new OS("os");

        // Section 2: Asset connections and attacker creation
        user.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        os.bruteForce.assertCompromisedInstantaneously();
     
    }
}