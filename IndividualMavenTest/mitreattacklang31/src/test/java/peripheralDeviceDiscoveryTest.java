import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class peripheralDeviceDiscoveryTest{

    @Test
    public void test1(){
        User user = new User("user");
        Windows windows = new Windows("windows");
        Computer computer = new Computer("computer", true);

        windows.addComputer(computer);
        user.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.peripheralDeviceDiscovery.assertUncompromised();

    }
    public void test2(){
        User user = new User("user");
        Windows windows = new Windows("windows");
        Computer computer = new Computer("computer", false);

        user.addWindows(windows);
        windows.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.peripheralDeviceDiscovery.assertCompromisedInstantaneously();

    }
}
