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
public class Service extends Asset {
   public java.util.Set<User> user = new HashSet<>();

   public ExploitationForDefenseEvasion exploitationForDefenseEvasion;
   public _exploitationForDefenseEvasion _exploitationForDefenseEvasion;
   public SoftwareUpdated softwareUpdated;
   public Sandboxing sandboxing;
   public BypassAntivirus bypassAntivirus;
   public BypassSystemAccessControls bypassSystemAccessControls;

   public Service(Boolean softwareUpdatedState, Boolean sandboxingState) {
      super();
      if (softwareUpdated != null) {
         AttackStep.allAttackSteps.remove(softwareUpdated.disable);
      }
      Defense.allDefenses.remove(softwareUpdated);
      softwareUpdated = new SoftwareUpdated(this.name, softwareUpdatedState);
      if (sandboxing != null) {
         AttackStep.allAttackSteps.remove(sandboxing.disable);
      }
      Defense.allDefenses.remove(sandboxing);
      sandboxing = new Sandboxing(this.name, sandboxingState);
      AttackStep.allAttackSteps.remove(exploitationForDefenseEvasion);
      exploitationForDefenseEvasion = new ExploitationForDefenseEvasion(this.name);
      AttackStep.allAttackSteps.remove(_exploitationForDefenseEvasion);
      _exploitationForDefenseEvasion = new _exploitationForDefenseEvasion(this.name);
      AttackStep.allAttackSteps.remove(bypassAntivirus);
      bypassAntivirus = new BypassAntivirus(this.name);
      AttackStep.allAttackSteps.remove(bypassSystemAccessControls);
      bypassSystemAccessControls = new BypassSystemAccessControls(this.name);
      assetClassName = "Service";
   }

   public Service(String name, Boolean softwareUpdatedState, Boolean sandboxingState) {
      super(name);
      if (softwareUpdated != null) {
         AttackStep.allAttackSteps.remove(softwareUpdated.disable);
      }
      Defense.allDefenses.remove(softwareUpdated);
      softwareUpdated = new SoftwareUpdated(this.name, softwareUpdatedState);
      if (sandboxing != null) {
         AttackStep.allAttackSteps.remove(sandboxing.disable);
      }
      Defense.allDefenses.remove(sandboxing);
      sandboxing = new Sandboxing(this.name, sandboxingState);
      AttackStep.allAttackSteps.remove(exploitationForDefenseEvasion);
      exploitationForDefenseEvasion = new ExploitationForDefenseEvasion(this.name);
      AttackStep.allAttackSteps.remove(_exploitationForDefenseEvasion);
      _exploitationForDefenseEvasion = new _exploitationForDefenseEvasion(this.name);
      AttackStep.allAttackSteps.remove(bypassAntivirus);
      bypassAntivirus = new BypassAntivirus(this.name);
      AttackStep.allAttackSteps.remove(bypassSystemAccessControls);
      bypassSystemAccessControls = new BypassSystemAccessControls(this.name);
      assetClassName = "Service";
   }

   public Service() {
      this(false, false);
      assetClassName = "Service";
   }

   public Service(String name) {
      this(name, false, false);
      assetClassName = "Service";
   }


   public class ExploitationForDefenseEvasion extends AttackStepMin {
   public ExploitationForDefenseEvasion(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
addExpectedParent(softwareUpdated.disable);
addExpectedParent(sandboxing.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_exploitationForDefenseEvasion.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service.exploitationForDefenseEvasion");
      }

   }

   public class _exploitationForDefenseEvasion extends AttackStepMax {
   public _exploitationForDefenseEvasion(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
for (User user_zGxjx : user) {
addExpectedParent(user_zGxjx.userRights);
}
addExpectedParent(exploitationForDefenseEvasion);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
bypassAntivirus.updateTtc(this, ttc, activeAttackSteps);
bypassSystemAccessControls.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service._exploitationForDefenseEvasion");
      }

   }

   public class SoftwareUpdated extends Defense {
   public SoftwareUpdated(String name, Boolean enabled) {
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
            return "service.softwareUpdated";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exploitationForDefenseEvasion.updateTtc(this, ttc, activeAttackSteps);
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
            return "service.sandboxing";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exploitationForDefenseEvasion.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class BypassAntivirus extends AttackStepMin {
   public BypassAntivirus(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
addExpectedParent(_exploitationForDefenseEvasion);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service.bypassAntivirus");
      }

   }

   public class BypassSystemAccessControls extends AttackStepMin {
   public BypassSystemAccessControls(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
addExpectedParent(_exploitationForDefenseEvasion);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service.bypassSystemAccessControls");
      }

   }

      public void addUser(User user) {
         this.user.add(user);
         user.service.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
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
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(user);
      return assets;
   }
}
