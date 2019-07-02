import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class bootkitTest{

    @Test
    public void test1(){
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows", true);
        
        administrator.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        windows.persistance.assertUncompromised();
    }
    public void test2(){
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows", false);
        
        administrator.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        windows.persistance.assertCompromisedInstantaneously();
    }
    public void test3(){
        Administrator administrator = new Administrator("administrator");
        Linux linux = new Linux("linux", false);
        
        administrator.addOs(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        linux.persistance.assertCompromisedInstantaneously();
    }
    public void test4(){
        Administrator administrator = new Administrator("administrator");
        Linux linux = new Linux("linux", true);
        
        administrator.addOs(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        linux.persistance.assertUncompromised();
    }
}