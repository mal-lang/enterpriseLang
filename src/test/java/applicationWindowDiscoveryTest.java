import org.junit.Test;

import core.*;
import attack.*;

public class applicationWindowDiscoveryTest{
    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Os os = new OS("os", true);

        // Section 2: Asset connections and attacker creation
        user.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        os.applicationWindowDiscovery.assertUncompromised();
    }

    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Os os = new OS("os", false);

        // Section 2: Asset connections and attacker creation
        user.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        os.applicationWindowDiscovery.assertCompromisedInstantaneously();
     
        
    }
}