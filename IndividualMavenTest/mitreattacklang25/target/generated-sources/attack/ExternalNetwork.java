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
public class ExternalNetwork extends Asset {
   public InternalNetwork internalNetwork;

   public DataExfiltrated dataExfiltrated;

   public ExternalNetwork() {
      super();
      AttackStep.allAttackSteps.remove(dataExfiltrated);
      dataExfiltrated = new DataExfiltrated(this.name);
      assetClassName = "ExternalNetwork";
   }

   public ExternalNetwork(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(dataExfiltrated);
      dataExfiltrated = new DataExfiltrated(this.name);
      assetClassName = "ExternalNetwork";
   }


   public class DataExfiltrated extends AttackStepMin {
   public DataExfiltrated(String name) {
      super(name);
      assetClassName = "ExternalNetwork";
   }
@Override
public void setExpectedParents() {
if (internalNetwork != null) {
addExpectedParent(internalNetwork.dataExfiltration);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("ExternalNetwork.dataExfiltrated");
      }

   }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.externalNetwork.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("internalNetwork")  && internalNetwork != null) {
         assets.add(internalNetwork);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
