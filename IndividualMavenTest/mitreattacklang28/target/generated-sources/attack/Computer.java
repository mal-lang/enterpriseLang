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
   public AutomatedExfiltration automatedExfiltration;
   public _automatedExfiltration _automatedExfiltration;
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
      AttackStep.allAttackSteps.remove(automatedExfiltration);
      automatedExfiltration = new AutomatedExfiltration(this.name);
      AttackStep.allAttackSteps.remove(_automatedExfiltration);
      _automatedExfiltration = new _automatedExfiltration(this.name);
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
      AttackStep.allAttackSteps.remove(automatedExfiltration);
      automatedExfiltration = new AutomatedExfiltration(this.name);
      AttackStep.allAttackSteps.remove(_automatedExfiltration);
      _automatedExfiltration = new _automatedExfiltration(this.name);
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
automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
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
automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
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
automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataEncrypted");
      }

   }

   public class AutomatedExfiltration extends AttackStepMin {
   public AutomatedExfiltration(String name) {
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
_automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.automatedExfiltration");
      }

   }

   public class _automatedExfiltration extends AttackStepMax {
   public _automatedExfiltration(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(automatedExfiltration);
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._automatedExfiltration");
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
_automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
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
