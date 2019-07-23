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
public class InternalNetwork extends Asset {
   public java.util.Set<Windows> windows = new HashSet<>();
   public java.util.Set<MacOS> macOS = new HashSet<>();

   public NetworkShareDiscovery networkShareDiscovery;

   public InternalNetwork() {
      super();
      AttackStep.allAttackSteps.remove(networkShareDiscovery);
      networkShareDiscovery = new NetworkShareDiscovery(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(networkShareDiscovery);
      networkShareDiscovery = new NetworkShareDiscovery(this.name);
      assetClassName = "InternalNetwork";
   }


   public class NetworkShareDiscovery extends AttackStepMin {
   public NetworkShareDiscovery(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (MacOS macOS_plTKJ : macOS) {
addExpectedParent(macOS_plTKJ.networkShareDiscovery);
}
for (Windows windows_xYBLc : windows) {
addExpectedParent(windows_xYBLc.networkShareDiscovery);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.networkShareDiscovery");
      }

   }

      public void addWindows(Windows windows) {
         this.windows.add(windows);
         windows.internalNetwork = this;
      }

      public void addMacOS(MacOS macOS) {
         this.macOS.add(macOS);
         macOS.internalNetwork = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("windows")) {
         for (Object o: windows) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("macOS")) {
         for (Object o: macOS) {
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
      if (roleName.equals("macOS")  && macOS != null) {
         assets.addAll(macOS);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(windows);
      assets.addAll(macOS);
      return assets;
   }
}
