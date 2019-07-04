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
   public Firewall firewall;
   public java.util.Set<Computer> computer = new HashSet<>();
   public java.util.Set<ExternalNetwork> externalNetwork = new HashSet<>();

   public DataExfiltration dataExfiltration;
   public FirewallExists firewallExists;
   public NetworkIntrusionDetection networkIntrusionDetection;

   public InternalNetwork(Boolean networkIntrusionDetectionState) {
      super();
      if (firewallExists != null) {
         AttackStep.allAttackSteps.remove(firewallExists.disable);
      }
      Defense.allDefenses.remove(firewallExists);
      firewallExists = new FirewallExists(this.name);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      AttackStep.allAttackSteps.remove(dataExfiltration);
      dataExfiltration = new DataExfiltration(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name, Boolean networkIntrusionDetectionState) {
      super(name);
      if (firewallExists != null) {
         AttackStep.allAttackSteps.remove(firewallExists.disable);
      }
      Defense.allDefenses.remove(firewallExists);
      firewallExists = new FirewallExists(this.name);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      AttackStep.allAttackSteps.remove(dataExfiltration);
      dataExfiltration = new DataExfiltration(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork() {
      this(false);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name) {
      this(name, false);
      assetClassName = "InternalNetwork";
   }


   public class DataExfiltration extends AttackStepMax {
   public DataExfiltration(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Computer computer_egxxB : computer) {
addExpectedParent(computer_egxxB.exfiltrationOverAternativeProtocol);
}
if (firewall != null) {
addExpectedParent(firewall.bypassFirewall);
}
addExpectedParent(networkIntrusionDetection.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (ExternalNetwork externalNetwork_wsydH : externalNetwork) {
externalNetwork_wsydH.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.dataExfiltration");
      }

   }

   public class FirewallExists extends Defense {
   public FirewallExists(String name) {
      super(name);
      disable = new Disable(name);
   }

   @Override
   public boolean isEnabled() {
      return firewall == null;
   }
   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "internalNetwork.firewallExists";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (firewall != null) {
firewall.bypassFirewall.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

   public class NetworkIntrusionDetection extends Defense {
   public NetworkIntrusionDetection(String name, Boolean enabled) {
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
            return "internalNetwork.networkIntrusionDetection";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataExfiltration.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addFirewall(Firewall firewall) {
         this.firewall = firewall;
         firewall.internalNetwork = this;
      }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.internalNetwork = this;
      }

      public void addExternalNetwork(ExternalNetwork externalNetwork) {
         this.externalNetwork.add(externalNetwork);
         externalNetwork.internalNetwork = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("firewall")) {
         return firewall.getClass().getName();
      }
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("externalNetwork")) {
         for (Object o: externalNetwork) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("firewall")  && firewall != null) {
         assets.add(firewall);
         return assets;
      }
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      if (roleName.equals("externalNetwork")  && externalNetwork != null) {
         assets.addAll(externalNetwork);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (firewall != null) {
         assets.add(firewall);
      }
      assets.addAll(computer);
      assets.addAll(externalNetwork);
      return assets;
   }
}
