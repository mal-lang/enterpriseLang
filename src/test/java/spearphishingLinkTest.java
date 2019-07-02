import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class spearphishingLinkTest{

    @Test
    public void test1(){
        Employee employee = new Employee("employee", true);
        Adversary adversary = new Adversary("adversary");
        Browser browser = new Browser("browser", true);
        OS os = new OS("os", true);

        employee.addBrowser(browser);
        adversary.addEmployee(employee);
        adversary.addBrowser(browser);
        browser.addOs(os);
        
        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.spearphishingLinkAttack);
        attacker.attack();

        os.spearphishingLinkDownload.assertUncompromised();
    }

    public void test2(){
        Employee employee = new Employee("employee", false);
        Adversary adversary = new Adversary("adversary");
        Browser browser = new Browser("browser", false);
        OS os = new OS("os", true);

        employee.addBrowser(browser);
        adversary.addEmployee(employee);
        adversary.addBrowser(browser);
        browser.addOs(os);
        
        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.spearphishingLinkAttack);
        attacker.attack();

        os.spearphishingLinkDownload.assertUncompromised();
    }
    public void test3(){
        Employee employee = new Employee("employee", false);
        Adversary adversary = new Adversary("adversary");
        Browser browser = new Browser("browser", false);
        OS os = new OS("os", false);

        employee.addBrowser(browser);
        adversary.addEmployee(employee);
        adversary.addBrowser(browser);
        browser.addOs(os);
        
        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.spearphishingLinkAttack);
        attacker.attack();

        os.spearphishingLinkDownload.assertCompromisedInstantaneously();
    }
}
