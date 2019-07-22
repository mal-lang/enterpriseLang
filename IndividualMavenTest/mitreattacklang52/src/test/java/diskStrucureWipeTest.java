import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class diskStructureWipe{

    @Test
    public void test1(){
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer", true, true);

        administrator.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        computer.diskStructureWipe.assertUncompromised();

    }
    @Test
    public void test2(){
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer", false, false);

        administrator.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        computer.diskStructureWipe.assertCompromisedInstantaneously();

    }
}
