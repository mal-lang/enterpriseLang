import org.junit.Test;

import core.*;
import attack.*;

public class commandLineInterfaceTest{

  @Test
  public void testAnminUserCredential(){
    // Section 1: Asset instantiation
    OS os = new OS("os",true,false,false);
    User user = new User("user");
    Employee employee = new Employee("employee");
    Administrator administrator = new Administrator("administrator");
    Computer computer = new Computer("computer");

    // Section 2: Asset connections and attacker creation
    computer.addOs(os);
    user.addComputer(computer);
    user.addAdministrator(administrator);
    user.addEmployee(employee);
    administrator.addOs(os);
    
    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userCredentials);
    attacker.attack();

    // Section 3: Assertions
    administrator.adminRights.assertCompromisedInstantaneously();
  }

  @Test
  public void testNormanUserCredential() {
    OS os = new OS("os",true,false,false);
    User user = new User("user",true);
    Employee employee = new Employee("employee");
    Administrator administrator = new Administrator("administrator");
    Computer computer = new Computer("computer");

    computer.addOs(os);
    user.addComputer(computer);
    user.addAdministrator(administrator);
    user.addEmployee(employee);
    employee.addUser(user);
    administrator.addOs(os);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user.userCredentials);
    attacker.attack();

    administrator.adminRights.assertUncompromised();
  }
}