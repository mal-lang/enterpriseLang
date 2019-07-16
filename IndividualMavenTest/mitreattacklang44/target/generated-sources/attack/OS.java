package attack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertTrue;

import core.Asset;
import core.AttackStep;
import core.AttackStepMax;
import core.AttackStepMin;
import core.Defense;
public class OS extends Asset {
   public java.util.Set<User> user = new HashSet<>();
   public java.util.Set<Employee> employee = new HashSet<>();

   public Scripting scripting;
   public _scripting _scripting;
   public RestricedScripting restricedScripting;
   public Sandboxing sandboxing;

   public OS(Boolean restricedScriptingState, Boolean sandboxingState) {
      super();
      if (restricedScripting != null) {
         AttackStep.allAttackSteps.remove(restricedScripting.disable);
      }
      Defense.allDefenses.remove(restricedScripting);
      restricedScripting = new RestricedScripting(this.name, restricedScriptingState);
      if (sandboxing != null) {
         AttackStep.allAttackSteps.remove(sandboxing.disable);
      }
      Defense.allDefenses.remove(sandboxing);
      sandboxing = new Sandboxing(this.name, sandboxingState);
      AttackStep.allAttackSteps.remove(scripting);
      scripting = new Scripting(this.name);
      AttackStep.allAttackSteps.remove(_scripting);
      _scripting = new _scripting(this.name);
      assetClassName = "OS";
   }

   public OS(String name, Boolean restricedScriptingState, Boolean sandboxingState) {
      super(name);
      if (restricedScripting != null) {
         AttackStep.allAttackSteps.remove(restricedScripting.disable);
      }
      Defense.allDefenses.remove(restricedScripting);
      restricedScripting = new RestricedScripting(this.name, restricedScriptingState);
      if (sandboxing != null) {
         AttackStep.allAttackSteps.remove(sandboxing.disable);
      }
      Defense.allDefenses.remove(sandboxing);
      sandboxing = new Sandboxing(this.name, sandboxingState);
      AttackStep.allAttackSteps.remove(scripting);
      scripting = new Scripting(this.name);
      AttackStep.allAttackSteps.remove(_scripting);
      _scripting = new _scripting(this.name);
      assetClassName = "OS";
   }

   public OS() {
      this(false, false);
      assetClassName = "OS";
   }

   public OS(String name) {
      this(name, false, false);
      assetClassName = "OS";
   }


   public class Scripting extends AttackStepMin {
   public Scripting(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
for (User user_rJAqz : user) {
addExpectedParent(user_rJAqz.userRights);
}
for (Employee employee_UvUoo : employee) {
addExpectedParent(employee_UvUoo.userExecution);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_scripting.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.scripting");
      }

   }

   public class _scripting extends AttackStepMax {
   public _scripting(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(scripting);
addExpectedParent(restricedScripting.disable);
addExpectedParent(sandboxing.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS._scripting");
      }

   }

   public class RestricedScripting extends Defense {
   public RestricedScripting(String name, Boolean enabled) {
      super(name);
      defaultValue = enabled;
      disable = new Disable(name);
   }

   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "oS.restricedScripting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_scripting.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class Sandboxing extends Defense {
   public Sandboxing(String name, Boolean enabled) {
      super(name);
      defaultValue = enabled;
      disable = new Disable(name);
   }

   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "oS.sandboxing";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_scripting.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user.add(user);
         user.os = this;
      }

      public void addEmployee(Employee employee) {
         this.employee.add(employee);
         employee.os.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("employee")) {
         for (Object o: employee) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
         return assets;
      }
      if (roleName.equals("employee")  && employee != null) {
         assets.addAll(employee);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(user);
      assets.addAll(employee);
      return assets;
   }
}
