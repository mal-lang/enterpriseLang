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
public class WindowsAdmin extends Asset {
   public java.util.Set<Windows> windows = new HashSet<>();

   public SystemRights systemRights;

   public WindowsAdmin() {
      super();
      AttackStep.allAttackSteps.remove(systemRights);
      systemRights = new SystemRights(this.name);
      assetClassName = "WindowsAdmin";
   }

   public WindowsAdmin(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(systemRights);
      systemRights = new SystemRights(this.name);
      assetClassName = "WindowsAdmin";
   }


   public class SystemRights extends AttackStepMin {
   public SystemRights(String name) {
      super(name);
      assetClassName = "WindowsAdmin";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Windows windows_RgFcV : windows) {
windows_RgFcV.executeService.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("WindowsAdmin.systemRights");
      }

   }

      public void addWindows(Windows windows) {
         this.windows.add(windows);
         windows.windowsAdministrator = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("windows")) {
         for (Object o: windows) {
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
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(windows);
      return assets;
   }
}
