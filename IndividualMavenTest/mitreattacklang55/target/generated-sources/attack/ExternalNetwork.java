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
   public C2Server c2Server;
   public java.util.Set<Computer> computer = new HashSet<>();
   public InternalNetwork internalNetwork;

   public IntrusionDetecion intrusionDetecion;
   public SignatureIdentification signatureIdentification;
   public BypassNetworkDetection bypassNetworkDetection;
   public DataExfiltrated dataExfiltrated;

   public ExternalNetwork(Boolean intrusionDetecionState, Boolean signatureIdentificationState) {
      super();
      if (intrusionDetecion != null) {
         AttackStep.allAttackSteps.remove(intrusionDetecion.disable);
      }
      Defense.allDefenses.remove(intrusionDetecion);
      intrusionDetecion = new IntrusionDetecion(this.name, intrusionDetecionState);
      if (signatureIdentification != null) {
         AttackStep.allAttackSteps.remove(signatureIdentification.disable);
      }
      Defense.allDefenses.remove(signatureIdentification);
      signatureIdentification = new SignatureIdentification(this.name, signatureIdentificationState);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      AttackStep.allAttackSteps.remove(dataExfiltrated);
      dataExfiltrated = new DataExfiltrated(this.name);
      assetClassName = "ExternalNetwork";
   }

   public ExternalNetwork(String name, Boolean intrusionDetecionState, Boolean signatureIdentificationState) {
      super(name);
      if (intrusionDetecion != null) {
         AttackStep.allAttackSteps.remove(intrusionDetecion.disable);
      }
      Defense.allDefenses.remove(intrusionDetecion);
      intrusionDetecion = new IntrusionDetecion(this.name, intrusionDetecionState);
      if (signatureIdentification != null) {
         AttackStep.allAttackSteps.remove(signatureIdentification.disable);
      }
      Defense.allDefenses.remove(signatureIdentification);
      signatureIdentification = new SignatureIdentification(this.name, signatureIdentificationState);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      AttackStep.allAttackSteps.remove(dataExfiltrated);
      dataExfiltrated = new DataExfiltrated(this.name);
      assetClassName = "ExternalNetwork";
   }

   public ExternalNetwork() {
      this(false, false);
      assetClassName = "ExternalNetwork";
   }

   public ExternalNetwork(String name) {
      this(name, false, false);
      assetClassName = "ExternalNetwork";
   }


   public class IntrusionDetecion extends Defense {
   public IntrusionDetecion(String name, Boolean enabled) {
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
            return "externalNetwork.intrusionDetecion";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (c2Server != null) {
c2Server.obfuscatedData.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

   public class SignatureIdentification extends Defense {
   public SignatureIdentification(String name, Boolean enabled) {
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
            return "externalNetwork.signatureIdentification";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (c2Server != null) {
c2Server.obfuscatedData.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

   public class BypassNetworkDetection extends AttackStepMin {
   public BypassNetworkDetection(String name) {
      super(name);
      assetClassName = "ExternalNetwork";
   }
@Override
public void setExpectedParents() {
if (internalNetwork != null) {
addExpectedParent(internalNetwork.applicationLayerConnexion);
}
for (Computer computer_BOcQa : computer) {
addExpectedParent(computer_BOcQa.commonlyUsedPortsConnection);
}
if (c2Server != null) {
addExpectedParent(c2Server.obfuscatedData);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("ExternalNetwork.bypassNetworkDetection");
      }

   }

   public class DataExfiltrated extends AttackStepMin {
   public DataExfiltrated(String name) {
      super(name);
      assetClassName = "ExternalNetwork";
   }
@Override
public void setExpectedParents() {
if (internalNetwork != null) {
addExpectedParent(internalNetwork.dataExfiltration);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("ExternalNetwork.dataExfiltrated");
      }

   }

      public void addC2Server(C2Server c2Server) {
         this.c2Server = c2Server;
         c2Server.externalNetwork = this;
      }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.externalNetwork = this;
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.externalNetwork.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("c2Server")) {
         return c2Server.getClass().getName();
      }
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("c2Server")  && c2Server != null) {
         assets.add(c2Server);
         return assets;
      }
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
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
      if (c2Server != null) {
         assets.add(c2Server);
      }
      assets.addAll(computer);
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
