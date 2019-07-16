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
public class MacOS extends Asset {
   public java.util.Set<User> user = new HashSet<>();
   public java.util.Set<Root> root = new HashSet<>();

   public UserSecuritySoftwareDiscovery userSecuritySoftwareDiscovery;
   public AdminSecuritySoftwareDiscovery adminSecuritySoftwareDiscovery;
   public Whitelisting whitelisting;

   public MacOS(Boolean whitelistingState) {
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
      assetClassName = "MacOS";
   }

   public MacOS(String name, Boolean whitelistingState) {
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
      assetClassName = "MacOS";
   }

   public MacOS() {
      this(false);
      assetClassName = "MacOS";
   }

   public MacOS(String name) {
      this(name, false);
      assetClassName = "MacOS";
   }


   public class UserSecuritySoftwareDiscovery extends AttackStepMax {
   public UserSecuritySoftwareDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
@Override
public void setExpectedParents() {
for (User user_LSfxd : user) {
addExpectedParent(user_LSfxd.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("MacOS.userSecuritySoftwareDiscovery");
      }

   }

   public class AdminSecuritySoftwareDiscovery extends AttackStepMax {
   public AdminSecuritySoftwareDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
@Override
public void setExpectedParents() {
for (Root root_fFZWl : root) {
addExpectedParent(root_fFZWl.rootRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("MacOS.adminSecuritySoftwareDiscovery");
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
            return "macOS.whitelisting";
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
         user.macOS = this;
      }

      public void addRoot(Root root) {
         this.root.add(root);
         root.macOS = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("root")) {
         for (Object o: root) {
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
      if (roleName.equals("root")  && root != null) {
         assets.addAll(root);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(user);
      assets.addAll(root);
      return assets;
   }
}
