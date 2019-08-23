import org.junit.Test;

import core.*;
import attack.*;

public class dataCompressedTest{

    @Test
    public void test1(){
        OS os = new OS("os");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork",false,false,false,false,true,false,false);

        internalNetwork.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.dataCollected);
        attacker.attack();

        os.compressData.assertUncompromised();

    }
    public void test2(){
        OS os = new OS("os");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");

        internalNetwork.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.dataCollected);
        attacker.attack();

        os.compressData.assertCompromisedInstantaneously();
        
    }
}