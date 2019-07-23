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

   public DataCollected dataCollected;
   public DataCompressed dataCompressed;
   public DataEncrypted dataEncrypted;
   public DataStaged dataStaged;
   public _dataStaged _dataStaged;
   public Whitelisting whitelisting;

   public Computer(Boolean whitelistingState) {
      super();
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataCompressed);
      dataCompressed = new DataCompressed(this.name);
      AttackStep.allAttackSteps.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name);
      AttackStep.allAttackSteps.remove(dataStaged);
      dataStaged = new DataStaged(this.name);
      AttackStep.allAttackSteps.remove(_dataStaged);
      _dataStaged = new _dataStaged(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name, Boolean whitelistingState) {
      super(name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataCompressed);
      dataCompressed = new DataCompressed(this.name);
      AttackStep.allAttackSteps.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name);
      AttackStep.allAttackSteps.remove(dataStaged);
      dataStaged = new DataStaged(this.name);
      AttackStep.allAttackSteps.remove(_dataStaged);
      _dataStaged = new _dataStaged(this.name);
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


   public class DataCollected extends AttackStepMin {
   public DataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataStaged.updateTtc(this, ttc, activeAttackSteps);
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
dataStaged.updateTtc(this, ttc, activeAttackSteps);
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
dataStaged.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataEncrypted");
      }

   }

   public class DataStaged extends AttackStepMin {
   public DataStaged(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(dataCollected);
addExpectedParent(dataCompressed);
addExpectedParent(dataEncrypted);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_dataStaged.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataStaged");
      }

   }

   public class _dataStaged extends AttackStepMax {
   public _dataStaged(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(dataStaged);
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._dataStaged");
      }

   }

   public class Whitelisting extends Defense {
   public Whitelisting(String name, Boolean enabled) {
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
            return "computer.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_dataStaged.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      return assets;
   }
}
