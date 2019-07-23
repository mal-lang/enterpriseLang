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
public class C2Server extends Asset {
   public Computer computer;
   public ExternalNetwork externalNetwork;
   public InternalNetwork internalNetwork;

   public C2Connected c2Connected;
   public ObfuscatedData obfuscatedData;
   public DataExfiltrated dataExfiltrated;
   public ThresholdAlert thresholdAlert;

   public C2Server(Boolean thresholdAlertState) {
      super();
      if (thresholdAlert != null) {
         AttackStep.allAttackSteps.remove(thresholdAlert.disable);
      }
      Defense.allDefenses.remove(thresholdAlert);
      thresholdAlert = new ThresholdAlert(this.name, thresholdAlertState);
      AttackStep.allAttackSteps.remove(c2Connected);
      c2Connected = new C2Connected(this.name);
      AttackStep.allAttackSteps.remove(obfuscatedData);
      obfuscatedData = new ObfuscatedData(this.name);
      AttackStep.allAttackSteps.remove(dataExfiltrated);
      dataExfiltrated = new DataExfiltrated(this.name);
      assetClassName = "C2Server";
   }

   public C2Server(String name, Boolean thresholdAlertState) {
      super(name);
      if (thresholdAlert != null) {
         AttackStep.allAttackSteps.remove(thresholdAlert.disable);
      }
      Defense.allDefenses.remove(thresholdAlert);
      thresholdAlert = new ThresholdAlert(this.name, thresholdAlertState);
      AttackStep.allAttackSteps.remove(c2Connected);
      c2Connected = new C2Connected(this.name);
      AttackStep.allAttackSteps.remove(obfuscatedData);
      obfuscatedData = new ObfuscatedData(this.name);
      AttackStep.allAttackSteps.remove(dataExfiltrated);
      dataExfiltrated = new DataExfiltrated(this.name);
      assetClassName = "C2Server";
   }

   public C2Server() {
      this(false);
      assetClassName = "C2Server";
   }

   public C2Server(String name) {
      this(name, false);
      assetClassName = "C2Server";
   }


   public class C2Connected extends AttackStepMin {
   public C2Connected(String name) {
      super(name);
      assetClassName = "C2Server";
   }
@Override
public void setExpectedParents() {
if (internalNetwork != null) {
addExpectedParent(internalNetwork.c2Connexion);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
obfuscatedData.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("C2Server.c2Connected");
      }

   }

   public class ObfuscatedData extends AttackStepMax {
   public ObfuscatedData(String name) {
      super(name);
      assetClassName = "C2Server";
   }
@Override
public void setExpectedParents() {
if (externalNetwork != null) {
addExpectedParent(externalNetwork.intrusionDetecion.disable);
}
if (externalNetwork != null) {
addExpectedParent(externalNetwork.signatureIdentification.disable);
}
addExpectedParent(c2Connected);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (externalNetwork != null) {
externalNetwork.bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
}
if (internalNetwork != null) {
internalNetwork.bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("C2Server.obfuscatedData");
      }

   }

   public class DataExfiltrated extends AttackStepMax {
   public DataExfiltrated(String name) {
      super(name);
      assetClassName = "C2Server";
   }
@Override
public void setExpectedParents() {
if (internalNetwork != null) {
addExpectedParent(internalNetwork.networkIntrusionDetection.disable);
}
if (computer != null) {
addExpectedParent(computer.exfiltrationOverC2);
}
if (computer != null) {
addExpectedParent(computer.dataSizedTransfer);
}
addExpectedParent(thresholdAlert.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("C2Server.dataExfiltrated");
      }

   }

   public class ThresholdAlert extends Defense {
   public ThresholdAlert(String name, Boolean enabled) {
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
            return "c2Server.thresholdAlert";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.c2Server = this;
      }

      public void addExternalNetwork(ExternalNetwork externalNetwork) {
         this.externalNetwork = externalNetwork;
         externalNetwork.c2Server = this;
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.c2Server = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("computer")) {
         return computer.getClass().getName();
      }
      if (roleName.equals("externalNetwork")) {
         return externalNetwork.getClass().getName();
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("computer")  && computer != null) {
         assets.add(computer);
         return assets;
      }
      if (roleName.equals("externalNetwork")  && externalNetwork != null) {
         assets.add(externalNetwork);
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
      if (computer != null) {
         assets.add(computer);
      }
      if (externalNetwork != null) {
         assets.add(externalNetwork);
      }
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
