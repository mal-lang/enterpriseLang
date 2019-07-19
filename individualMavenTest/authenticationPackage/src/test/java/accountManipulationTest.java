import org.junit.Test;

import core.*;
import attack.*;

public class accountManipulationTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        Administrator admin = new Administrator("admin");
        Windows windows = new Windows("windows",true);

        // Section 2: Asset connections and attacker creation
        admin.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(admin.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertUncompromised();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        Administrator admin = new Administrator("admin");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        admin.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(admin.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneously();
        
    }
}