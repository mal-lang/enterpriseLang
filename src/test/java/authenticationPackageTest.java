import org.junit.Test;

import core.*;
import attack.*;

public class authenticationPackageTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        Administrator admin = new Administrator("admin");
        Windows windows = new Windows("windows",false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false);

        // Section 2: Asset connections and attacker creation
        admin.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(admin.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertUncompromisedFrom(windows.authenticationPackage);

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        Administrator admin = new Administrator("admin");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        admin.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(admin.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneouslyFrom(windows.authenticationPackage);
        
    }
}