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

   public BypassFirewall bypassFirewall;
   public BypassNetworkDetection bypassNetworkDetection;

   public InternalNetwork() {
      super();
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      assetClassName = "InternalNetwork";
   }


   public class BypassFirewall extends AttackStepMin {
   public BypassFirewall(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Computer computer_cWchk : computer) {
addExpectedParent(computer_cWchk.commonlyUsedPortsConnection);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.bypassFirewall");
      }

   }

   public class BypassNetworkDetection extends AttackStepMin {
   public BypassNetworkDetection(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Computer computer_Xcmpo : computer) {
addExpectedParent(computer_Xcmpo.commonlyUsedPortsConnection);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.bypassNetworkDetection");
      }

   }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.internalNetwork.add(this);
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
