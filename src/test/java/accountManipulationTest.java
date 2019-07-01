import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class accountManipulationTest {

  @Test
  public void test1AdminWith1User() {
    User user = new User("user");
    WindowsAdmin windowsAdmin = new WindowsAdmin("windowsAdmin");

    windowsAdmin.addUser(user);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(windowsAdmin.adminRights);
    attacker.attack();

    windowsAdmin.accountManipulation.assertCompromisedInstantaneously();
    user.stolenCredentials.assertCompromisedInstantaneously();
    user.adminLogin.assertCompromisedInstantaneously();
  }

  @Test
  public void test1AdminWith3UsersAnd1NotConnectedUser() {
    User user1 = new User("user1");
    User user2 = new User("user2");
    User user3 = new User("user3");
    User user4 = new User("user4");
    WindowsAdmin windowsAdmin = new WindowsAdmin("windowsAdmin");


    windowsAdmin.addUser(user1); 
    windowsAdmin.addUser(user2); 
    windowsAdmin.addUser(user3); 

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user1.stolenCredentials);
    attacker.attack();

    windowsAdmin.accountManipulation.assertCompromisedInstantaneously();
    user2.stolenCredentials.assertCompromisedInstantaneously(); 
    user3.stolenCredentials.assertCompromisedInstantaneously();
    user4.stolenCredentials.assertUncompromised();
  }

  @Test
  public void test1AdminWith4Users() {
    User user1 = new User("user1");
    User user2 = new User("user2");
    User user3 = new User("user3");
    User user4 = new User("user4");
    WindowsAdmin windowsAdmin = new WindowsAdmin("windowsAdmin");


    windowsAdmin.addUser(user1); 
    windowsAdmin.addUser(user2); 
    windowsAdmin.addUser(user3); 
    windowsAdmin.addUser(user4);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user1.stolenCredentials);
    attacker.attack();

    windowsAdmin.accountManipulation.assertCompromisedInstantaneously();
    user2.stolenCredentials.assertCompromisedInstantaneously(); 
    user3.stolenCredentials.assertCompromisedInstantaneously();
    user4.stolenCredentials.assertCompromisedInstantaneously();
  }

  @Test
  public void test1AdminWith4UsersAndDefens() {
    User user1 = new User("user1");
    User user2 = new User("user2");
    User user3 = new User("user3");
    User user4 = new User("user4");
    WindowsAdmin windowsAdmin = new WindowsAdmin("windowsAdmin",true);


    windowsAdmin.addUser(user1); 
    windowsAdmin.addUser(user2); 
    windowsAdmin.addUser(user3); 
    windowsAdmin.addUser(user4);

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(user1.stolenCredentials);
    attacker.attack();

    user2.stolenCredentials.assertUncompromised(); 
    user3.stolenCredentials.assertUncompromised();
    user4.stolenCredentials.assertUncompromised();
  }
}