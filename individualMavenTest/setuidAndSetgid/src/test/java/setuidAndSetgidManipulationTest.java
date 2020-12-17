import org.junit.Test;

import core.*;
import attack.*;

public class setuidAndSetgidManipulationTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Admin admin = new Admin("admin");
        Linux linux = new Linux("linux");

        // Section 2: Asset connections and attacker creation
        user.addOs(linux);
        admin.addOs(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(linux.runFile);
        attacker.attack();

        // Section 3: Assertions
        linux.persistence.assertUncompromised();
    }
    
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        Admin admin = new Admin("admin");
        Linux linux = new Linux("linux");

        // Section 2: Asset connections and attacker creation
        admin.addOs(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(admin.adminRights);
        attacker.addAttackPoint(linux.runFile);

        attacker.attack();

        // Section 3: Assertions
        linux.persistence.assertCompromisedInstantaneously();
    }

    @Test
    public void test3(){
        // Section 1: Asset instantiation
        Admin admin = new Admin("admin");
        Linux linux = new Linux("linux", true);

        // Section 2: Asset connections and attacker creation
        admin.addOs(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(admin.adminRights);
        attacker.addAttackPoint(linux.runFile);

        attacker.attack();

        // Section 3: Assertions
        linux.persistence.assertUncompromised();
    }
}