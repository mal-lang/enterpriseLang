import org.junit.Test;

import core.*;
import attack.*;

public class networkSniffingTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Adversary adversary = new Adversary("adversary");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork",true);

        // Section 2: Asset connections and attacker creation
        internalNetwork.addAdversary(adversary);
        internalNetwork.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.useNetworkSniffing);
        attacker.attack();

        // Section 3: Assertions
        internalNetwork.discovery.assertUncompromised();
        user.userCredentials.assertUncompromised();

    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user",true);
        Adversary adversary = new Adversary("adversary");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");

        // Section 2: Asset connections and attacker creation
        internalNetwork.addAdversary(adversary);
        internalNetwork.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.useNetworkSniffing);
        attacker.attack();

        // Section 3: Assertions
        internalNetwork.discovery.assertCompromisedInstantaneously();
        user.userCredentials.assertUncompromised();
        
    }
    @Test
    public void test3(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Adversary adversary = new Adversary("adversary");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");

        // Section 2: Asset connections and attacker creation
        internalNetwork.addAdversary(adversary);
        internalNetwork.addUser(user);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(adversary.useNetworkSniffing);
        attacker.attack();

        // Section 3: Assertions
        internalNetwork.discovery.assertCompromisedInstantaneously();
        user.userCredentials.assertCompromisedInstantaneously();
        
    }
}