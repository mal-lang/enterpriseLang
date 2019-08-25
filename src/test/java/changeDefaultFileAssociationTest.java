import org.junit.Test;

import core.*;
import attack.*;

public class changeDefaultFileAssociationTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        user.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneously();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        administrator.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneously();
        
    }
    @Test
    public void test3(){
        // Section 1: Asset instantiation
        SYSTEM system = new SYSTEM("system");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        system.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(system.systemRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneously();
        
    }
}