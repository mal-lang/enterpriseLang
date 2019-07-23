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
public class RemovableMedia extends Asset {
   public Employee employee;
   public Computer computer;

   public DataExfiltrated dataExfiltrated;

   public RemovableMedia() {
      super();
      AttackStep.allAttackSteps.remove(dataExfiltrated);
      dataExfiltrated = new DataExfiltrated(this.name);
      assetClassName = "RemovableMedia";
   }

   public RemovableMedia(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(dataExfiltrated);
      dataExfiltrated = new DataExfiltrated(this.name);
      assetClassName = "RemovableMedia";
   }


   public class DataExfiltrated extends AttackStepMax {
   public DataExfiltrated(String name) {
      super(name);
      assetClassName = "RemovableMedia";
   }
@Override
public void setExpectedParents() {
if (computer != null) {
addExpectedParent(computer.exfiltrationOverPhysicalMedium);
}
if (employee != null) {
addExpectedParent(employee._mediaInserted);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("RemovableMedia.dataExfiltrated");
      }

   }

      public void addEmployee(Employee employee) {
         this.employee = employee;
         employee.removableMedia.add(this);
      }

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.removableMedia.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("employee")) {
         return employee.getClass().getName();
      }
      if (roleName.equals("computer")) {
         return computer.getClass().getName();
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
      if (employee != null) {
         assets.add(employee);
      }
      if (computer != null) {
         assets.add(computer);
      }
      return assets;
   }
}
