import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class securitySoftwareDiscoveryTest{

    @Test
    public void test1(){
        User user = new User("user");
        Windows windows = new Windows("windows", true);
        
        user.addWindows(windows);
        
        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        windows.userSecuritySoftwareDiscovery.assertUncompromised();

    }
    @Test
    public void test2(){
        User user = new User("user");
        Windows windows = new Windows("windows", false);
        
        user.addWindows(windows);
        
        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        windows.userSecuritySoftwareDiscovery.assertCompromisedInstantaneously();


    }
    @Test
    public void test3(){
        User user = new User("user");
        MacOS macOS = new MacOS("macOS", false);
        Root root = new Root("root");

        root.addMacOS(macOS);
        user.addMacOS(macOS);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(root.rootRights);

        attacker.attack();


        macOS.userSecuritySoftwareDiscovery.assertCompromisedInstantaneously();
        macOS.adminSecuritySoftwareDiscovery.assertCompromisedInstantaneously();

    }
    @Test
    public void test4(){
        User user = new User("user");
        MacOS macOS = new MacOS("macOS", true);
        Root root = new Root("root");

        root.addMacOS(macOS);
        user.addMacOS(macOS);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(root.rootRights);

        attacker.attack();


        macOS.userSecuritySoftwareDiscovery.assertUncompromised();
        macOS.adminSecuritySoftwareDiscovery.assertUncompromised();

    }
}
