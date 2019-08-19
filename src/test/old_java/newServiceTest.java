import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class newServiceTest{

    @Test
    public void test1(){
        Administrator administrator = new Administrator("administrator");
        WindowsAdmin windowsAdmin = new WindowsAdmin("windowsAdmin");
        Windows windows = new Windows("windows", true);

        administrator.addWindows(windows);
        windowsAdmin.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(windowsAdmin.systemRights);
        attacker.attack();

        windows.persistance.assertUncompromised();

    }
    public void test2(){
        Administrator administrator = new Administrator("administrator");
        WindowsAdmin windowsAdmin = new WindowsAdmin("windowsAdmin");
        Windows windows = new Windows("windows", false);

        administrator.addWindows(windows);
        windowsAdmin.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(windowsAdmin.systemRights);
        attacker.attack();

        windows.persistance.assertCompromisedInstantaneously();
        
    }
}
