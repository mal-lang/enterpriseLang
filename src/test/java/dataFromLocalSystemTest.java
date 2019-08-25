import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataFromLocalSystemTest{

    @Test
    public void test1(){
        OS os = new OS("os");


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.userCommandLineInterface);
        attacker.attack();


        os.dataCollected.assertCompromisedInstantaneously();

    }
    @Test
    public void test2(){
        OS os = new OS("os");


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.adminCommandLineInterface);
        attacker.attack();


        os.dataCollected.assertCompromisedInstantaneously();

    }
}
