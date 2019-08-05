import org.junit.Test;

import core.*;
import attack.*;

public class windowsAdminSharesTest {
  @Test
  public void test1(){
      WindowsAdmin admin = new WindowsAdmin("admin");
      Computer computer = new Computer("computer", true);

      admin.addComputer(computer);

      Attacker attacker = new Attacker();
      attacker.addAttackPoint(admin.adminRights);
      attacker.attack();

      computer.windowsAdminShares.assertUncompromised();

  }
  @Test
  public void test2(){
    
      WindowsAdmin admin = new WindowsAdmin("admin");
      Computer computer = new Computer("computer");

      admin.addComputer(computer);

      Attacker attacker = new Attacker();
      attacker.addAttackPoint(admin.adminRights);
      attacker.attack();

      computer.windowsAdminShares.assertCompromisedInstantaneously();

  }
  
}