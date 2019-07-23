import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class driveByCompromiseTest{

    @Test
    public void test1(){
        Employee employee = new Employee("employee");
        Adversary adversary = new Adversary("adversary");
        Computer computer = new Computer("computer");
        Browser browser = new Browser("browser", true, true, true);
        OS os = new OS("os", true);

        

        employee.addBrowser(browser);
        adversary.addBrowser(browser);
        adversary.addEmployee(employee);
        //adversary.addOs(os);
        browser.addOs(os);
        os.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.maliciousWebsite);
        attacker.addAttackPoint(adversary.maliciousAds);
        attacker.attack();

        // Section 3: Assertions
        computer.infectedComputer.assertUncompromised();
    }
    public void test2(){
        Employee employee = new Employee("employee");
        Adversary adversary = new Adversary("adversary");
        Computer computer = new Computer("computer");
        Browser browser = new Browser("browser", false, false, true);
        OS os = new OS("os", false);

        

        employee.addBrowser(browser);
        adversary.addBrowser(browser);
        adversary.addEmployee(employee);
        //adversary.addOs(os);
        browser.addOs(os);
        os.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.maliciousWebsite);
        attacker.addAttackPoint(adversary.maliciousAds);
        attacker.attack();

        // Section 3: Assertions
        computer.infectedComputer.assertCompromisedInstantaneously();
    }
    public void test3(){
        Employee employee = new Employee("employee");
        Adversary adversary = new Adversary("adversary");
        Computer computer = new Computer("computer");
        Browser browser = new Browser("browser", true, true, false);
        OS os = new OS("os", false);

        

        employee.addBrowser(browser);
        adversary.addBrowser(browser);
        adversary.addEmployee(employee);
        //adversary.addOs(os);
        browser.addOs(os);
        os.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.maliciousWebsite);
        attacker.addAttackPoint(adversary.maliciousAds);
        attacker.attack();

        // Section 3: Assertions
        computer.infectedComputer.assertCompromisedInstantaneously();
    }
    public void test4(){
        Employee employee = new Employee("employee");
        Adversary adversary = new Adversary("adversary");
        Computer computer = new Computer("computer");
        Browser browser = new Browser("browser", true, false, true);
        OS os = new OS("os", false);

        

        employee.addBrowser(browser);
        adversary.addBrowser(browser);
        adversary.addEmployee(employee);
        //adversary.addOs(os);
        browser.addOs(os);
        os.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.maliciousWebsite);
        attacker.addAttackPoint(adversary.maliciousAds);
        attacker.attack();

        // Section 3: Assertions
        computer.infectedComputer.assertUncompromised();
    }
}