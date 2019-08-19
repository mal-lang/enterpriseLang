import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class bootkitTest{

    @Test
    public void test1(){
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows", true,true);
        
        administrator.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        windows.persistance.assertUncompromised();
    }
    @Test
    public void test2(){
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows");
        
        administrator.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        windows.persistance.assertCompromisedInstantaneously();
    }
    @Test
    public void test3(){
        Administrator administrator = new Administrator("administrator");
        Linux linux = new Linux("linux");
        
        administrator.addLinux(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        linux.persistance.assertCompromisedInstantaneously();
    }
    @Test
    public void test4(){
        Administrator administrator = new Administrator("administrator");
        Linux linux = new Linux("linux", true,true);
        
        administrator.addLinux(linux);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        linux.persistance.assertUncompromised();
    }
}