import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import core.*;
import attack.*;

public class appInitDLLsTest {
  
  @Test 
  public void appInitDLLsTestNoDefens() {
    Administrator admin = new Administrator("admin");
    Windows win = new Windows("win");

    admin.addWindows(win);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(admin.adminRights);
    attacker.attack();

    win.persistence.assertCompromisedInstantaneously();
  }

  @Test 
  public void appInitDLLsTestWithWhiteListDefens() {
    Administrator admin = new Administrator("admin");
    Windows win = new Windows("win",true,false);//whiteList in win is the defens

    admin.addWindows(win);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(admin.adminRights);
    attacker.attack();

    win.persistence.assertUncompromisedFrom(win.appInitDLLs);
  }

  @Test 
  public void appInitDLLsTestWithSecureBootDefens() {
    Administrator admin = new Administrator("admin");
    Windows win = new Windows("win",false,true);//secureBoot in win is the defens

    admin.addWindows(win);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(admin.adminRights);
    attacker.attack();

    win.persistence.assertUncompromisedFrom(win.appInitDLLs);
  }
  
  @Test 
  public void appInitDLLsTestWithBothDefens() {
    Administrator admin = new Administrator("admin");
    Windows win = new Windows("win",true,true);//secureBoot and whiteList in win is the defens

    admin.addWindows(win);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(admin.adminRights);
    attacker.attack();

    win.persistence.assertUncompromisedFrom(win.appInitDLLs);
  }
}