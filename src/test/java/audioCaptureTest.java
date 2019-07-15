import org.junit.Test;

import core.*;
import attack.*;

public class audioCaptureTest{

    @Test
    public void test1(){
        User user = new User("user");
        Computer computer = new Computer("computer", true,false,false);
        Microphone microphone = new Microphone("microphone");

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertUncompromised();

    }

    public void test2(){
        User user = new User("user");
        Computer computer = new Computer("computer");
        Microphone microphone = new Microphone("microphone");

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertCompromisedInstantaneously();

    }
    public void test3(){
        User user = new User("user");
        Computer computer = new Computer("computer");
   

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertUncompromised();

    }
}