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
public class Employee extends Asset {
   public java.util.Set<RemovableMedia> removableMedia = new HashSet<>();

   public MediaInserted mediaInserted;
   public _mediaInserted _mediaInserted;
   public TrainedUser trainedUser;

   public Employee(Boolean trainedUserState) {
      super();
      if (trainedUser != null) {
         AttackStep.allAttackSteps.remove(trainedUser.disable);
      }
      Defense.allDefenses.remove(trainedUser);
      trainedUser = new TrainedUser(this.name, trainedUserState);
      AttackStep.allAttackSteps.remove(mediaInserted);
      mediaInserted = new MediaInserted(this.name);
      AttackStep.allAttackSteps.remove(_mediaInserted);
      _mediaInserted = new _mediaInserted(this.name);
      assetClassName = "Employee";
   }

   public Employee(String name, Boolean trainedUserState) {
      super(name);
      if (trainedUser != null) {
         AttackStep.allAttackSteps.remove(trainedUser.disable);
      }
      Defense.allDefenses.remove(trainedUser);
      trainedUser = new TrainedUser(this.name, trainedUserState);
      AttackStep.allAttackSteps.remove(mediaInserted);
      mediaInserted = new MediaInserted(this.name);
      AttackStep.allAttackSteps.remove(_mediaInserted);
      _mediaInserted = new _mediaInserted(this.name);
      assetClassName = "Employee";
   }

   public Employee() {
      this(false);
      assetClassName = "Employee";
   }

   public Employee(String name) {
      this(name, false);
      assetClassName = "Employee";
   }


   public class MediaInserted extends AttackStepMin {
   public MediaInserted(String name) {
      super(name);
      assetClassName = "Employee";
   }
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.mediaInserted");
      }

   }

   public class _mediaInserted extends AttackStepMax {
   public _mediaInserted(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
addExpectedParent(trainedUser.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (RemovableMedia removableMedia_ZXGsO : removableMedia) {
removableMedia_ZXGsO.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee._mediaInserted");
      }

   }

   public class TrainedUser extends Defense {
   public TrainedUser(String name, Boolean enabled) {
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
            return "employee.trainedUser";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_mediaInserted.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addRemovableMedia(RemovableMedia removableMedia) {
         this.removableMedia.add(removableMedia);
         removableMedia.employee = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("removableMedia")) {
         for (Object o: removableMedia) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("removableMedia")  && removableMedia != null) {
         assets.addAll(removableMedia);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(removableMedia);
      return assets;
   }
}
