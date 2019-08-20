import org.junit.Test;

import core.*;
import attack.*;

public class appCertDLLsTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        User user2 = new User("user2");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        user.addWindows(windows);
        user2.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneouslyFrom(windows.appCertDLLs);
        user2.userRights.assertCompromisedInstantaneously();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        Administrator administrator = new Administrator("administrator");
        Administrator administrator2 = new Administrator("administrator2");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        administrator.addWindows(windows);
        administrator2.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneouslyFrom(windows.appCertDLLs);
        administrator2.adminRights.assertCompromisedInstantaneously();
        
    }
    @Test
    public void test3(){
        // Section 1: Asset instantiation
        SYSTEM system = new SYSTEM("system");
        SYSTEM system2 = new SYSTEM("system2");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        system.addWindows(windows);
        system2.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(system.systemRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneouslyFrom(windows.appCertDLLs);
        system2.systemRights.assertCompromisedInstantaneously();
        
    }
    @Test
    public void test4(){
        // Section 1: Asset instantiation
        User user = new User("user");
        User user2 = new User("user2");
        Windows windows = new Windows("windows",true,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false);

        // Section 2: Asset connections and attacker creation
        user.addWindows(windows);
        user2.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        //windows.persistence.assertUncompromisedFrom(windows.appCertDLLs);
        user2.userRights.assertUncompromised();

    }
    @Test
    public void test5(){
        // Section 1: Asset instantiation
        Administrator administrator = new Administrator("administrator");
        Administrator administrator2 = new Administrator("administrator2");
        Windows windows = new Windows("windows",true,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false);

        // Section 2: Asset connections and attacker creation
        administrator.addWindows(windows);
        administrator2.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        //windows.persistence.assertUncompromisedFrom(windows.appCertDLLs);
        administrator2.adminRights.assertUncompromised();
        
    }
    @Test
    public void test6(){
        // Section 1: Asset instantiation
        SYSTEM system = new SYSTEM("system");
        SYSTEM system2 = new SYSTEM("system2");
        Windows windows = new Windows("windows",true,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false);

        // Section 2: Asset connections and attacker creation
        system.addWindows(windows);
        system2.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(system.systemRights);
        attacker.attack();

        // Section 3: Assertions
        //windows.persistence.assertUncompromisedFrom(windows.appCertDLLs);
        system2.systemRights.assertUncompromised();
        
    }
}