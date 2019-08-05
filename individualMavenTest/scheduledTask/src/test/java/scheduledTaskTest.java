import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class scheduledTaskTest{

    @Test
    public void test1(){
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows", true);

        administrator.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        windows.scheduledTask.assertUncompromised();

    }
    public void test2(){
        Administrator administrator = new Administrator("administrator");
        Windows windows = new Windows("windows", false);

        administrator.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        windows.scheduledTask.assertCompromisedInstantaneously();

    }
}
