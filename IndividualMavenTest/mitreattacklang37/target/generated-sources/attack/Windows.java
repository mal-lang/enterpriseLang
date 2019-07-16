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
   public java.util.Set<Computer> computer = new HashSet<>();

   public WebcamCollection webcamCollection;

   public Windows() {
      super();
      AttackStep.allAttackSteps.remove(webcamCollection);
      webcamCollection = new WebcamCollection(this.name);
      assetClassName = "Windows";
   }

   public Windows(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(webcamCollection);
      webcamCollection = new WebcamCollection(this.name);
      assetClassName = "Windows";
   }


   public class WebcamCollection extends AttackStepMin {
   public WebcamCollection(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (User user_mLDbw : user) {
addExpectedParent(user_mLDbw.userRights);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_ymBCD : computer) {
computer_ymBCD.collectVideo.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.webcamCollection");
      }

   }

      public void addUser(User user) {
         this.user.add(user);
         user.windows = this;
      }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.windows = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("computer")) {
         for (Object o: computer) {
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
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(user);
      assets.addAll(computer);
      return assets;
   }
}