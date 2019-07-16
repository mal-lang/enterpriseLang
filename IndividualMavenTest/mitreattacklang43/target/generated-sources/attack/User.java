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
   public Computer computer;

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
if (computer != null) {
computer.automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("User.userRights");
      }

   }

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.user.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("computer")) {
         return computer.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("computer")  && computer != null) {
         assets.add(computer);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (computer != null) {
         assets.add(computer);
      }
      return assets;
   }
}
