import org.junit.Test;

import core.*;
import attack.*;

public class launchAgentTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        MacOS macOS = new MacOS("macOS");
        Administrator administrator = new Administrator("administrator");

        // Section 2: Asset connections and attacker creation
        user.addMacOS(macOS);
        administrator.addMacOS(macOS);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        macOS.persistence.assertCompromisedInstantaneously();
        macOS.persistence.assertUncompromisedFrom(macOS.launchAgentAllUsersOnTheMac);
    }
    @Test
    public void test2(){
        User user = new User("user");
        MacOS macOS = new MacOS("macOS");
        Administrator administrator = new Administrator("administrator");

        // Section 2: Asset connections and attacker creation
        user.addMacOS(macOS);
        administrator.addMacOS(macOS);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        macOS.persistence.assertCompromisedInstantaneously();
        macOS.persistence.assertCompromisedInstantaneouslyFrom(macOS.launchAgentAllUsersOnTheMac);
        
    }
    @Test
    public void test3(){
        User user = new User("user");
        MacOS macOS = new MacOS("macOS",true);
        Administrator administrator = new Administrator("administrator");

        // Section 2: Asset connections and attacker creation
        user.addMacOS(macOS);
        administrator.addMacOS(macOS);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        macOS.persistence.assertUncompromised();
        macOS.persistence.assertUncompromisedFrom(macOS.launchAgentAllUsersOnTheMac);
        
    }
}