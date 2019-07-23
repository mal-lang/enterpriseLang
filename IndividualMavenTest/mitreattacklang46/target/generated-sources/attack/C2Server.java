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
public class C2Server extends ExternalNetwork {
   public java.util.Set<Computer> computer = new HashSet<>();

   public C2Connexion c2Connexion;

   public C2Server() {
      super();
      AttackStep.allAttackSteps.remove(c2Connexion);
      c2Connexion = new C2Connexion(this.name);
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      assetClassName = "C2Server";
   }

   public C2Server(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(c2Connexion);
      c2Connexion = new C2Connexion(this.name);
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      assetClassName = "C2Server";
   }


   public class C2Connexion extends AttackStepMin {
   public C2Connexion(String name) {
      super(name);
      assetClassName = "C2Server";
   }
@Override
public void setExpectedParents() {
for (Computer computer_IrfAB : computer) {
addExpectedParent(computer_IrfAB.commonlyUsedPortsConnection);
}
}
   }

   public class BypassFirewall extends ExternalNetwork.BypassFirewall {
   public BypassFirewall(String name) {
      super(name);
      assetClassName = "C2Server";
   }
   }

   public class BypassNetworkDetection extends ExternalNetwork.BypassNetworkDetection {
   public BypassNetworkDetection(String name) {
      super(name);
      assetClassName = "C2Server";
   }
   }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.c2Server.add(this);
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
      assets.addAll(computer);
      return assets;
   }
}
