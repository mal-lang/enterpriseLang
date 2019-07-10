import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataEncryptedTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer", true);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.attack();


        computer._dataEncrypted.assertUncompromised();

    }
    public void test2(){
        Computer computer = new Computer("computer", false);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.attack();


        computer._dataEncrypted.assertCompromisedInstantaneously();

    }
}
