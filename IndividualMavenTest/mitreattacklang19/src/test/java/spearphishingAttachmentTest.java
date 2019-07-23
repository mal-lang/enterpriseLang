import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class spearphishingAttachmentTest{

    @Test
    public void test1(){
        Employee employee = new Employee("employee", true);
        Browser browser = new Browser("browser", true, true);
        OS os = new OS("os", true);
        //User user = new user("user");
        Adversary adversary = new Adversary("adversary");

        employee.addBrowser(browser);
        browser.addOs(os);
        //os.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.spearphishingAttachmentAttack);
        attacker.attack();

        os.spearphishingAttachmentDownload.assertUncompromised();
    }
    public void test2(){
        Employee employee = new Employee("employee", false);
        Browser browser = new Browser("browser", true, true);
        OS os = new OS("os", true);
        //User user = new user("user");
        Adversary adversary = new Adversary("adversary");

        employee.addBrowser(browser);
        browser.addOs(os);
        //os.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.spearphishingAttachmentAttack);
        attacker.attack();

        os.spearphishingAttachmentDownload.assertUncompromised();
    }
    public void test3(){
        Employee employee = new Employee("employee", false);
        Browser browser = new Browser("browser", false, false);
        OS os = new OS("os", true);
        //User user = new user("user");
        Adversary adversary = new Adversary("adversary");

        employee.addBrowser(browser);
        browser.addOs(os);
        //os.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.spearphishingAttachmentAttack);
        attacker.attack();

        os.spearphishingAttachmentDownload.assertCompromisedInstantaneously();
    }
}