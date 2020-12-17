import org.junit.Test;

import core.*;
import attack.*;

public class fileTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        OS os = new OS("os", true);

        // Section 2: Asset connections and attacker creation
        user.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        os.accountDiscovery.assertUncompromised();
        os.domainDiscovery.assertUncompromised();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        OS os = new OS("os");

        // Section 2: Asset connections and attacker creation
        user.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        os.accountDiscovery.assertCompromisedInstantaneously();
        os.domainDiscovery.assertCompromisedInstantaneously();
        
    }
}