import org.junit.Test;

import core.*;
import attack.*;

public class automatedExfiltrationTest{

    
    @Test
    public void test1(){
        OS os = new OS("os");

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.dataCollected);
        attacker.addAttackPoint(os.dataCompressed);
        attacker.addAttackPoint(os.dataEncrypted);

        attacker.attack();


        os.automatedExfiltration.assertCompromisedInstantaneously();

    }
}
