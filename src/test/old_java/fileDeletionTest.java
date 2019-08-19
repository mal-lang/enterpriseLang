import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class fileDeletionTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Computer computer = new Computer("computer", true);

        // Section 2: Asset connections and attacker creation
        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        computer.bypassHostForensicAnalysisDetection.assertUncompromised();
     

    }
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Computer computer = new Computer("computer", false);

        // Section 2: Asset connections and attacker creation
        user.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        computer.bypassHostForensicAnalysisDetection.assertCompromisedInstantaneously();
     

    }
}
