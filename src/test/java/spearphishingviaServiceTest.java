import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;



public class spearphishingviaServiceTest{


  @Test 
  public void testNoDefens() {
    Adversary adversary = new Adversary("adversary");
    User user = new User("user");
    PrivateComputer computer = new PrivateComputer("computer");
    Employee employee = new Employee("employee");

    adversary.addEmployee(employee);
    employee.addPrivateComputer(computer);
    employee.addUser(user);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.spearphishingViaService);
    attacker.attack();
    
    user.stolenCredentials.assertCompromisedInstantaneously();
    computer.infectedComputer.assertCompromisedInstantaneously();
  }

  @Test 
  public void testWithRestrictSiteAndPrograms() {
    Adversary adversary = new Adversary("adversary");
    User user = new User("user");
    PrivateComputer computer = new PrivateComputer("computer");
    Employee employee = new Employee("employee",false,true);

    adversary.addEmployee(employee);
    employee.addPrivateComputer(computer);
    employee.addUser(user);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(adversary.spearphishingViaService);
    attacker.attack();
    
    user.stolenCredentials.assertUncompromised();
    computer.infectedComputer.assertUncompromised();
  }
  
}