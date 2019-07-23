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
public class User extends Asset {
   public MacOS macOS;
   public Linux linux;

   public UserRights userRights;

   public User() {
      super();
      AttackStep.allAttackSteps.remove(userRights);
      userRights = new UserRights(this.name);
      assetClassName = "User";
   }

   public User(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(userRights);
      userRights = new UserRights(this.name);
      assetClassName = "User";
   }


   public class UserRights extends AttackStepMin {
   public UserRights(String name) {
      super(name);
      assetClassName = "User";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (macOS != null) {
macOS.spaceAfterFileName.updateTtc(this, ttc, activeAttackSteps);
}
if (linux != null) {
linux.spaceAfterFileName.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("User.userRights");
      }

   }

      public void addMacOS(MacOS macOS) {
         this.macOS = macOS;
         macOS.user.add(this);
      }

      public void addLinux(Linux linux) {
         this.linux = linux;
         linux.user.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("macOS")) {
         return macOS.getClass().getName();
      }
      if (roleName.equals("linux")) {
         return linux.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("macOS")  && macOS != null) {
         assets.add(macOS);
         return assets;
      }
      if (roleName.equals("linux")  && linux != null) {
         assets.add(linux);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (macOS != null) {
         assets.add(macOS);
      }
      if (linux != null) {
         assets.add(linux);
      }
      return assets;
   }
}
