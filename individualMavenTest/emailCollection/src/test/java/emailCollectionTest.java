import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class emailCollectionTest{

    @Test
    public void test1(){
        User user = new User("user");
        Windows windows = new Windows("windows", true);
        Computer computer = new Computer("computer", true);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false, false);

        internalNetwork.addComputer(computer);
        computer.addWindows(windows);
        user.addWindows(windows);
        internalNetwork.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.dataCollected.assertUncompromised();

    }
    public void test2(){
        User user = new User("user");
        Windows windows = new Windows("windows", false);
        Computer computer = new Computer("computer", true);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true, true);

        internalNetwork.addComputer(computer);
        computer.addWindows(windows);
        user.addWindows(windows);
        internalNetwork.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.dataCollected.assertUncompromised();

    }
    public void test3(){
        User user = new User("user");
        Windows windows = new Windows("windows", false);
        Computer computer = new Computer("computer", false);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false, false);

        internalNetwork.addComputer(computer);
        computer.addWindows(windows);
        user.addWindows(windows);
        internalNetwork.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.dataCollected.assertCompromisedInstantaneously();

    }
}
