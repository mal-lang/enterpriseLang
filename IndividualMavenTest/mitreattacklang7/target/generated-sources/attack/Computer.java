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
   public User user;
   public Administrator administrator;

   public UserDataDestruction userDataDestruction;
   public AdminDataDestruction adminDataDestruction;
   public Whitelisting whitelisting;
   public Backup backup;

   public Computer(Boolean whitelistingState, Boolean backupState) {
      super();
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (backup != null) {
         AttackStep.allAttackSteps.remove(backup.disable);
      }
      Defense.allDefenses.remove(backup);
      backup = new Backup(this.name, backupState);
      AttackStep.allAttackSteps.remove(userDataDestruction);
      userDataDestruction = new UserDataDestruction(this.name);
      AttackStep.allAttackSteps.remove(adminDataDestruction);
      adminDataDestruction = new AdminDataDestruction(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name, Boolean whitelistingState, Boolean backupState) {
      super(name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (backup != null) {
         AttackStep.allAttackSteps.remove(backup.disable);
      }
      Defense.allDefenses.remove(backup);
      backup = new Backup(this.name, backupState);
      AttackStep.allAttackSteps.remove(userDataDestruction);
      userDataDestruction = new UserDataDestruction(this.name);
      AttackStep.allAttackSteps.remove(adminDataDestruction);
      adminDataDestruction = new AdminDataDestruction(this.name);
      assetClassName = "Computer";
   }

   public Computer() {
      this(false, false);
      assetClassName = "Computer";
   }

   public Computer(String name) {
      this(name, false, false);
      assetClassName = "Computer";
   }


   public class UserDataDestruction extends AttackStepMax {
   public UserDataDestruction(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
addExpectedParent(backup.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.userDataDestruction");
      }

   }

   public class AdminDataDestruction extends AttackStepMax {
   public AdminDataDestruction(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
addExpectedParent(whitelisting.disable);
addExpectedParent(backup.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.adminDataDestruction");
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
userDataDestruction.updateTtc(this, ttc, activeAttackSteps);
adminDataDestruction.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class Backup extends Defense {
   public Backup(String name, Boolean enabled) {
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
            return "computer.backup";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
userDataDestruction.updateTtc(this, ttc, activeAttackSteps);
adminDataDestruction.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user = user;
         user.computer.add(this);
      }

      public void addAdministrator(Administrator administrator) {
         this.administrator = administrator;
         administrator.computer.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         return user.getClass().getName();
      }
      if (roleName.equals("administrator")) {
         return administrator.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("user")  && user != null) {
         assets.add(user);
         return assets;
      }
      if (roleName.equals("administrator")  && administrator != null) {
         assets.add(administrator);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (user != null) {
         assets.add(user);
      }
      if (administrator != null) {
         assets.add(administrator);
      }
      return assets;
   }
}
