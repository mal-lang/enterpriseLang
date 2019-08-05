import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class permissionGroupsDiscoveryTest{

    @Test
    public void test1(){
        User user = new User("user");
        Computer computer = new Computer("computer", true);

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.permissionGroupsDiscovery.assertUncompromised();

    }
    public void test2(){
        User user = new User("user");
        Computer computer = new Computer("computer", false);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.permissionGroupsDiscovery.assertCompromisedInstantaneously();

    }
}
