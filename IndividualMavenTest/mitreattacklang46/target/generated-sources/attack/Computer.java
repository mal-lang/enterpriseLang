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
   public java.util.Set<ExternalNetwork> externalNetwork = new HashSet<>();
   public java.util.Set<InternalNetwork> internalNetwork = new HashSet<>();
   public java.util.Set<C2Server> c2Server = new HashSet<>();

   public InfectedComputer infectedComputer;
   public CommonlyUsedPortsConnection commonlyUsedPortsConnection;
   public NetworkIntrusionDetection networkIntrusionDetection;

   public Computer(Boolean networkIntrusionDetectionState) {
      super();
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      AttackStep.allAttackSteps.remove(infectedComputer);
      infectedComputer = new InfectedComputer(this.name);
      AttackStep.allAttackSteps.remove(commonlyUsedPortsConnection);
      commonlyUsedPortsConnection = new CommonlyUsedPortsConnection(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name, Boolean networkIntrusionDetectionState) {
      super(name);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      AttackStep.allAttackSteps.remove(infectedComputer);
      infectedComputer = new InfectedComputer(this.name);
      AttackStep.allAttackSteps.remove(commonlyUsedPortsConnection);
      commonlyUsedPortsConnection = new CommonlyUsedPortsConnection(this.name);
      assetClassName = "Computer";
   }

   public Computer() {
      this(false);
      assetClassName = "Computer";
   }

   public Computer(String name) {
      this(name, false);
      assetClassName = "Computer";
   }


   public class InfectedComputer extends AttackStepMin {
   public InfectedComputer(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
commonlyUsedPortsConnection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.infectedComputer");
      }

   }

   public class CommonlyUsedPortsConnection extends AttackStepMax {
   public CommonlyUsedPortsConnection(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(infectedComputer);
addExpectedParent(networkIntrusionDetection.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (C2Server c2Server_NMKxL : c2Server) {
c2Server_NMKxL.c2Connexion.updateTtc(this, ttc, activeAttackSteps);
}
for (ExternalNetwork externalNetwork_PxsDg : externalNetwork) {
externalNetwork_PxsDg.bypassFirewall.updateTtc(this, ttc, activeAttackSteps);
}
for (InternalNetwork internalNetwork_UXZvN : internalNetwork) {
internalNetwork_UXZvN.bypassFirewall.updateTtc(this, ttc, activeAttackSteps);
}
for (ExternalNetwork externalNetwork_UmaFn : externalNetwork) {
externalNetwork_UmaFn.bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
}
for (InternalNetwork internalNetwork_MCxcf : internalNetwork) {
internalNetwork_MCxcf.bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.commonlyUsedPortsConnection");
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
            return "computer.networkIntrusionDetection";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
commonlyUsedPortsConnection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addExternalNetwork(ExternalNetwork externalNetwork) {
         this.externalNetwork.add(externalNetwork);
         externalNetwork.computer.add(this);
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork.add(internalNetwork);
         internalNetwork.computer.add(this);
      }

      public void addC2Server(C2Server c2Server) {
         this.c2Server.add(c2Server);
         c2Server.computer.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("externalNetwork")) {
         for (Object o: externalNetwork) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("internalNetwork")) {
         for (Object o: internalNetwork) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("c2Server")) {
         for (Object o: c2Server) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("externalNetwork")  && externalNetwork != null) {
         assets.addAll(externalNetwork);
         return assets;
      }
      if (roleName.equals("internalNetwork")  && internalNetwork != null) {
         assets.addAll(internalNetwork);
         return assets;
      }
      if (roleName.equals("c2Server")  && c2Server != null) {
         assets.addAll(c2Server);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(externalNetwork);
      assets.addAll(internalNetwork);
      assets.addAll(c2Server);
      return assets;
   }
}
