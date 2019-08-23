import org.junit.Test;

import core.*;
import attack.*;

public class automatedExfiltrationTest{

   
    public void test1(){
        Computer computer = new Computer("computer");

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.dataCollected);
        attacker.addAttackPoint(computer.dataCompressed);
        attacker.addAttackPoint(computer.dataEncrypted);

        attacker.attack();


        computer._automatedExfiltration.assertCompromisedInstantaneously();

    }
}
