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
   public WindowsAdmin windowsAdministrator;
   public Administrator Administrator;

   public CreateService createService;
   public Whitelisting whitelisting;
   public ExecuteService executeService;
   public Persistance persistance;

   public Windows(Boolean whitelistingState) {
      super();
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(createService);
      createService = new CreateService(this.name);
      AttackStep.allAttackSteps.remove(executeService);
      executeService = new ExecuteService(this.name);
      AttackStep.allAttackSteps.remove(persistance);
      persistance = new Persistance(this.name);
      assetClassName = "Windows";
   }

   public Windows(String name, Boolean whitelistingState) {
      super(name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(createService);
      createService = new CreateService(this.name);
      AttackStep.allAttackSteps.remove(executeService);
      executeService = new ExecuteService(this.name);
      AttackStep.allAttackSteps.remove(persistance);
      persistance = new Persistance(this.name);
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


   public class CreateService extends AttackStepMax {
   public CreateService(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (Administrator != null) {
addExpectedParent(Administrator.adminRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
executeService.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.createService");
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
            return "windows.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
createService.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class ExecuteService extends AttackStepMax {
   public ExecuteService(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsAdministrator != null) {
addExpectedParent(windowsAdministrator.systemRights);
}
addExpectedParent(createService);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
persistance.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.executeService");
      }

   }

   public class Persistance extends AttackStepMin {
   public Persistance(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
addExpectedParent(executeService);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.persistance");
      }

   }

      public void addWindowsAdministrator(WindowsAdmin windowsAdministrator) {
         this.windowsAdministrator = windowsAdministrator;
         windowsAdministrator.windows.add(this);
      }

      public void addAdministrator(Administrator Administrator) {
         this.Administrator = Administrator;
         Administrator.windows.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("windowsAdministrator")) {
         return windowsAdministrator.getClass().getName();
      }
      if (roleName.equals("Administrator")) {
         return Administrator.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("windowsAdministrator")  && windowsAdministrator != null) {
         assets.add(windowsAdministrator);
         return assets;
      }
      if (roleName.equals("Administrator")  && Administrator != null) {
         assets.add(Administrator);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (windowsAdministrator != null) {
         assets.add(windowsAdministrator);
      }
      if (Administrator != null) {
         assets.add(Administrator);
      }
      return assets;
   }
}
