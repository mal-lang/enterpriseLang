import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class scheduledTransferTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        
        Attacker attacker = new Attacker();
        attacker.addAttackerPoint(computer.dataCollected);
        attacker.addAttackerPoint(computer.dataCompressed);
        attacker.addAttackerPoint(computer.dataEncrypted);

        attacker.attack();


        computer.scheduledExfiltration.assertUncompromised();

    }

}
