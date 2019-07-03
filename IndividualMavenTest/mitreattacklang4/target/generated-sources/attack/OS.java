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
public class OS extends Asset {
   public User user;

   public BruteForce bruteForce;
   public LockoutPolicies lockoutPolicies;

   public OS(Boolean lockoutPoliciesState) {
      super();
      if (lockoutPolicies != null) {
         AttackStep.allAttackSteps.remove(lockoutPolicies.disable);
      }
      Defense.allDefenses.remove(lockoutPolicies);
      lockoutPolicies = new LockoutPolicies(this.name, lockoutPoliciesState);
      AttackStep.allAttackSteps.remove(bruteForce);
      bruteForce = new BruteForce(this.name);
      assetClassName = "OS";
   }

   public OS(String name, Boolean lockoutPoliciesState) {
      super(name);
      if (lockoutPolicies != null) {
         AttackStep.allAttackSteps.remove(lockoutPolicies.disable);
      }
      Defense.allDefenses.remove(lockoutPolicies);
      lockoutPolicies = new LockoutPolicies(this.name, lockoutPoliciesState);
      AttackStep.allAttackSteps.remove(bruteForce);
      bruteForce = new BruteForce(this.name);
      assetClassName = "OS";
   }

   public OS() {
      this(false);
      assetClassName = "OS";
   }

   public OS(String name) {
      this(name, false);
      assetClassName = "OS";
   }


   public class BruteForce extends AttackStepMax {
   public BruteForce(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(lockoutPolicies.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (user != null) {
user.userCredentials.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.bruteForce");
      }

   }

   public class LockoutPolicies extends Defense {
   public LockoutPolicies(String name, Boolean enabled) {
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
            return "oS.lockoutPolicies";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
bruteForce.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user = user;
         user.os.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         return user.getClass().getName();
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
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (user != null) {
         assets.add(user);
      }
      return assets;
   }
}
