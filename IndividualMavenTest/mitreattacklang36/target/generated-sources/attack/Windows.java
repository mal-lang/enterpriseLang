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
public class Windows extends Asset {
   public Computer computer;
   public java.util.Set<User> user = new HashSet<>();

   public EmailStorageCollection emailStorageCollection;
   public OutlookEmailCollection outlookEmailCollection;
   public DataEncryption dataEncryption;

   public Windows(Boolean dataEncryptionState) {
      super();
      if (dataEncryption != null) {
         AttackStep.allAttackSteps.remove(dataEncryption.disable);
      }
      Defense.allDefenses.remove(dataEncryption);
      dataEncryption = new DataEncryption(this.name, dataEncryptionState);
      AttackStep.allAttackSteps.remove(emailStorageCollection);
      emailStorageCollection = new EmailStorageCollection(this.name);
      AttackStep.allAttackSteps.remove(outlookEmailCollection);
      outlookEmailCollection = new OutlookEmailCollection(this.name);
      assetClassName = "Windows";
   }

   public Windows(String name, Boolean dataEncryptionState) {
      super(name);
      if (dataEncryption != null) {
         AttackStep.allAttackSteps.remove(dataEncryption.disable);
      }
      Defense.allDefenses.remove(dataEncryption);
      dataEncryption = new DataEncryption(this.name, dataEncryptionState);
      AttackStep.allAttackSteps.remove(emailStorageCollection);
      emailStorageCollection = new EmailStorageCollection(this.name);
      AttackStep.allAttackSteps.remove(outlookEmailCollection);
      outlookEmailCollection = new OutlookEmailCollection(this.name);
      assetClassName = "Windows";
   }

   public Windows() {
      this(false);
      assetClassName = "Windows";
   }

   public Windows(String name) {
      this(name, false);
      assetClassName = "Windows";
   }


   public class EmailStorageCollection extends AttackStepMax {
   public EmailStorageCollection(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (User user_CRwHp : user) {
addExpectedParent(user_CRwHp.userRights);
}
addExpectedParent(dataEncryption.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.emailStorageCollection");
      }

   }

   public class OutlookEmailCollection extends AttackStepMax {
   public OutlookEmailCollection(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (User user_IVCvi : user) {
addExpectedParent(user_IVCvi.userCredentials);
}
addExpectedParent(dataEncryption.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.outlookEmailCollection");
      }

   }

   public class DataEncryption extends Defense {
   public DataEncryption(String name, Boolean enabled) {
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
            return "windows.dataEncryption";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
emailStorageCollection.updateTtc(this, ttc, activeAttackSteps);
outlookEmailCollection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.windows = this;
      }

      public void addUser(User user) {
         this.user.add(user);
         user.windows = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("computer")) {
         return computer.getClass().getName();
      }
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
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
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
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
      assets.addAll(user);
      return assets;
   }
}
