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
   public java.util.Set<Computer> computer = new HashSet<>();

   public UncommonlyUsedPortsLimitation uncommonlyUsedPortsLimitation;
   public BypassFirewall bypassFirewall;

   public Firewall(Boolean uncommonlyUsedPortsLimitationState) {
      super();
      if (uncommonlyUsedPortsLimitation != null) {
         AttackStep.allAttackSteps.remove(uncommonlyUsedPortsLimitation.disable);
      }
      Defense.allDefenses.remove(uncommonlyUsedPortsLimitation);
      uncommonlyUsedPortsLimitation = new UncommonlyUsedPortsLimitation(this.name, uncommonlyUsedPortsLimitationState);
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      assetClassName = "Firewall";
   }

   public Firewall(String name, Boolean uncommonlyUsedPortsLimitationState) {
      super(name);
      if (uncommonlyUsedPortsLimitation != null) {
         AttackStep.allAttackSteps.remove(uncommonlyUsedPortsLimitation.disable);
      }
      Defense.allDefenses.remove(uncommonlyUsedPortsLimitation);
      uncommonlyUsedPortsLimitation = new UncommonlyUsedPortsLimitation(this.name, uncommonlyUsedPortsLimitationState);
      AttackStep.allAttackSteps.remove(bypassFirewall);
      bypassFirewall = new BypassFirewall(this.name);
      assetClassName = "Firewall";
   }

   public Firewall() {
      this(false);
      assetClassName = "Firewall";
   }

   public Firewall(String name) {
      this(name, false);
      assetClassName = "Firewall";
   }


   public class UncommonlyUsedPortsLimitation extends Defense {
   public UncommonlyUsedPortsLimitation(String name, Boolean enabled) {
      super(name);
      defaultValue = enabled;
      disable = new Disable(name);
   }

   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "firewall.uncommonlyUsedPortsLimitation";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_EJTub : computer) {
computer_EJTub.uncommonlyUsedPortsConnection.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

   public class BypassFirewall extends AttackStepMin {
   public BypassFirewall(String name) {
      super(name);
      assetClassName = "Firewall";
   }
@Override
public void setExpectedParents() {
for (Computer computer_RRKqi : computer) {
addExpectedParent(computer_RRKqi.uncommonlyUsedPortsConnection);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Firewall.bypassFirewall");
      }

   }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.firewall = this;
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
