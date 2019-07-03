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
public class Linux extends Asset {
   public Administrator linuxAdministrator;

   public Bootkit bootkit;
   public SecureBootProcess secureBootProcess;
   public Persistance persistance;

   public Linux(Boolean secureBootProcessState) {
      super();
      if (secureBootProcess != null) {
         AttackStep.allAttackSteps.remove(secureBootProcess.disable);
      }
      Defense.allDefenses.remove(secureBootProcess);
      secureBootProcess = new SecureBootProcess(this.name, secureBootProcessState);
      AttackStep.allAttackSteps.remove(bootkit);
      bootkit = new Bootkit(this.name);
      AttackStep.allAttackSteps.remove(persistance);
      persistance = new Persistance(this.name);
      assetClassName = "Linux";
   }

   public Linux(String name, Boolean secureBootProcessState) {
      super(name);
      if (secureBootProcess != null) {
         AttackStep.allAttackSteps.remove(secureBootProcess.disable);
      }
      Defense.allDefenses.remove(secureBootProcess);
      secureBootProcess = new SecureBootProcess(this.name, secureBootProcessState);
      AttackStep.allAttackSteps.remove(bootkit);
      bootkit = new Bootkit(this.name);
      AttackStep.allAttackSteps.remove(persistance);
      persistance = new Persistance(this.name);
      assetClassName = "Linux";
   }

   public Linux() {
      this(false);
      assetClassName = "Linux";
   }

   public Linux(String name) {
      this(name, false);
      assetClassName = "Linux";
   }


   public class Bootkit extends AttackStepMax {
   public Bootkit(String name) {
      super(name);
      assetClassName = "Linux";
   }
@Override
public void setExpectedParents() {
if (linuxAdministrator != null) {
addExpectedParent(linuxAdministrator.adminRights);
}
addExpectedParent(secureBootProcess.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
persistance.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Linux.bootkit");
      }

   }

   public class SecureBootProcess extends Defense {
   public SecureBootProcess(String name, Boolean enabled) {
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
            return "linux.secureBootProcess";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
bootkit.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class Persistance extends AttackStepMin {
   public Persistance(String name) {
      super(name);
      assetClassName = "Linux";
   }
@Override
public void setExpectedParents() {
addExpectedParent(bootkit);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Linux.persistance");
      }

   }

      public void addLinuxAdministrator(Administrator linuxAdministrator) {
         this.linuxAdministrator = linuxAdministrator;
         linuxAdministrator.linux.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("linuxAdministrator")) {
         return linuxAdministrator.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("linuxAdministrator")  && linuxAdministrator != null) {
         assets.add(linuxAdministrator);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (linuxAdministrator != null) {
         assets.add(linuxAdministrator);
      }
      return assets;
   }
}
