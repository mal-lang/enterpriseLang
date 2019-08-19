import org.junit.Test;

import core.*;
import attack.*;

public class inputCaptureTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        SYSTEM system = new SYSTEM("system");
        OS os = new OS("os");

        // Section 2: Asset connections and attacker creation
        user.addOs(os);
        administrator.addOs(os);
        system.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.addAttackPoint(os.persistence);
        attacker.attack();

        // Section 3: Assertions
        user.userCredentials.assertCompromisedInstantaneously();
        administrator.adminCredentials.assertCompromisedInstantaneously();
        system.systemCredentials.assertCompromisedInstantaneously();
        os.dataCollection.assertCompromisedInstantaneously();
    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        SYSTEM system = new SYSTEM("system");
        OS os = new OS("os");

        // Section 2: Asset connections and attacker creation
        user.addOs(os);
        administrator.addOs(os);
        system.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(system.systemRights);
        attacker.addAttackPoint(os.persistence);
        attacker.attack();

        // Section 3: Assertions
        user.userCredentials.assertCompromisedInstantaneously();
        administrator.adminCredentials.assertCompromisedInstantaneously();
        system.systemCredentials.assertCompromisedInstantaneously();
        os.dataCollection.assertCompromisedInstantaneously();
    }
    
}