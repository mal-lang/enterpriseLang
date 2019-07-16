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
   public java.util.Set<Computer> computer = new HashSet<>();

   public BypassFirewall bypassFirewall;
   public BypassNetworkDetection bypassNetworkDetection;

   public ExternalNetwork() {
      super();
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      assetClassName = "ExternalNetwork";
   }

   public ExternalNetwork(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      assetClassName = "ExternalNetwork";
   }


   public class BypassFirewall extends AttackStepMin {
   public BypassFirewall(String name) {
      super(name);
      assetClassName = "ExternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Computer computer_CoUxI : computer) {
addExpectedParent(computer_CoUxI.commonlyUsedPortsConnection);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("ExternalNetwork.bypassFirewall");
      }

   }

   public class BypassNetworkDetection extends AttackStepMin {
   public BypassNetworkDetection(String name) {
      super(name);
      assetClassName = "ExternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Computer computer_OWrsD : computer) {
addExpectedParent(computer_OWrsD.commonlyUsedPortsConnection);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("ExternalNetwork.bypassNetworkDetection");
      }

   }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.externalNetwork.add(this);
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
