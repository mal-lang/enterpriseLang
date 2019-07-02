import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class fileAndDirectoryDiscoveryTest{

    @Test
    public void test1(){
        User user = new User("user");
        Computer computer = new Computer("computer", true);

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(user.userRights);
        attacker.attack();

        computer.fileDiscovery.assertUncompromised();
        computer.directoryDiscovery.assertUncompromised();
    }
    public void test2(){
        User user = new User("user");
        Computer computer = new Computer("computer", false);

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(user.userRights);
        attacker.attack();

        computer.fileDiscovery.assertCompromisedInstantaneously();
        computer.directoryDiscovery.assertCompromisedInstantaneously();
    }
}
