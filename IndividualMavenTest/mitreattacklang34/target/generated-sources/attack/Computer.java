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
public class Computer extends Asset {
   public java.util.Set<Administrator> administrator = new HashSet<>();
   public InternalNetwork internalNetwork;

   public NetworkServiceScan networkServiceScan;

   public Computer() {
      super();
      AttackStep.allAttackSteps.remove(networkServiceScan);
      networkServiceScan = new NetworkServiceScan(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(networkServiceScan);
      networkServiceScan = new NetworkServiceScan(this.name);
      assetClassName = "Computer";
   }


   public class NetworkServiceScan extends AttackStepMax {
   public NetworkServiceScan(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (Administrator administrator_jaUBk : administrator) {
addExpectedParent(administrator_jaUBk.adminRights);
}
if (internalNetwork != null) {
addExpectedParent(internalNetwork.networkIntrusionDetection.disable);
}
if (internalNetwork != null) {
addExpectedParent(internalNetwork.whitelisting.disable);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.networkServiceScan");
      }

   }

      public void addAdministrator(Administrator administrator) {
         this.administrator.add(administrator);
         administrator.computer = this;
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.computer.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("administrator")) {
         for (Object o: administrator) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
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
      assets.addAll(administrator);
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
