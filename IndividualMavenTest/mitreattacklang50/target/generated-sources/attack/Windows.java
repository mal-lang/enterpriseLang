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
   public java.util.Set<User> user = new HashSet<>();
   public java.util.Set<WindowsAdministrator> windowsAdministrator = new HashSet<>();

   public UserSecuritySoftwareDiscovery userSecuritySoftwareDiscovery;
   public AdminSecuritySoftwareDiscovery adminSecuritySoftwareDiscovery;
   public Whitelisting whitelisting;

   public Windows(Boolean whitelistingState) {
      super();
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(userSecuritySoftwareDiscovery);
      userSecuritySoftwareDiscovery = new UserSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(adminSecuritySoftwareDiscovery);
      adminSecuritySoftwareDiscovery = new AdminSecuritySoftwareDiscovery(this.name);
      assetClassName = "Windows";
   }

   public Windows(String name, Boolean whitelistingState) {
      super(name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(userSecuritySoftwareDiscovery);
      userSecuritySoftwareDiscovery = new UserSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(adminSecuritySoftwareDiscovery);
      adminSecuritySoftwareDiscovery = new AdminSecuritySoftwareDiscovery(this.name);
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


   public class UserSecuritySoftwareDiscovery extends AttackStepMax {
   public UserSecuritySoftwareDiscovery(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (User user_VtVkZ : user) {
addExpectedParent(user_VtVkZ.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.userSecuritySoftwareDiscovery");
      }

   }

   public class AdminSecuritySoftwareDiscovery extends AttackStepMax {
   public AdminSecuritySoftwareDiscovery(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (WindowsAdministrator windowsAdministrator_puRoT : windowsAdministrator) {
addExpectedParent(windowsAdministrator_puRoT.systemRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.adminSecuritySoftwareDiscovery");
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
userSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
adminSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user.add(user);
         user.windows = this;
      }

      public void addWindowsAdministrator(WindowsAdministrator windowsAdministrator) {
         this.windowsAdministrator.add(windowsAdministrator);
         windowsAdministrator.windows = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("windowsAdministrator")) {
         for (Object o: windowsAdministrator) {
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
      if (roleName.equals("windowsAdministrator")  && windowsAdministrator != null) {
         assets.addAll(windowsAdministrator);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(user);
      assets.addAll(windowsAdministrator);
      return assets;
   }
}
