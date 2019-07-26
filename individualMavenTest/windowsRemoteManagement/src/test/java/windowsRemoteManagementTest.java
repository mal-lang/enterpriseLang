import org.junit.Test;

import core.*;
import attack.*;

public class windowsRemoteManagementTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator admin = new Administrator("admin");
        Windows windows = new Windows("windows", true,true);

        // Section 2: Asset connections and attacker creation
        user.addOs(windows);
        admin.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(windows.startAttack);
        attacker.attack();

        // Section 3: Assertions
        windows.lateralMovement.assertUncompromised();
        windows.executeCodeUser.assertUncompromised();
        windows.executeCodeAdmin.assertUncompromised();
    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator admin = new Administrator("admin");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        user.addOs(windows);
        admin.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(windows.startAttack);
        attacker.attack();

        // Section 3: Assertions
        windows.lateralMovement.assertCompromisedInstantaneously();
        windows.executeCodeUser.assertCompromisedInstantaneously();
        windows.executeCodeAdmin.assertUncompromised();
    }
    @Test
    public void test3(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator admin = new Administrator("admin");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        user.addOs(windows);
        admin.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(admin.adminRights);
        attacker.addAttackPoint(windows.startAttack);
        attacker.attack();

        // Section 3: Assertions
        windows.lateralMovement.assertCompromisedInstantaneously();
        windows.executeCodeUser.assertUncompromised();
        windows.executeCodeAdmin.assertCompromisedInstantaneously();
    }
}