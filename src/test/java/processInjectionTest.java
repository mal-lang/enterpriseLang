import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class processInjectionTest{

    @Test
    public void test1(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os", false);
        
        user.addOs(os);
        os.addAdministrator(administrator);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.runningProcessDiscovery);
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        administrator.adminRights.assertCompromisedInstantaneously();
        os.bypassAntivirus.assertCompromisedInstantaneously();
        os.bypassWhitelisting.assertUncompromised.assertCompromisedInstantaneously();
    }
    public void test2(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        OS os = new OS("os", true);
        
        user.addOs(os);
        os.addAdministrator(administrator);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(os.runningProcessDiscovery);
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        administrator.adminRights.assertUncompromised();
        os.bypassAntivirus.assertUncompromised();
        os.bypassWhitelisting.assertUncompromised.assertUncompromised();
    }
    
}