import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class scriptingTest{

    @Test
    public void test1(){
        User user = new User("user");
        Employee employee = new Employee("employee");
        OS os = new OS("os", true, true);

        user.addOS(os);
        employee.addOS(os);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(employee.userExecution);
        attacker.attack();


        os._scripting.assertUncompromised();

    }
    @Test
    public void test2(){
        User user = new User("user");
        Employee employee = new Employee("employee");
        OS os = new OS("os", false, false);

        user.addOS(os);
        employee.addOS(os);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(employee.userExecution);
        attacker.attack();


        os._scripting.assertCompromisedInstantaneously();
    }
}
