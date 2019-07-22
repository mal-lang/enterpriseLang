import org.junit.Test;

import core.*;
import attack.*;

public class  browserExtensionsTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        Browser browser = new Browser("browser",true);
        OS os = new OS("os");

        // Section 2: Asset connections and attacker creation
        browser.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(browser.installExtensions);
        attacker.attack();

        // Section 3: Assertions
        os.persistence.assertUncompromised();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        Browser browser = new Browser("browser");
        OS os = new OS("os");

        // Section 2: Asset connections and attacker creation
        browser.addOs(os);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(browser.installExtensions);
        attacker.attack();

        // Section 3: Assertions
        os.persistence.assertCompromisedInstantaneously();
        
    }
}