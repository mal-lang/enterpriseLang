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
   public DetailedRunningProcessDiscovery detailedRunningProcessDiscovery;
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
      AttackStep.allAttackSteps.remove(detailedRunningProcessDiscovery);
      detailedRunningProcessDiscovery = new DetailedRunningProcessDiscovery(this.name);
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
      AttackStep.allAttackSteps.remove(detailedRunningProcessDiscovery);
      detailedRunningProcessDiscovery = new DetailedRunningProcessDiscovery(this.name);
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
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.runningProcessDiscovery");
      }

   }

   public class DetailedRunningProcessDiscovery extends AttackStepMax {
   public DetailedRunningProcessDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.detailedRunningProcessDiscovery");
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
runningProcessDiscovery.updateTtc(this, ttc, activeAttackSteps);
detailedRunningProcessDiscovery.updateTtc(this, ttc, activeAttackSteps);
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
