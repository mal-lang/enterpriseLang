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
   public java.util.Set<OS> os = new HashSet<>();

   public UserExecution userExecution;

   public Employee() {
      super();
      AttackStep.allAttackSteps.remove(userExecution);
      userExecution = new UserExecution(this.name);
      assetClassName = "Employee";
   }

   public Employee(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(userExecution);
      userExecution = new UserExecution(this.name);
      assetClassName = "Employee";
   }


   public class UserExecution extends AttackStepMin {
   public UserExecution(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (OS oS_rOxkZ : os) {
oS_rOxkZ.scripting.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.userExecution");
      }

   }

      public void addOs(OS os) {
         this.os.add(os);
         os.employee.add(this);
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
