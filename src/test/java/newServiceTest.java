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

        administrator.addOs(windows);
        windowsAdmin.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(windowsAdmin.systemRights);
        attacker.attack();

        windows.persistance.assertUncompromised();

    }
    public void test2(){
        Administrator administrator = new Administrator("administrator");
        WindowsAdmin windowsAdmin = new WindowsAdmin("windowsAdmin");
        Windows windows = new Windows("windows", false);

        administrator.addOs(windows);
        windowsAdmin.addOs(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(windowsAdmin.systemRights);
        attacker.attack();

        windows.persistance.assertCompromisedInstantaneously();
        
    }
}
