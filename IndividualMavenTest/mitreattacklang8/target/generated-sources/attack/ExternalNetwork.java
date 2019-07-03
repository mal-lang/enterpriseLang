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

   public IntrusionDetection intrusionDetection;
   public SignatureIdentification signatureIdentification;
   public BypassNetworkDetection bypassNetworkDetection;

   public ExternalNetwork(Boolean intrusionDetectionState, Boolean signatureIdentificationState) {
      super();
      if (intrusionDetection != null) {
         AttackStep.allAttackSteps.remove(intrusionDetection.disable);
      }
      Defense.allDefenses.remove(intrusionDetection);
      intrusionDetection = new IntrusionDetection(this.name, intrusionDetectionState);
      if (signatureIdentification != null) {
         AttackStep.allAttackSteps.remove(signatureIdentification.disable);
      }
      Defense.allDefenses.remove(signatureIdentification);
      signatureIdentification = new SignatureIdentification(this.name, signatureIdentificationState);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      assetClassName = "ExternalNetwork";
   }

   public ExternalNetwork(String name, Boolean intrusionDetectionState, Boolean signatureIdentificationState) {
      super(name);
      if (intrusionDetection != null) {
         AttackStep.allAttackSteps.remove(intrusionDetection.disable);
      }
      Defense.allDefenses.remove(intrusionDetection);
      intrusionDetection = new IntrusionDetection(this.name, intrusionDetectionState);
      if (signatureIdentification != null) {
         AttackStep.allAttackSteps.remove(signatureIdentification.disable);
      }
      Defense.allDefenses.remove(signatureIdentification);
      signatureIdentification = new SignatureIdentification(this.name, signatureIdentificationState);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
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


   public class IntrusionDetection extends Defense {
   public IntrusionDetection(String name, Boolean enabled) {
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
            return "externalNetwork.intrusionDetection";
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
if (c2Server != null) {
addExpectedParent(c2Server.obfuscatedData);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("ExternalNetwork.bypassNetworkDetection");
      }

   }

      public void addC2Server(C2Server c2Server) {
         this.c2Server = c2Server;
         c2Server.externalNetwork = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("c2Server")) {
         return c2Server.getClass().getName();
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
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (c2Server != null) {
         assets.add(c2Server);
      }
      return assets;
   }
}
