import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataFromLocalSystemTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        OS os = new OS("os");

        os.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.userCommandLineInterface);
        attacker.attack();


        computer.dataCollected.assertCompromisedInstantaneously();

    }
    @Test
    public void test2(){
        Computer computer = new Computer("computer");
        OS os = new OS("os");

        os.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.adminCommandLineInterface);
        attacker.attack();


        computer.dataCollected.assertCompromisedInstantaneously();

    }
}
