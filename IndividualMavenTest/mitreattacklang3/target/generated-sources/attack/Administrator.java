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
public class Administrator extends Asset {
   public java.util.Set<Windows> windows = new HashSet<>();
   public java.util.Set<Linux> linux = new HashSet<>();

   public AdminRights adminRights;

   public Administrator() {
      super();
      AttackStep.allAttackSteps.remove(adminRights);
      adminRights = new AdminRights(this.name);
      assetClassName = "Administrator";
   }

   public Administrator(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(adminRights);
      adminRights = new AdminRights(this.name);
      assetClassName = "Administrator";
   }


   public class AdminRights extends AttackStepMin {
   public AdminRights(String name) {
      super(name);
      assetClassName = "Administrator";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Windows windows_ItsQo : windows) {
windows_ItsQo.bootkit.updateTtc(this, ttc, activeAttackSteps);
}
for (Linux linux_ArnWP : linux) {
linux_ArnWP.bootkit.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Administrator.adminRights");
      }

   }

      public void addWindows(Windows windows) {
         this.windows.add(windows);
         windows.windowsAdministrator = this;
      }

      public void addLinux(Linux linux) {
         this.linux.add(linux);
         linux.linuxAdministrator = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("windows")) {
         for (Object o: windows) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("linux")) {
         for (Object o: linux) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("windows")  && windows != null) {
         assets.addAll(windows);
         return assets;
      }
      if (roleName.equals("linux")  && linux != null) {
         assets.addAll(linux);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(windows);
      assets.addAll(linux);
      return assets;
   }
}
