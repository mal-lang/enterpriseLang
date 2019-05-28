import org.junit.Test;

import core.*;
import attack.*;

public class commandLineInterfaceTest{

  @Test
  public void test1(){
    // Section 1: Asset instantiation
    OS os = new OS("os",true,false);
    User user = new User("user",false);
    Employee employee = new Employee("employee",false);
    Administrator administrator = new Administrator("administrator");
    Computer computer = new Computer("computer");

    // Section 2: Asset connections and attacker creation
    computer.addOs(os);
    user.addComputer(computer);
    user.addAdministrator(administrator);
    user.addEmployee(employee);
    administrator.addOs(os);
    
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userCredential);
    attacker.attack();

    // Section 3: Assertions
    administrator.adminRights.assertCompromisedInstantaneously();
  }

  @Test
  public void test2() {
    OS os = new OS("os",true,false);
    User user = new User("user",true);
    Employee employee = new Employee("employee",true);
    Administrator administrator = new Administrator("administrator");
    Computer computer = new Computer("computer");

    computer.addOs(os);
    user.addComputer(computer);
    user.addAdministrator(administrator);
    user.addEmployee(employee);
    employee.addUser(user);
    administrator.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userCredential);
    attacker.attack();

    administrator.adminRights.assertUncompromised();
  }
}