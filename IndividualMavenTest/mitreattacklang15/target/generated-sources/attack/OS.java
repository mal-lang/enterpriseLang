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
   public User user;
   public Administrator administrator;

   public RunningProcessDiscovery runningProcessDiscovery;
   public ProcessInjection processInjection;
   public BypassAntivirus bypassAntivirus;
   public BypassWhitelisting bypassWhitelisting;
   public Whitelisting whitelisting;

   public OS(Boolean whitelistingState) {
      super();
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(runningProcessDiscovery);
      runningProcessDiscovery = new RunningProcessDiscovery(this.name);
      AttackStep.allAttackSteps.remove(processInjection);
      processInjection = new ProcessInjection(this.name);
      AttackStep.allAttackSteps.remove(bypassAntivirus);
      bypassAntivirus = new BypassAntivirus(this.name);
      AttackStep.allAttackSteps.remove(bypassWhitelisting);
      bypassWhitelisting = new BypassWhitelisting(this.name);
      assetClassName = "OS";
   }

   public OS(String name, Boolean whitelistingState) {
      super(name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(runningProcessDiscovery);
      runningProcessDiscovery = new RunningProcessDiscovery(this.name);
      AttackStep.allAttackSteps.remove(processInjection);
      processInjection = new ProcessInjection(this.name);
      AttackStep.allAttackSteps.remove(bypassAntivirus);
      bypassAntivirus = new BypassAntivirus(this.name);
      AttackStep.allAttackSteps.remove(bypassWhitelisting);
      bypassWhitelisting = new BypassWhitelisting(this.name);
      assetClassName = "OS";
   }

   public OS() {
      this(false);
      assetClassName = "OS";
   }

   public OS(String name) {
      this(name, false);
      assetClassName = "OS";
   }


   public class RunningProcessDiscovery extends AttackStepMax {
   public RunningProcessDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
processInjection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.runningProcessDiscovery");
      }

   }

   public class ProcessInjection extends AttackStepMax {
   public ProcessInjection(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(runningProcessDiscovery);
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (administrator != null) {
administrator.adminRights.updateTtc(this, ttc, activeAttackSteps);
}
bypassAntivirus.updateTtc(this, ttc, activeAttackSteps);
bypassWhitelisting.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.processInjection");
      }

   }

   public class BypassAntivirus extends AttackStepMin {
   public BypassAntivirus(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(processInjection);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.bypassAntivirus");
      }

   }

   public class BypassWhitelisting extends AttackStepMin {
   public BypassWhitelisting(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(processInjection);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.bypassWhitelisting");
      }

   }

   public class Whitelisting extends Defense {
   public Whitelisting(String name, Boolean enabled) {
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
            return "oS.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
processInjection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user = user;
         user.os.add(this);
      }

      public void addAdministrator(Administrator administrator) {
         this.administrator = administrator;
         administrator.os.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         return user.getClass().getName();
      }
      if (roleName.equals("administrator")) {
         return administrator.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("user")  && user != null) {
         assets.add(user);
         return assets;
      }
      if (roleName.equals("administrator")  && administrator != null) {
         assets.add(administrator);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (user != null) {
         assets.add(user);
      }
      if (administrator != null) {
         assets.add(administrator);
      }
      return assets;
   }
}
