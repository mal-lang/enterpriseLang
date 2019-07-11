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
   public Windows windows;
   public InternalNetwork internalNetwork;

   public UserRights userRights;
   public UserCredentials userCredentials;

   public User() {
      super();
      AttackStep.allAttackSteps.remove(userRights);
      userRights = new UserRights(this.name);
      AttackStep.allAttackSteps.remove(userCredentials);
      userCredentials = new UserCredentials(this.name);
      assetClassName = "User";
   }

   public User(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(userRights);
      userRights = new UserRights(this.name);
      AttackStep.allAttackSteps.remove(userCredentials);
      userCredentials = new UserCredentials(this.name);
      assetClassName = "User";
   }


   public class UserRights extends AttackStepMin {
   public UserRights(String name) {
      super(name);
      assetClassName = "User";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (windows != null) {
windows.emailStorageCollection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("User.userRights");
      }

   }

   public class UserCredentials extends AttackStepMin {
   public UserCredentials(String name) {
      super(name);
      assetClassName = "User";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (windows != null) {
windows.outlookEmailCollection.updateTtc(this, ttc, activeAttackSteps);
}
if (internalNetwork != null) {
internalNetwork.exchangeServerCollection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("User.userCredentials");
      }

   }

      public void addWindows(Windows windows) {
         this.windows = windows;
         windows.user.add(this);
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.user.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("windows")) {
         return windows.getClass().getName();
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("windows")  && windows != null) {
         assets.add(windows);
         return assets;
      }
      if (roleName.equals("internalNetwork")  && internalNetwork != null) {
         assets.add(internalNetwork);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (windows != null) {
         assets.add(windows);
      }
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
