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
   public C2Server c2Server;

   public NetworkIntrusionDetection networkIntrusionDetection;

   public InternalNetwork(Boolean networkIntrusionDetectionState) {
      super();
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name, Boolean networkIntrusionDetectionState) {
      super(name);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
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
if (c2Server != null) {
c2Server.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

      public void addC2Server(C2Server c2Server) {
         this.c2Server = c2Server;
         c2Server.internalNetwork = this;
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
