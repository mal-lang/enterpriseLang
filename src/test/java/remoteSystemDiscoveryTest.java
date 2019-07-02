import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class remoteSystemDiscoveryTest{

    @Test
    public void test1(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os", true);

        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(user.userRights);
        attacker.attack();

        os.remoteSystemDiscovery.assertUncompromised();

    }
    public void test2(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os", false);

        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(user.userRights);
        attacker.attack();

        os.remoteSystemDiscovery.assertCompromisedInstantaneously();

    }
    public void test3(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os", false);

        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(administrator.adminRights);
        attacker.attack();

        os.detailedRemoteSystemDiscovery.assertCompromisedInstantaneously();

    }
}