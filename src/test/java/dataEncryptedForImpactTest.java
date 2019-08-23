import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class dataEncryptedForImpactTest{

    @Test
    public void test1(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os",false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false);

        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        os.userDataEncryptedForImpact.assertUncompromised();
        os.adminDataEncryptedForImpact.assertUncompromised();

    }
    @Test
    public void test2(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os");

        user.addOs(os);
        administrator.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        os.userDataEncryptedForImpact.assertCompromisedInstantaneously();
        os.adminDataEncryptedForImpact.assertCompromisedInstantaneously();


    }
}
