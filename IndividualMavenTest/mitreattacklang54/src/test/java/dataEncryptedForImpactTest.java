import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataEncryptedForImpactTest{

    @Test
    public void test1(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator")
        Computer computer = new Computer("computer", true);

        user.addComputer(computer);
        administrator.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.userDataEncryptedForImpact.assertUncompromised();
        computer.adminDataEncryptedForImpact.assertUncompromised();

    }
    @Test
    public void test2(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator")
        Computer computer = new Computer("computer", false);

        user.addComputer(computer);
        administrator.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.userDataEncryptedForImpact.assertCompromisedInstantaneously();
        computer.adminDataEncryptedForImpact.assertCompromisedInstantaneously();


    }
}
