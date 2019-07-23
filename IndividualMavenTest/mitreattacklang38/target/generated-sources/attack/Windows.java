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
public class Windows extends Asset {
   public java.util.Set<Administrator> administrator = new HashSet<>();

   public ScheduledTask scheduledTask;
   public Whitelisting whitelisting;

   public Windows(Boolean whitelistingState) {
      super();
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(scheduledTask);
      scheduledTask = new ScheduledTask(this.name);
      assetClassName = "Windows";
   }

   public Windows(String name, Boolean whitelistingState) {
      super(name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(scheduledTask);
      scheduledTask = new ScheduledTask(this.name);
      assetClassName = "Windows";
   }

   public Windows() {
      this(false);
      assetClassName = "Windows";
   }

   public Windows(String name) {
      this(name, false);
      assetClassName = "Windows";
   }


   public class ScheduledTask extends AttackStepMax {
   public ScheduledTask(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (Administrator administrator_shpdg : administrator) {
addExpectedParent(administrator_shpdg.adminRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.scheduledTask");
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
            return "windows.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
scheduledTask.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addAdministrator(Administrator administrator) {
         this.administrator.add(administrator);
         administrator.windows = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("administrator")) {
         for (Object o: administrator) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("administrator")  && administrator != null) {
         assets.addAll(administrator);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(administrator);
      return assets;
   }
}
