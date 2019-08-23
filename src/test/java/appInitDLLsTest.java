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
    Windows win = new Windows("win",true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);//whiteList in win is the defens

    admin.addWindows(win);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(admin.adminRights);
    attacker.attack();

    win.persistence.assertUncompromisedFrom(win.appInitDLLs);
  }

  @Test 
  public void appInitDLLsTestWithSecureBootDefens() {
    Administrator admin = new Administrator("admin");
    Windows win = new Windows("win",false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);//secureBoot in win is the defens

    admin.addWindows(win);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(admin.adminRights);
    attacker.attack();

    win.persistence.assertUncompromisedFrom(win.appInitDLLs);
  }
  
  @Test 
  public void appInitDLLsTestWithBothDefens() {
    Administrator admin = new Administrator("admin");
    Windows win = new Windows("win",true,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false);//secureBoot and whiteList in win is the defens

    admin.addWindows(win);
    

    Attacker attacker = new Attacker();
    attacker.addAttackPoint(admin.adminRights);
    attacker.attack();

    win.persistence.assertUncompromisedFrom(win.appInitDLLs);
  }
}