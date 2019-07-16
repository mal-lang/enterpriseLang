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
   public java.util.Set<C2Server> c2Server = new HashSet<>();
   public java.util.Set<ExternalNetwork> externalNetwork = new HashSet<>();

   public ApplicationLayerConnexion applicationLayerConnexion;
   public BypassNetworkDetection bypassNetworkDetection;
   public NetworkIntrusionDetection networkIntrusionDetection;

   public InternalNetwork(Boolean networkIntrusionDetectionState) {
      super();
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      AttackStep.allAttackSteps.remove(applicationLayerConnexion);
      applicationLayerConnexion = new ApplicationLayerConnexion(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name, Boolean networkIntrusionDetectionState) {
      super(name);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      AttackStep.allAttackSteps.remove(applicationLayerConnexion);
      applicationLayerConnexion = new ApplicationLayerConnexion(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
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


   public class ApplicationLayerConnexion extends AttackStepMax {
   public ApplicationLayerConnexion(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
addExpectedParent(networkIntrusionDetection.disable);
for (Computer computer_VKkyl : computer) {
addExpectedParent(computer_VKkyl.infectedComputer);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (C2Server c2Server_VHLKZ : c2Server) {
c2Server_VHLKZ.c2Connexion.updateTtc(this, ttc, activeAttackSteps);
}
bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
for (ExternalNetwork externalNetwork_QpObX : externalNetwork) {
externalNetwork_QpObX.bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.applicationLayerConnexion");
      }

   }

   public class BypassNetworkDetection extends AttackStepMin {
   public BypassNetworkDetection(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
addExpectedParent(applicationLayerConnexion);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.bypassNetworkDetection");
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
applicationLayerConnexion.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.internalNetwork = this;
      }

      public void addC2Server(C2Server c2Server) {
         this.c2Server.add(c2Server);
         c2Server.internalNetwork = this;
      }

      public void addExternalNetwork(ExternalNetwork externalNetwork) {
         this.externalNetwork.add(externalNetwork);
         externalNetwork.internalNetwork = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("c2Server")) {
         for (Object o: c2Server) {
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
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      if (roleName.equals("c2Server")  && c2Server != null) {
         assets.addAll(c2Server);
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
      assets.addAll(computer);
      assets.addAll(c2Server);
      assets.addAll(externalNetwork);
      return assets;
   }
}
