import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataCompressedTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer", true);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.dataCollected);
        attacker.attack();

        computer.compressData.assertUncompromised();

    }
    public void test2(){
        Computer computer = new Computer("computer", false);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.dataCollected);
        attacker.attack();

        computer.compressData.assertCompromisedInstantaneously();
        
    }
}