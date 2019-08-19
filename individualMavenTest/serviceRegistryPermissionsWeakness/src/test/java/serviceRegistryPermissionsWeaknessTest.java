import org.junit.Test;

import core.*;
import attack.*;

public class serviceRegistryPermissionsWeaknessTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows", true);

        // Section 2: Asset connections and attacker creation
        administrator.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertUncompromised();
        windows.privilegeEscalation.assertUncompromised();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows", false);

        // Section 2: Asset connections and attacker creation
        administrator.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneously();
        windows.privilegeEscalation.assertCompromisedInstantaneously();
        
    }

    public void test3(){
        // Section 1: Asset instantiation
        SYSTEM system = new SYSTEM("system");
        Windows windows = new Windows("windows", true);

        // Section 2: Asset connections and attacker creation
        system.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(system.systemRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertUncompromised();
        windows.privilegeEscalation.assertUncompromised();

    }
    @Test
    public void test4(){
        // Section 1: Asset instantiation
        SYSTEM system = new SYSTEM("system");
        Windows windows = new Windows("windows", false);

        // Section 2: Asset connections and attacker creation
        system.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(system.systemRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneously();
        windows.privilegeEscalation.assertCompromisedInstantaneously();
        
    }
}