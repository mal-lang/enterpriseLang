import java.beans.Transient;

import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class automatedCollectionTest{

    @Test
    public void test1(){
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer", true);
        User user = new User("user");

        administrator.addComputer(computer);
        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.dataCollected.assertUncompromised();
        computer.sensitiveDataCollected.assertUncompromised();


    }
    @Test
    public void test2(){
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer", false);
        User user = new User("user");

        administrator.addComputer(computer);
        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.dataCollected.assertCompromisedInstantaneously();
        computer.sensitiveDataCollected.assertUncompromised();

    }
    @Test 
    public void test3(){
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer", false);
        User user = new User("user");

        administrator.addComputer(computer);
        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        computer.dataCollected.assertCompromisedInstantaneously();
        computer.sensitiveDataCollected.assertCompromisedInstantaneously();
    }
}
