import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataDestructionTest{

    @Test
    public void test1(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer", true, true);

        user.addComputer(computer);
        administrator.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.userDataDestruction.assertUncompromised();
    }
    
    public void test2(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer", false, false);

        user.addComputer(computer);
        administrator.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        computer.userDataDestruction.assertCompromisedInstantaneously();
    }
    public void test3(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer", false, false);

        user.addComputer(computer);
        administrator.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        computer.adminDataDestruction.assertCompromisedInstantaneously();
    }

}