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
   public java.util.Set<User> user = new HashSet<>();
   public java.util.Set<Administrator> administrator = new HashSet<>();

   public Scripting scripting;
   public FileDiscovery fileDiscovery;
   public DirectoryDiscovery directoryDiscovery;
   public UploadRemoteFile uploadRemoteFile;
   public AutomatedCollection automatedCollection;
   public _automatedCollection _automatedCollection;
   public DataCollected dataCollected;
   public SensitiveDataCollected sensitiveDataCollected;
   public Whitelisting whitelisting;

   public Computer(Boolean whitelistingState) {
      super();
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(scripting);
      scripting = new Scripting(this.name);
      AttackStep.allAttackSteps.remove(fileDiscovery);
      fileDiscovery = new FileDiscovery(this.name);
      AttackStep.allAttackSteps.remove(directoryDiscovery);
      directoryDiscovery = new DirectoryDiscovery(this.name);
      AttackStep.allAttackSteps.remove(uploadRemoteFile);
      uploadRemoteFile = new UploadRemoteFile(this.name);
      AttackStep.allAttackSteps.remove(automatedCollection);
      automatedCollection = new AutomatedCollection(this.name);
      AttackStep.allAttackSteps.remove(_automatedCollection);
      _automatedCollection = new _automatedCollection(this.name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(sensitiveDataCollected);
      sensitiveDataCollected = new SensitiveDataCollected(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name, Boolean whitelistingState) {
      super(name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(scripting);
      scripting = new Scripting(this.name);
      AttackStep.allAttackSteps.remove(fileDiscovery);
      fileDiscovery = new FileDiscovery(this.name);
      AttackStep.allAttackSteps.remove(directoryDiscovery);
      directoryDiscovery = new DirectoryDiscovery(this.name);
      AttackStep.allAttackSteps.remove(uploadRemoteFile);
      uploadRemoteFile = new UploadRemoteFile(this.name);
      AttackStep.allAttackSteps.remove(automatedCollection);
      automatedCollection = new AutomatedCollection(this.name);
      AttackStep.allAttackSteps.remove(_automatedCollection);
      _automatedCollection = new _automatedCollection(this.name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(sensitiveDataCollected);
      sensitiveDataCollected = new SensitiveDataCollected(this.name);
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


   public class Scripting extends AttackStepMax {
   public Scripting(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.scripting");
      }

   }

   public class FileDiscovery extends AttackStepMax {
   public FileDiscovery(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.fileDiscovery");
      }

   }

   public class DirectoryDiscovery extends AttackStepMax {
   public DirectoryDiscovery(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.directoryDiscovery");
      }

   }

   public class UploadRemoteFile extends AttackStepMax {
   public UploadRemoteFile(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.uploadRemoteFile");
      }

   }

   public class AutomatedCollection extends AttackStepMin {
   public AutomatedCollection(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_VJoej : user) {
addExpectedParent(user_VJoej.userRights);
}
for (Administrator administrator_AGrPX : administrator) {
addExpectedParent(administrator_AGrPX.adminRights);
}
addExpectedParent(scripting);
addExpectedParent(fileDiscovery);
addExpectedParent(directoryDiscovery);
addExpectedParent(uploadRemoteFile);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.automatedCollection");
      }

   }

   public class _automatedCollection extends AttackStepMax {
   public _automatedCollection(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(automatedCollection);
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataCollected.updateTtc(this, ttc, activeAttackSteps);
sensitiveDataCollected.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._automatedCollection");
      }

   }

   public class DataCollected extends AttackStepMin {
   public DataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(_automatedCollection);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataCollected");
      }

   }

   public class SensitiveDataCollected extends AttackStepMax {
   public SensitiveDataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (Administrator administrator_ZswwC : administrator) {
addExpectedParent(administrator_ZswwC.adminRights);
}
addExpectedParent(_automatedCollection);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.sensitiveDataCollected");
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
_automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user.add(user);
         user.computer = this;
      }

      public void addAdministrator(Administrator administrator) {
         this.administrator.add(administrator);
         administrator.computer = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("administrator")) {
         for (Object o: administrator) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
         return assets;
      }
      if (roleName.equals("administrator")  && administrator != null) {
         assets.addAll(administrator);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(user);
      assets.addAll(administrator);
      return assets;
   }
}
