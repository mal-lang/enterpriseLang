import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class audioCaptureTest{

    @Test
    public void test1(){
        User user = new User("user");
        Computer computer = new Computer("computer", true);
        Microphone microphone = new Microphone("microphone");

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertUncompromised();

    }
    @Test
    public void test2(){
        User user = new User("user");
        Computer computer = new Computer("computer", false);
        Microphone microphone = new Microphone("microphone");

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertCompromisedInstantaneously();

    }
    @Test
    public void test3(){
        User user = new User("user");
        Computer computer = new Computer("computer", false);
   

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertUncompromised();

    }
}