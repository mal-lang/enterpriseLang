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

   public UserDiskWiped userDiskWiped;
   public AdminDiskWiped adminDiskWiped;
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
      AttackStep.allAttackSteps.remove(userDiskWiped);
      userDiskWiped = new UserDiskWiped(this.name);
      AttackStep.allAttackSteps.remove(adminDiskWiped);
      adminDiskWiped = new AdminDiskWiped(this.name);
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
      AttackStep.allAttackSteps.remove(userDiskWiped);
      userDiskWiped = new UserDiskWiped(this.name);
      AttackStep.allAttackSteps.remove(adminDiskWiped);
      adminDiskWiped = new AdminDiskWiped(this.name);
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


   public class UserDiskWiped extends AttackStepMax {
   public UserDiskWiped(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(whitelisting.disable);
addExpectedParent(backup.disable);
for (User user_cjFPo : user) {
addExpectedParent(user_cjFPo.userRights);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.userDiskWiped");
      }

   }

   public class AdminDiskWiped extends AttackStepMax {
   public AdminDiskWiped(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(whitelisting.disable);
addExpectedParent(backup.disable);
for (Administrator administrator_nfAuj : administrator) {
addExpectedParent(administrator_nfAuj.adminRights);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.adminDiskWiped");
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
userDiskWiped.updateTtc(this, ttc, activeAttackSteps);
adminDiskWiped.updateTtc(this, ttc, activeAttackSteps);
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
userDiskWiped.updateTtc(this, ttc, activeAttackSteps);
adminDiskWiped.updateTtc(this, ttc, activeAttackSteps);
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
