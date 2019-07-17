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
        microphone.addComputer(computer);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertUncompromised();

    }
    @Test
    public void test2(){
        User user = new User("user");
        Computer computer = new Computer("computer");
        Microphone microphone = new Microphone("microphone");

        user.addComputer(computer);
        microphone.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertCompromisedInstantaneously();

    }
    
    //@Test
    public void test3(){
        User user = new User("user");
        Computer computer = new Computer("computer");
   

        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertUncompromised();

    }
    //@Test // test on how E works
    public void test4(){
        User user = new User("user");
        Computer computer = new Computer("computer");
        Computer computer2 = new Computer("computer2");
        Microphone microphone = new Microphone("microphone");

   

        user.addComputer(computer);
        user.addComputer(computer2);
        microphone.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.dataCollected.assertCompromisedInstantaneously();
        computer2.dataCollected.assertUncompromised();

    }
}