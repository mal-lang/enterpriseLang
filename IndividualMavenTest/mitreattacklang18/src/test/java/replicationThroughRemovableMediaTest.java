import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class replicationThroughRemovableMediaTest{

    @Test
    public void test1(){
        RemovableMedia removableMedia = new RemovableMedia("removableMedia");
        Employee employee = new Employee("employee", true);
        Computer infectedInitialComputer = new Computer("computer");
        Computer windowsComputer = new Computer("computer");
        User user = new User("user");


        removableMedia.addEmployee(employee);
        employee.addComputer(computer);
        employee.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(infectedInitialComputer.infectedComputer);
        attacker.attack();

        windowsComputer.infectedWindowsComputer.assertUncompromised();
        user.userRights.assertUncompromised();

    }
    public void test2(){
        RemovableMedia removableMedia = new RemovableMedia("removableMedia");
        Employee employee = new Employee("employee", false);
        Computer computer = new Computer("computer");
        User user = new User("user");

        removableMedia.addEmployee(employee);
        employee.addComputer(computer);
        employee.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(infectedInitialComputer.infectedComputer);
        attacker.attack();

        windowsComputer.infectedWindowsComputer.assertCompromisedInstantaneously();
        user.userRights.assertCompromisedInstantaneously();
        
    }
}