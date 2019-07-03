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
   public java.util.Set<Browser> browser = new HashSet<>();
   public Adversary adversary;

   public SpearphishingAttachmentDownload spearphishingAttachmentDownload;
   public TrainedEmployee trainedEmployee;

   public Employee(Boolean trainedEmployeeState) {
      super();
      if (trainedEmployee != null) {
         AttackStep.allAttackSteps.remove(trainedEmployee.disable);
      }
      Defense.allDefenses.remove(trainedEmployee);
      trainedEmployee = new TrainedEmployee(this.name, trainedEmployeeState);
      AttackStep.allAttackSteps.remove(spearphishingAttachmentDownload);
      spearphishingAttachmentDownload = new SpearphishingAttachmentDownload(this.name);
      assetClassName = "Employee";
   }

   public Employee(String name, Boolean trainedEmployeeState) {
      super(name);
      if (trainedEmployee != null) {
         AttackStep.allAttackSteps.remove(trainedEmployee.disable);
      }
      Defense.allDefenses.remove(trainedEmployee);
      trainedEmployee = new TrainedEmployee(this.name, trainedEmployeeState);
      AttackStep.allAttackSteps.remove(spearphishingAttachmentDownload);
      spearphishingAttachmentDownload = new SpearphishingAttachmentDownload(this.name);
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


   public class SpearphishingAttachmentDownload extends AttackStepMax {
   public SpearphishingAttachmentDownload(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
addExpectedParent(trainedEmployee.disable);
if (adversary != null) {
addExpectedParent(adversary.spearphishingAttachmentAttack);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Browser browser_TXdno : browser) {
browser_TXdno.spearphishingAttachment.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.spearphishingAttachmentDownload");
      }

   }

   public class TrainedEmployee extends Defense {
   public TrainedEmployee(String name, Boolean enabled) {
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
            return "employee.trainedEmployee";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
spearphishingAttachmentDownload.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addBrowser(Browser browser) {
         this.browser.add(browser);
         browser.employee = this;
      }

      public void addAdversary(Adversary adversary) {
         this.adversary = adversary;
         adversary.employee.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("browser")) {
         for (Object o: browser) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("adversary")) {
         return adversary.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("browser")  && browser != null) {
         assets.addAll(browser);
         return assets;
      }
      if (roleName.equals("adversary")  && adversary != null) {
         assets.add(adversary);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(browser);
      if (adversary != null) {
         assets.add(adversary);
      }
      return assets;
   }
}
