import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class scheduledTransferTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        
        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.dataCollected);
        attacker.addAttackPoint(computer.dataCompressed);
        attacker.addAttackPoint(computer.dataEncrypted);

        attacker.attack();


        computer.scheduledExfiltration.assertCompromisedInstantaneously();

    }

}
