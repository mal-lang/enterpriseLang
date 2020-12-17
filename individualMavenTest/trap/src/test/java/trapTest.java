import org.junit.Test;

import core.*;
import attack.*;

public class trapTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        Administrator administrator = new Administrator("administrator");
        Linux linux = new Linux("linux");

        // Section 2: Asset connections and attacker creation
        administrator.addLinux(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        linux.persistence.assertCompromisedInstantaneously();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Linux linux = new Linux("linux");

        // Section 2: Asset connections and attacker creation
        user.addLinux(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        linux.persistence.assertCompromisedInstantaneously();
        
    }
    @Test
    public void test3(){
        // Section 1: Asset instantiation
        Administrator administrator = new Administrator("administrator");
        MacOS macOS = new MacOS("macOS");

        // Section 2: Asset connections and attacker creation
        administrator.addMacOS(macOS);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        macOS.persistence.assertCompromisedInstantaneously();

    }
    @Test
    public void test4(){
        // Section 1: Asset instantiation
        User user = new User("user");
        MacOS macOS = new MacOS("macOS");

        // Section 2: Asset connections and attacker creation
        user.addMacOS(macOS);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        macOS.persistence.assertCompromisedInstantaneously();
        
    }
}