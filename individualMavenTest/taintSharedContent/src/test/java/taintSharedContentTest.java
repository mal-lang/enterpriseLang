import org.junit.Test;

import core.*;
import attack.*;

public class taintSharedContentTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Windows windows = new Windows("Windows",true);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
        NetworkSharedDrive networkSharedDrive = new NetworkSharedDrive("networkSharedDrive");

        // Section 2: Asset connections and attacker creation
        user.addWindows(windows);
        windows.addInternalNetwork(internalNetwork);
        internalNetwork.addNetworkSharedDrive(networkSharedDrive);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        networkSharedDrive.data.assertUncompromised();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Windows windows = new Windows("Windows");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
        NetworkSharedDrive networkSharedDrive = new NetworkSharedDrive("networkSharedDrive");

        // Section 2: Asset connections and attacker creation
        user.addWindows(windows);
        windows.addInternalNetwork(internalNetwork);
        internalNetwork.addNetworkSharedDrive(networkSharedDrive);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        networkSharedDrive.data.assertCompromisedInstantaneously();
        
    }
}