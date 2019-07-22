import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class systemInfomationDiscoveryTest{

    @Test
    public void test1(){
        User user = new User("user");
        OS os = new OS("os", true);

        user.addOS(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        os.systemInformationDiscovery.assertUncompromised();

    }
    @Test
    public void test2(){
        User user = new User("user");
        OS os = new OS("os", false);

        user.addOS(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        os.systemInformationDiscovery..assertCompromisedInstantaneously();

    }
}
