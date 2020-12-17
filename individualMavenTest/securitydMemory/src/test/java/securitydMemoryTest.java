import org.junit.Test;

import core.*;
import attack.*;

public class securitydMemoryTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        MacOS mac = new MacOS("MacOS");

        // Section 2: Asset connections and attacker creation
        user.addMacOS(mac);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(mac.runAsRoot);
        attacker.attack();

        // Section 3: Assertions
        user.userCredentials.assertCompromisedInstantaneously();

    }
   
}