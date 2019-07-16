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
public class Root extends Asset {
   public MacOS macOS;

   public RootRights rootRights;

   public Root() {
      super();
      AttackStep.allAttackSteps.remove(rootRights);
      rootRights = new RootRights(this.name);
      assetClassName = "Root";
   }

   public Root(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(rootRights);
      rootRights = new RootRights(this.name);
      assetClassName = "Root";
   }


   public class RootRights extends AttackStepMin {
   public RootRights(String name) {
      super(name);
      assetClassName = "Root";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (macOS != null) {
macOS.adminSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Root.rootRights");
      }

   }

      public void addMacOS(MacOS macOS) {
         this.macOS = macOS;
         macOS.root.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("macOS")) {
         return macOS.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("macOS")  && macOS != null) {
         assets.add(macOS);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (macOS != null) {
         assets.add(macOS);
      }
      return assets;
   }
}
