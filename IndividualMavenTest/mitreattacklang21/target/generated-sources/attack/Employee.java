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
   public java.util.Set<Computer> computer = new HashSet<>();
   public java.util.Set<OS> os = new HashSet<>();

   public UserExecution userExecution;
   public TrainedUser trainedUser;
   public Test test;

   public Employee(Boolean trainedUserState) {
      super();
      if (trainedUser != null) {
         AttackStep.allAttackSteps.remove(trainedUser.disable);
      }
      Defense.allDefenses.remove(trainedUser);
      trainedUser = new TrainedUser(this.name, trainedUserState);
      AttackStep.allAttackSteps.remove(userExecution);
      userExecution = new UserExecution(this.name);
      AttackStep.allAttackSteps.remove(test);
      test = new Test(this.name);
      assetClassName = "Employee";
   }

   public Employee(String name, Boolean trainedUserState) {
      super(name);
      if (trainedUser != null) {
         AttackStep.allAttackSteps.remove(trainedUser.disable);
      }
      Defense.allDefenses.remove(trainedUser);
      trainedUser = new TrainedUser(this.name, trainedUserState);
      AttackStep.allAttackSteps.remove(userExecution);
      userExecution = new UserExecution(this.name);
      AttackStep.allAttackSteps.remove(test);
      test = new Test(this.name);
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


   public class UserExecution extends AttackStepMax {
   public UserExecution(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
for (OS oS_jKisg : os) {
addExpectedParent(oS_jKisg.antivirus.disable);
}
addExpectedParent(trainedUser.disable);
addExpectedParent(test);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_jJeau : computer) {
computer_jJeau.infectedComputer.updateTtc(this, ttc, activeAttackSteps);
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
}
   }
}

   public class Test extends AttackStepMin {
   public Test(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
userExecution.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.test");
      }

   }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.employee = this;
      }

      public void addOs(OS os) {
         this.os.add(os);
         os.employee = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
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
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
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
      assets.addAll(computer);
      assets.addAll(os);
      return assets;
   }
}
