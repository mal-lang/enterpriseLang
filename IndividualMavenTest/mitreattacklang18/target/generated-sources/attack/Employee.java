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
   public java.util.Set<User> user = new HashSet<>();
   public java.util.Set<Computer> computer = new HashSet<>();

   public InsertMedia insertMedia;
   public UserExecution userExecution;
   public TrainedUser trainedUser;
   public ManualManipulation manualManipulation;

   public Employee(Boolean trainedUserState) {
      super();
      if (trainedUser != null) {
         AttackStep.allAttackSteps.remove(trainedUser.disable);
      }
      Defense.allDefenses.remove(trainedUser);
      trainedUser = new TrainedUser(this.name, trainedUserState);
      AttackStep.allAttackSteps.remove(insertMedia);
      insertMedia = new InsertMedia(this.name);
      AttackStep.allAttackSteps.remove(userExecution);
      userExecution = new UserExecution(this.name);
      AttackStep.allAttackSteps.remove(manualManipulation);
      manualManipulation = new ManualManipulation(this.name);
      assetClassName = "Employee";
   }

   public Employee(String name, Boolean trainedUserState) {
      super(name);
      if (trainedUser != null) {
         AttackStep.allAttackSteps.remove(trainedUser.disable);
      }
      Defense.allDefenses.remove(trainedUser);
      trainedUser = new TrainedUser(this.name, trainedUserState);
      AttackStep.allAttackSteps.remove(insertMedia);
      insertMedia = new InsertMedia(this.name);
      AttackStep.allAttackSteps.remove(userExecution);
      userExecution = new UserExecution(this.name);
      AttackStep.allAttackSteps.remove(manualManipulation);
      manualManipulation = new ManualManipulation(this.name);
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


   public class InsertMedia extends AttackStepMin {
   public InsertMedia(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
for (RemovableMedia removableMedia_PkBgA : removableMedia) {
addExpectedParent(removableMedia_PkBgA.infectedMedia);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
userExecution.updateTtc(this, ttc, activeAttackSteps);
manualManipulation.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.insertMedia");
      }

   }

   public class UserExecution extends AttackStepMax {
   public UserExecution(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
addExpectedParent(insertMedia);
addExpectedParent(trainedUser.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_PZIId : computer) {
computer_PZIId.infectedWindowsComputer.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.userExecution");
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
userExecution.updateTtc(this, ttc, activeAttackSteps);
manualManipulation.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class ManualManipulation extends AttackStepMax {
   public ManualManipulation(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
addExpectedParent(insertMedia);
addExpectedParent(trainedUser.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (User user_MHzVo : user) {
user_MHzVo.userRights.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.manualManipulation");
      }

   }

      public void addRemovableMedia(RemovableMedia removableMedia) {
         this.removableMedia.add(removableMedia);
         removableMedia.employee = this;
      }

      public void addUser(User user) {
         this.user.add(user);
         user.employee = this;
      }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.employee = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("removableMedia")) {
         for (Object o: removableMedia) {
            return o.getClass().getName();
         }
      }
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
      if (roleName.equals("removableMedia")  && removableMedia != null) {
         assets.addAll(removableMedia);
         return assets;
      }
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
      assets.addAll(removableMedia);
      assets.addAll(user);
      assets.addAll(computer);
      return assets;
   }
}
