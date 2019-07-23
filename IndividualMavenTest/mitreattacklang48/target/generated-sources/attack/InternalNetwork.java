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
   public java.util.Set<Computer> computer = new HashSet<>();

   public BypassProxies bypassProxies;

   public InternalNetwork() {
      super();
      AttackStep.allAttackSteps.remove(bypassProxies);
      bypassProxies = new BypassProxies(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(bypassProxies);
      bypassProxies = new BypassProxies(this.name);
      assetClassName = "InternalNetwork";
   }


   public class BypassProxies extends AttackStepMin {
   public BypassProxies(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Computer computer_WHwon : computer) {
addExpectedParent(computer_WHwon.uncommonlyUsedPortsConnection);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.bypassProxies");
      }

   }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.internalNetwork = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(computer);
      return assets;
   }
}
