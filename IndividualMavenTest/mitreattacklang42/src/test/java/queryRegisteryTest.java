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


        computer.networkServiceScan.assertUncompromised();

    }
    @Test
    public void test2(){
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false, false);

        administrator.addComputer(computer);
        internalNetwork.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        computer.networkServiceScan.assertCompromisedInstantaneously();

    }
}
