import org.junit.Test;

import core.*;
import attack.*;

public class credentialsInFilesTest{

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
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        user.userCredentials.assertCompromisedInstantaneouslyFrom(os._credentialsInFiles);
        administrator.adminCredentials.assertCompromisedInstantaneouslyFrom(os._credentialsInFiles);
        system.systemCredentials.assertCompromisedInstantaneouslyFrom(os._credentialsInFiles);
    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        SYSTEM system = new SYSTEM("system");
        OS os = new OS("os",false,false,false,true,false,false,true,false,false,true,true,true,false);

        // Section 2: Asset connections and attacker creation
        user.addOs(os);
        administrator.addOs(os);
        system.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        user.userCredentials.assertUncompromisedFrom(os._credentialsInFiles);
        administrator.adminCredentials.assertUncompromisedFrom(os._credentialsInFiles);
        system.systemCredentials.assertUncompromisedFrom(os._credentialsInFiles);
    }
    
}