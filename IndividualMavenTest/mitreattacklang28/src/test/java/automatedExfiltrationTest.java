import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class automatedExfiltrationTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer", true);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.addAttackerPoint(computer.dataEncrypted);

        attacker.attack();


        computer._automatedExfiltration.assertUncompromised();

    }
    public void test2(){
        Computer computer = new Computer("computer", false);

        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.addAttackerPoint(computer.dataEncrypted);

        attacker.attack();


        computer._automatedExfiltration.assertCompromisedInstantaneously();

    }
}
