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
   public InternalNetwork internalNetwork;

   public DataCollected dataCollected;
   public DataCompressed dataCompressed;
   public DataEncrypted dataEncrypted;
   public _automatedExfiltration _automatedExfiltration;
   public ExfiltrationOverAternativeProtocol exfiltrationOverAternativeProtocol;

   public Computer() {
      super();
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataCompressed);
      dataCompressed = new DataCompressed(this.name);
      AttackStep.allAttackSteps.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name);
      AttackStep.allAttackSteps.remove(_automatedExfiltration);
      _automatedExfiltration = new _automatedExfiltration(this.name);
      AttackStep.allAttackSteps.remove(exfiltrationOverAternativeProtocol);
      exfiltrationOverAternativeProtocol = new ExfiltrationOverAternativeProtocol(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataCompressed);
      dataCompressed = new DataCompressed(this.name);
      AttackStep.allAttackSteps.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name);
      AttackStep.allAttackSteps.remove(_automatedExfiltration);
      _automatedExfiltration = new _automatedExfiltration(this.name);
      AttackStep.allAttackSteps.remove(exfiltrationOverAternativeProtocol);
      exfiltrationOverAternativeProtocol = new ExfiltrationOverAternativeProtocol(this.name);
      assetClassName = "Computer";
   }


   public class DataCollected extends AttackStepMin {
   public DataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataCollected");
      }

   }

   public class DataCompressed extends AttackStepMin {
   public DataCompressed(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataCompressed");
      }

   }

   public class DataEncrypted extends AttackStepMin {
   public DataEncrypted(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataEncrypted");
      }

   }

   public class _automatedExfiltration extends AttackStepMax {
   public _automatedExfiltration(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._automatedExfiltration");
      }

   }

   public class ExfiltrationOverAternativeProtocol extends AttackStepMin {
   public ExfiltrationOverAternativeProtocol(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(dataCollected);
addExpectedParent(dataCompressed);
addExpectedParent(dataEncrypted);
addExpectedParent(_automatedExfiltration);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (internalNetwork != null) {
internalNetwork.dataExfiltration.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.exfiltrationOverAternativeProtocol");
      }

   }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.computer.add(this);
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
