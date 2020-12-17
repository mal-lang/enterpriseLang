import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class spearphishingLinkTest{

  
  @Test
  public void testNoDefens() {
    Employee employee = new Employee("employee");
    Browser browser = new Browser("browser");
    OS os = new OS("os");
    User user = new User("user");
    Computer computer = new Computer("computer");

    employee.addBrowser(browser);
    browser.addOs(os);
    browser.addUser(user);
    computer.addOs(os);
    employee.addOs(os);
    employee.addUser(user);
    employee.addComputer(computer);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(employee.spearphishingLinkClicked);
    attacker.attack();

    // Section 3: Assertions
    user.userCredentials.assertCompromisedInstantaneously();
    computer.infectedComputer.assertCompromisedInstantaneously();
  }

  @Test
  public void testAllDefenses() {
    Employee employee = new Employee("employee",true,false);
    Browser browser = new Browser("browser",false,false,false,false,true);
    OS os = new OS("os",false,false,true);
    User user = new User("user");
    Computer computer = new Computer("computer");

    employee.addBrowser(browser);
    browser.addOs(os);
    browser.addUser(user);
    computer.addOs(os);
    employee.addOs(os);
    employee.addUser(user);
    employee.addComputer(computer);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(employee.spearphishingLinkClicked);
    attacker.attack();

    // Section 3: Assertions
    user.userCredentials.assertUncompromised();
    computer.infectedComputer.assertUncompromised();
  }

  @Test
  public void testWithAntivirus() {
    Employee employee = new Employee("employee");
    Browser browser = new Browser("browser");
    OS os = new OS("os",false,false,true);
    User user = new User("user");
    Computer computer = new Computer("computer");

    employee.addBrowser(browser);
    browser.addOs(os);
    browser.addUser(user);
    computer.addOs(os);
    employee.addOs(os);
    employee.addUser(user);
    employee.addComputer(computer);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(employee.spearphishingLinkClicked);
    attacker.attack();

    // Section 3: Assertions
    user.userCredentials.assertCompromisedInstantaneously();
    computer.infectedComputer.assertUncompromised();
  }

  @Test
  public void testWithPhishingDetection() {
    Employee employee = new Employee("employee");
    Browser browser = new Browser("browser",false,false,false,false,true);
    OS os = new OS("os");
    User user = new User("user");
    Computer computer = new Computer("computer");

    employee.addBrowser(browser);
    browser.addOs(os);
    browser.addUser(user);
    computer.addOs(os);
    employee.addOs(os);
    employee.addUser(user);
    employee.addComputer(computer);

    // Attack  
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(employee.spearphishingLinkClicked);
    attacker.attack();

    // Section 3: Assertions
    user.userCredentials.assertUncompromised();
    computer.infectedComputer.assertUncompromised();
  }
  
  
}