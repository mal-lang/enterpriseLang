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
public class MacOS extends Asset {
   public java.util.Set<User> user = new HashSet<>();

   public SpaceAfterFileName spaceAfterFileName;
   public FileMonitoring fileMonitoring;

   public MacOS(Boolean fileMonitoringState) {
      super();
      if (fileMonitoring != null) {
         AttackStep.allAttackSteps.remove(fileMonitoring.disable);
      }
      Defense.allDefenses.remove(fileMonitoring);
      fileMonitoring = new FileMonitoring(this.name, fileMonitoringState);
      AttackStep.allAttackSteps.remove(spaceAfterFileName);
      spaceAfterFileName = new SpaceAfterFileName(this.name);
      assetClassName = "MacOS";
   }

   public MacOS(String name, Boolean fileMonitoringState) {
      super(name);
      if (fileMonitoring != null) {
         AttackStep.allAttackSteps.remove(fileMonitoring.disable);
      }
      Defense.allDefenses.remove(fileMonitoring);
      fileMonitoring = new FileMonitoring(this.name, fileMonitoringState);
      AttackStep.allAttackSteps.remove(spaceAfterFileName);
      spaceAfterFileName = new SpaceAfterFileName(this.name);
      assetClassName = "MacOS";
   }

   public MacOS() {
      this(false);
      assetClassName = "MacOS";
   }

   public MacOS(String name) {
      this(name, false);
      assetClassName = "MacOS";
   }


   public class SpaceAfterFileName extends AttackStepMax {
   public SpaceAfterFileName(String name) {
      super(name);
      assetClassName = "MacOS";
   }
@Override
public void setExpectedParents() {
for (User user_wuNIS : user) {
addExpectedParent(user_wuNIS.userRights);
}
addExpectedParent(fileMonitoring.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("MacOS.spaceAfterFileName");
      }

   }

   public class FileMonitoring extends Defense {
   public FileMonitoring(String name, Boolean enabled) {
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
            return "macOS.fileMonitoring";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
spaceAfterFileName.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user.add(user);
         user.macOS = this;
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
