import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class uncommonlyUsedPortsTest{

    @Test
    public void test1(){
        Computer computer = new Computer("computer");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
        C2Server c2Server = new C2Server("c2Server");
        Firewall firewall = new Firewall("firewall", true);

        computer.addFirewall(firewall);
        internalNetwork.addComputer(computer);
        c2Server.addComputer(computer);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.infectedComputer);
        attacker.attack();


        c2Server.c2Connexion.assertUncompromised();
        firewall.bypassFirewall.assertUncompromised();
        internalNetwork.bypassProxies.assertUncompromised();

    }
    @Test
    public void test2(){
        Computer computer = new Computer("computer");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
        C2Server c2Server = new C2Server("c2Server");
        Firewall firewall = new Firewall("firewall", false);

        computer.addFirewall(firewall);
        internalNetwork.addComputer(computer);
        c2Server.addComputer(computer);


        Attacker attacker = new Attacker();
        attacker.addAttackPoint(computer.infectedComputer);
        attacker.attack();


        c2Server.c2Connexion.assertCompromisedInstantaneously();
        firewall.bypassFirewall.assertCompromisedInstantaneously();
        internalNetwork.bypassProxies.assertCompromisedInstantaneously();

    }
}
