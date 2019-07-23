import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class processDiscoveryTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os", true);


        // Section 2: Asset connections and attacker creation
        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        os.detailedRunningProcessDiscovery.assertUncompromised();

    }
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os", false);


        // Section 2: Asset connections and attacker creation
        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        os.detailedRunningProcessDiscovery.assertCompromisedInstantaneously();
        
    }
    public void test3(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os", true);


        // Section 2: Asset connections and attacker creation
        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        os.runningProcessDiscovery.assertUncompromised();
        
    }
}