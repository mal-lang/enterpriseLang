import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class networkShareDiscoveryTest{

    @Test
    public void test1(){
        User user = new User("user");
        MacOS macOS = new MacOS("macOS", true);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true, true);

        user.addMacOS(macOS);
        internalNetwork.addMacOS(macOS);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        internalNetwork.networkShareDiscovery.assertUncompromised();

    }
    @Test
    public void test2(){
        Windows windows = new Windows("windows", true);
        User user = new User("user");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true, true);

        user.adsWindows(windows);
        internalNetwork.addWindows(windows);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        internalNetwork.networkShareDiscovery.assertUncompromised();


    }
    @Test
    public void test(){
        Windows windows = new Windows("windows", false);
        User user = new User("user");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true, true);

        user.adsWindows(windows);
        internalNetwork.addWindows(windows);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        internalNetwork.networkShareDiscovery.assertCompromisedInstantaneously();


    }
}
