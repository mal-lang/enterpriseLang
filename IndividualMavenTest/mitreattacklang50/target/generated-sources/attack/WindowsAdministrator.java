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
public class WindowsAdministrator extends Asset {
   public Windows windows;

   public SystemRights systemRights;

   public WindowsAdministrator() {
      super();
      AttackStep.allAttackSteps.remove(systemRights);
      systemRights = new SystemRights(this.name);
      assetClassName = "WindowsAdministrator";
   }

   public WindowsAdministrator(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(systemRights);
      systemRights = new SystemRights(this.name);
      assetClassName = "WindowsAdministrator";
   }


   public class SystemRights extends AttackStepMin {
   public SystemRights(String name) {
      super(name);
      assetClassName = "WindowsAdministrator";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (windows != null) {
windows.adminSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("WindowsAdministrator.systemRights");
      }

   }

      public void addWindows(Windows windows) {
         this.windows = windows;
         windows.windowsAdministrator.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("windows")) {
         return windows.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("windows")  && windows != null) {
         assets.add(windows);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (windows != null) {
         assets.add(windows);
      }
      return assets;
   }
}
