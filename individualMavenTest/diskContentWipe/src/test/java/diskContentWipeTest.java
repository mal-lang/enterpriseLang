import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class diskContentWipeTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer", true);
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");

        user.addComputer(computer);
        administrator.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        computer.userDiskWiped.assertUncompromised();
        computer.adminDiskWiped.assertUncompromised();


    }
    @Test
    public void test2(){
        Computer computer = new Computer("computer");
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");

        user.addComputer(computer);
        administrator.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        computer.userDiskWiped.assertCompromisedInstantaneously();
        computer.adminDiskWiped.assertCompromisedInstantaneously();

    }
}
