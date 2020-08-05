import org.junit.Test;

import core.*;
import attack.*;

public class applicationShimmingTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        Administrator administrator2 = new Administrator("administrator2");
        Windows windows = new Windows("windows" ,false,false,true,true,false   
                                                ,false,false,false,false,false
                                                ,false,false,false,false,false
                                                ,false,false,false,false,false
                                                ,false,false,false);

        // Section 2: Asset connections and attacker creation
        user.addWindows(windows);
        administrator.addWindows(windows);
        administrator2.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertUncompromisedFrom(windows._applicationShimming);
        user.userRights.assertUncompromisedFrom(windows._applicationShimming);

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        Administrator administrator2 = new Administrator("administrator2");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        user.addWindows(windows);
        administrator.addWindows(windows);
        administrator2.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(administrator.adminRights);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneously();
        user.userRights.assertCompromisedInstantaneously();
        
    }
}