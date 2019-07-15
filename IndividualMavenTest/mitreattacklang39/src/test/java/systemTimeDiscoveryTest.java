import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class systemTimeDiscoveryTest{

    @Test
    public void test1(){
        User user = new User("user");
        Windows windows = new Windows("windows", true);
        
        user.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        windows.systemTimeDiscovery.assertUncompromised();

    }
    public void test2(){
        User user = new User("user");
        Windows windows = new Windows("windows", false);
        
        user.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        windows.systemTimeDiscovery.assertCompromisedInstantaneously();
    }
}
