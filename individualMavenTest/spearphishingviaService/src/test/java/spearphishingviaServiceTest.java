import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;



public class spearphishingviaServiceTest{


  @Test 
  public void testNoDefens() {
    Adversary adversary = new Adversary("adversary");
    User user = new User("user");
    Computer computer = new Computer("computer");
    Employee employee = new Employee("employee");

    adversary.addEmployee(employee);
    employee.addComputer(computer);
    employee.addUser(user);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.spearphishingViaService);
    attacker.attack();
    
    user.userCredentials.assertCompromisedInstantaneously();
    computer.infectedComputer.assertCompromisedInstantaneously();
  }

  @Test 
  public void testWithRestrictSiteAndPrograms() {
    Adversary adversary = new Adversary("adversary");
    User user = new User("user");
    Computer computer = new Computer("computer");
    Employee employee = new Employee("employee",true);

    adversary.addEmployee(employee);
    employee.addComputer(computer);
    employee.addUser(user);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.spearphishingViaService);
    attacker.attack();
    
    user.userCredentials.assertUncompromised();
    computer.infectedComputer.assertUncompromised();
  }
  
}