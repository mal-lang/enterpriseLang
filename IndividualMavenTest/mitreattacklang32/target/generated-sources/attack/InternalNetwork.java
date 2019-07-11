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
   public java.util.Set<Service> service = new HashSet<>();
   public Firewall firewall;
   public C2Server c2Server;

   public C2Connexion c2Connexion;
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
      AttackStep.allAttackSteps.remove(c2Connexion);
      c2Connexion = new C2Connexion(this.name);
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
      AttackStep.allAttackSteps.remove(c2Connexion);
      c2Connexion = new C2Connexion(this.name);
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


   public class C2Connexion extends AttackStepMax {
   public C2Connexion(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Service service_KKRuW : service) {
addExpectedParent(service_KKRuW.remoteAccessTools);
}
addExpectedParent(networkIntrusionDetection.disable);
if (firewall != null) {
addExpectedParent(firewall.bypassFirewall);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (c2Server != null) {
c2Server.c2Connected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.c2Connexion");
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
c2Connexion.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addService(Service service) {
         this.service.add(service);
         service.internalNetwork = this;
      }

      public void addFirewall(Firewall firewall) {
         this.firewall = firewall;
         firewall.internalNetwork = this;
      }

      public void addC2Server(C2Server c2Server) {
         this.c2Server = c2Server;
         c2Server.internalNetwork = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("service")) {
         for (Object o: service) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("firewall")) {
         return firewall.getClass().getName();
      }
      if (roleName.equals("c2Server")) {
         return c2Server.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("service")  && service != null) {
         assets.addAll(service);
         return assets;
      }
      if (roleName.equals("firewall")  && firewall != null) {
         assets.add(firewall);
         return assets;
      }
      if (roleName.equals("c2Server")  && c2Server != null) {
         assets.add(c2Server);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(service);
      if (firewall != null) {
         assets.add(firewall);
      }
      if (c2Server != null) {
         assets.add(c2Server);
      }
      return assets;
   }
}
