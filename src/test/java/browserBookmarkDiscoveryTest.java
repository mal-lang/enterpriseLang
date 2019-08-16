import org.junit.Test;

import core.*;
import attack.*;

public class  browserBookmarkDiscoveryTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        Browser browser = new Browser("browser");
        User user = new User("user");
        InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");

        // Section 2: Asset connections and attacker creation
        browser.addUser(user);
        browser.addInternalNetwork(internalNetwork);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(browser.browserBookmark);
        attacker.attack();

        // Section 3: Assertions
        user.userInformation.assertCompromisedInstantaneously();
        internalNetwork.internalNetworkResourcesInformation.assertCompromisedInstantaneously();

    }
    
}