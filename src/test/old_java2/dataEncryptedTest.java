import org.junit.Test;

import core.*;
import attack.*;

public class dataEncryptedTest{

    @Test
    public void test1(){
        OS os = new OS("os");

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.dataCollected);
        attacker.addAttackPoint(os.dataCompressed);
        attacker.attack();


        os._dataEncrypted.assertCompromisedInstantaneously();

    }
}
