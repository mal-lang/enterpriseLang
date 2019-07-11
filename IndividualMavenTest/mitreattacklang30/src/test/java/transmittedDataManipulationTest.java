import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class transmittedDataManipulationTest{

    @Test
    public void test1(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        Service service = new Service("service", true, true);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", true, true);

        user.addInternalNetwork(internalNetwork);
        user.addService(service);
        administrator.addInternalNetwork(internalNetwork);
        administrator.addService(service);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(admin.adminRights);
        attacker.attack();


        service.usertransmittedDataManipulation.assertUncompromised();
        internalNetwork.admintransmittedDataManipulation.assertUncompromised();
    }
    public void test2(){
        User user = new User("user");
        Administrator administrator = new Administrator("administrator");
        Service service = new Service("service", true, false);
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork", false, true);

        user.addInternalNetwork(internalNetwork);
        user.addService(service);
        administrator.addInternalNetwork(internalNetwork);
        administrator.addService(service);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.addAttackPoint(admin.adminRights);
        attacker.attack();


        service.usertransmittedDataManipulation.assertCompromisedInstantaneously();
        internalNetwork.admintransmittedDataManipulation.assertCompromisedInstantaneously();


    }
}
