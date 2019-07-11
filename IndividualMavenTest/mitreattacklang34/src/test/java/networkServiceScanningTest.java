import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class networkServiceScanningTest{

    @Test
    public void test1(){
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true, true);

        administrator.addComputer(computer);
        internalNetwork.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        computer.networkServiceScan.assertUncompromised();

    }
    public void test2(){
        Administrator administrator = new Administrator("administrator");
        Computer computer = new Computer("computer");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false, false);

        administrator.addComputer(computer);
        internalNetwork.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();


        computer.networkServiceScan.assertCompromisedInstantaneously();

    }
}
