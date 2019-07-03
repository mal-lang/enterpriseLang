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
   public java.util.Set<OS> os = new HashSet<>();

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
for (OS oS_WmiFz : os) {
oS_WmiFz.bruteForce.updateTtc(this, ttc, activeAttackSteps);
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
public void setExpectedParents() {
for (OS oS_DDnUP : os) {
addExpectedParent(oS_DDnUP.bruteForce);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("User.userCredentials");
      }

   }

      public void addOs(OS os) {
         this.os.add(os);
         os.user = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("os")) {
         for (Object o: os) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("os")  && os != null) {
         assets.addAll(os);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(os);
      return assets;
   }
}
