import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class spaceAfterFilenameTest{

    @Test
    public void test1(){
        User user = new User("user");
        Linux linux = new Linux("linux", true);

        user.addLinux(linux);
        
        administrator.addComputer(computer);
        internalNetwork.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        linux.spaceAfterFileName.assertUncompromised();

    }
    @Test
    public void test2(){
        User user = new User("user");
        MacOS macOS = new MacOS("macOS", true);

        user.addMacOS(macOS);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        macOS.spaceAfterFileName.assertUncompromised();

    }
    @Test
    public void test3(){
        User user = new User("user");
        MacOS macOS = new MacOS("macOS", false);

        user.addMacOS(macOS);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        macOS.spaceAfterFileName.assertCompromisedInstantaneously();

    }
}
