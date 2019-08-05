import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class queryRegisteryTest{

    @Test
    public void test1(){
        WindowsAdministrator windowsAdministrator = new WindowsAdministrator("windowsAdministrator");
        Windows windows = new Windows("windows", true);

        windowsAdministrator.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(windowsAdministrator.systemRights);
        attacker.attack();


        windows.queryRegistery.assertUncompromised();

    }
    @Test
    public void test2(){
        WindowsAdministrator windowsAdministrator = new WindowsAdministrator("windowsAdministrator");
        Windows windows = new Windows("windows", false);

        windowsAdministrator.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(windowsAdministrator.systemRights);
        attacker.attack();



        windows.queryRegistery.assertCompromisedInstantaneously();

    }
}
