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
   public java.util.Set<Administrator> administrator = new HashSet<>();

   public DiskStructureWipe diskStructureWipe;
   public Backup backup;
   public Whitelisting whitelisting;

   public Computer(Boolean backupState, Boolean whitelistingState) {
      super();
      if (backup != null) {
         AttackStep.allAttackSteps.remove(backup.disable);
      }
      Defense.allDefenses.remove(backup);
      backup = new Backup(this.name, backupState);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(diskStructureWipe);
      diskStructureWipe = new DiskStructureWipe(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name, Boolean backupState, Boolean whitelistingState) {
      super(name);
      if (backup != null) {
         AttackStep.allAttackSteps.remove(backup.disable);
      }
      Defense.allDefenses.remove(backup);
      backup = new Backup(this.name, backupState);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(diskStructureWipe);
      diskStructureWipe = new DiskStructureWipe(this.name);
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


   public class DiskStructureWipe extends AttackStepMax {
   public DiskStructureWipe(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (Administrator administrator_zztqX : administrator) {
addExpectedParent(administrator_zztqX.adminRights);
}
addExpectedParent(backup.disable);
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.diskStructureWipe");
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
diskStructureWipe.updateTtc(this, ttc, activeAttackSteps);
}
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
diskStructureWipe.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addAdministrator(Administrator administrator) {
         this.administrator.add(administrator);
         administrator.computer = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
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
      assets.addAll(administrator);
      return assets;
   }
}
