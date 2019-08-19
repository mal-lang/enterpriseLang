import org.junit.Test;

import core.*;
import attack.*;

public class windowsManagementInstrumentationEventSubscriptionTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        Windows windows = new Windows("windows", true);

        // Section 2: Asset connections and attacker creation

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(windows.eventHapens);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertUncompromised();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(windows.eventHapens);
        attacker.attack();

        // Section 3: Assertions
        windows.persistence.assertCompromisedInstantaneously();
        
    }
}