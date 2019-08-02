import org.junit.Test;

import core.*;
import attack.*;

public class credentialsInRegistryTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os");

        // Section 2: Asset connections and attacker creation
        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        user.userCredentials.assertCompromisedInstantaneously();
        administrator.adminCredentials.assertCompromisedInstantaneously();
    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os",true,true,true);

        // Section 2: Asset connections and attacker creation
        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        user.userCredentials.assertUncompromised();
        administrator.adminCredentials.assertUncompromised();
    }
    
}