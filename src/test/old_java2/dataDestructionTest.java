import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataDestructionTest{

    @Test
    public void test1(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os" ,false,false,false,false,false
                            ,false,false,false,false,false
                            ,false,false,false,false,true
                            ,false,false,false,false,false);

        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        os.userDataDestruction.assertUncompromised();
    }
    
    public void test2(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os");

        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        os.userDataDestruction.assertCompromisedInstantaneously();
    }
    public void test3(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os");

        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        os.adminDataDestruction.assertCompromisedInstantaneously();
    }

}