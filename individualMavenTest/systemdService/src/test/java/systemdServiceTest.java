import org.junit.Test;

import core.*;
import attack.*;

public class systemdServiceTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Linux linux = new Linux("linux",true, true);

        // Section 2: Asset connections and attacker creation
        user.addLinux(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        linux.persistence.assertUncompromisedFrom(linux.boot);
        linux.persistence.assertUncompromisedFrom(linux.runCode);
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
        linux.persistence.assertCompromisedInstantaneouslyFrom(linux.boot);
        linux.persistence.assertCompromisedInstantaneouslyFrom(linux.runCode);  
    }
    @Test
    public void test3(){
        // Section 1: Asset instantiation
        Root root = new Root("root");
        Linux linux = new Linux("linux",true, true);

        // Section 2: Asset connections and attacker creation
        root.addLinux(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(root.rootRights);
        attacker.attack();

        // Section 3: Assertions
        linux.persistence.assertUncompromisedFrom(linux.boot);
        linux.persistence.assertUncompromisedFrom(linux.runCode);
    }
    @Test
    public void test4(){
        // Section 1: Asset instantiation
        Root root = new Root("root");
        Linux linux = new Linux("linux");

        // Section 2: Asset connections and attacker creation
        root.addLinux(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(root.rootRights);
        attacker.attack();

        // Section 3: Assertions
        linux.persistence.assertCompromisedInstantaneouslyFrom(linux.boot);
        linux.persistence.assertCompromisedInstantaneouslyFrom(linux.runCode);
    }
}