import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class remoteAccessToolsTest{

    @Test
    public void test1(){
        User user = new User("user");
        Service service = new Service("service", true);
        C2Server c2Server = new C2Server("c2Server");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true);
        Firewall firewall = new Firewall("firewall");

        user.addService(service);
        service.addInternalNetwork(internalNetwork);
        internalNetwork.addC2Server(c2Server);
        firewall.addInternalNetwork(internalNetwork);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        c2Server.c2Connected.assertUncompromised();

    }
    public void test2(){
        User user = new User("user");
        Service service = new Service("service", false);
        C2Server c2Server = new C2Server("c2Server");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false);
        Firewall firewall = new Firewall("firewall");

        user.addService(service);
        service.addInternalNetwork(internalNetwork);
        internalNetwork.addC2Server(c2Server);
        firewall.addInternalNetwork(internalNetwork);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        c2Server.c2Connected.assertUncompromised();

    }
    public void test3(){
        User user = new User("user");
        Service service = new Service("service", false);
        C2Server c2Server = new C2Server("c2Server");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false);
      

        user.addService(service);
        service.addInternalNetwork(internalNetwork);
        internalNetwork.addC2Server(c2Server);
      

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();


        c2Server.c2Connected.assertCompromisedInstantaneously();

    }
}
