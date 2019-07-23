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
   public Employee employee;

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
public void setExpectedParents() {
if (employee != null) {
addExpectedParent(employee.manualManipulation);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("User.userRights");
      }

   }

      public void addEmployee(Employee employee) {
         this.employee = employee;
         employee.user.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("employee")) {
         return employee.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("employee")  && employee != null) {
         assets.add(employee);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (employee != null) {
         assets.add(employee);
      }
      return assets;
   }
}
