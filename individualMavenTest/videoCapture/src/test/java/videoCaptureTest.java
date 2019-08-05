import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class videoCaptureTest{

    @Test
    public void test1(){
        User user = new User("user");
        Windows windows = new Windows("windows");
        MacOS macOS = new MacOS("macOS");
        VideoCallApplication videoCallApplication = new VideoCallApplication("videoCallApplication");
        Computer computer = new Computer("computer", true);
        Webcam webcam = new Webcam("webcam");

        user.addWindows(windows);
        user.addMacOS(macOS);
        computer.addWindows(windows);
        computer.addMacOS(macOS);
        videoCallApplication.addComputer(computer);
        webcam.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.dataCollected.assertUncompromised();

    }
    public void test2(){
        User user = new User("user");
        Windows windows = new Windows("windows");
        MacOS macOS = new MacOS("macOS");
        VideoCallApplication videoCallApplication = new VideoCallApplication("videoCallApplication");
        Computer computer = new Computer("computer", false);
     

        user.addWindows(windows);
        user.addMacOS(macOS);
        computer.addWindows(windows);
        computer.addMacOS(macOS);
        videoCallApplication.addComputer(computer);
 

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.dataCollected.assertCompromisedInstantaneously();
    }
    public void test3(){
        User user = new User("user");
        Windows windows = new Windows("windows");
        MacOS macOS = new MacOS("macOS");
        Computer computer = new Computer("computer", true);
        Webcam webcam = new Webcam("webcam");

        user.addWindows(windows);
        user.addMacOS(macOS);
        computer.addWindows(windows);
        computer.addMacOS(macOS);
        webcam.addComputer(computer);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        computer.dataCollected.assertCompromisedInstantaneously();
    }
}
