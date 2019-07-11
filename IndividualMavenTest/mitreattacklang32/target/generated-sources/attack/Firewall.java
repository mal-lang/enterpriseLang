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
public class Firewall extends Asset {
   public InternalNetwork internalNetwork;

   public BypassFirewall bypassFirewall;

   public Firewall() {
      super();
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      assetClassName = "Firewall";
   }

   public Firewall(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      assetClassName = "Firewall";
   }


   public class BypassFirewall extends AttackStepMax {
   public BypassFirewall(String name) {
      super(name);
      assetClassName = "Firewall";
   }
@Override
public void setExpectedParents() {
if (internalNetwork != null) {
addExpectedParent(internalNetwork.firewallExists.disable);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (internalNetwork != null) {
internalNetwork.c2Connexion.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Firewall.bypassFirewall");
      }

   }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.firewall = this;
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
